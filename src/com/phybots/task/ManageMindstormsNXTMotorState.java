/*
 * PROJECT: matereal at http://mr.digitalmuseum.jp/
 * ----------------------------------------------------------------------------
 *
 * Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is matereal.
 *
 * The Initial Developer of the Original Code is Jun KATO.
 * Portions created by the Initial Developer are
 * Copyright (C) 2009 Jun KATO. All Rights Reserved.
 *
 * Contributor(s): Jun KATO
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either of the GNU General Public License Version 2 or later (the "GPL"),
 * or the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 */
package com.phybots.task;

import java.util.List;

import javax.swing.JComponent;

import com.phybots.entity.MindstormsNXT;
import com.phybots.entity.MindstormsNXT.OutputState;
import com.phybots.entity.Resource;
import com.phybots.entity.MindstormsNXT.MindstormsNXTExtension;
import com.phybots.message.Event;
import com.phybots.message.RobotUpdateEvent;
import com.phybots.task.TaskAbstractImpl;

/**
 * Mindstorms NXT のモーターを制御するタスク。
 * <ul>
 * <li>{@link #isEditable()} がtrueのときはユーザの直接操作による姿勢制御を許可する。この際、基本的には姿勢を固定するような力をモーターにかけるが、ユーザがそこからある程度動かそうとしたら脱力する。その後はユーザが姿勢を決めてしばらく待つと改めて姿勢が固定される。<ul>
 * 	<li>「ある程度動かそうと」の閾値: {@link #getRotationThreshold()}</li>
 * 	<li>「しばらく待つと」の閾値: {@link #getTimeThreshold()}</li>
 * 		</ul></li>
 * <li>{@link #getRotationCount()} で現在の姿勢を表す角度値を取得できる。この値はNXT brickの電源が切れるたび 0 にリセットされる。（したがって、NXT brickの電源を入れるときには全てのモーターを初期位置にセットしておく必要がある。）</li>
 * <li>{@link #setRotationCount(int)} で姿勢を指定するとモーターを回転してそこまで持っていく。厳密に同じ角度まで持っていくことは不可能なので、あらかじめ指定した誤差未満になったら停止する。この制御が走っている最中は {@link #isRotating()} がtrueになる。<ul>
 * 	<li>「あらかじめ指定した誤差」の閾値: {@link #getRotationErrorThreshold()}</li>
 * 		</ul></li>
 * </ul>
 */
public class ManageMindstormsNXTMotorState extends TaskAbstractImpl {
	private static final int DEFAULT_ROTATION_ERROR_THRESHOLD = 15;
	private static final int DEFAULT_ROTATION_THRESHOLD = 5;
	private static final int DEFAULT_TIME_THRESHOLD = 7;

	private static final long serialVersionUID = -3034846848072940340L;
	private MindstormsNXTExtension ext;
	private int rotationErrorThreshold = DEFAULT_ROTATION_ERROR_THRESHOLD;
	private int rotationThreshold = DEFAULT_ROTATION_THRESHOLD;
	private int timeThreshold = DEFAULT_TIME_THRESHOLD;

	private OutputState outputState;

	private boolean isEditable;

	private int rotationCount;
	private int stableCount;
	private boolean isStable;

	private int targetRotationCount;
	private boolean isRotating;

	@Override
	public List<Class<? extends Resource>> getRequirements() {
		List<Class<? extends Resource>> requirements = super.getRequirements();
		requirements.add(MindstormsNXTExtension.class);
		return requirements;
	}

	public int getRotationErrorThreshold() {
		return rotationErrorThreshold;
	}

	public void setRotationErrorThreshold(int rotationErrorThreshold) {
		this.rotationErrorThreshold = rotationErrorThreshold;
	}

	public int getRotationThreshold() {
		return rotationThreshold;
	}

	public void setRotationThreshold(int rotationThreshold) {
		this.rotationThreshold = rotationThreshold;
	}

	public int getTimeThreshold() {
		return timeThreshold;
	}

	public void setTimeThreshold(int timeThreshold) {
		this.timeThreshold = timeThreshold;
	}

	@Override
	protected void onStart() {
		this.ext = getResourceMap().get(MindstormsNXTExtension.class);
		rotationCount = ext.getOutputState().rotationCount;
		stableCount = 0;
	}

	@Override
	protected void onStop() {
		ext.setOutputState((byte) 0, 0, 0, 0, 0, 0);
	}

	@Override
	public void run() {

		OutputState oldOutputState = outputState;
		outputState = ext.getOutputState();
		int count = outputState.rotationCount;

		if (isRotating) {
			int diff = targetRotationCount - outputState.rotationCount;
			int diffAbs = abs(diff);
			if (oldOutputState != null) {
				if (abs(oldOutputState.rotationCount - targetRotationCount) < diffAbs
						|| diffAbs < rotationErrorThreshold) {
					isRotating = false;
					makeStable(ext, true);
				} else if (diffAbs < outputState.tachoLimit / 2) {
					setRelativeRotation(diff);
				}
			}
		} else {

			if (diff(rotationCount, count) > rotationThreshold) {
				stableCount = 0;
			} else {
				stableCount ++;
			}

			if (isStable) {
				if (stableCount == 0 && isEditable) {
					makeStable(ext, false);
					isStable = false;
				}
			} else {
				if (stableCount > timeThreshold) {
					makeStable(ext, true);
					isStable = true;
				}
				rotationCount = count;
			}
		}

		Event e = new RobotUpdateEvent(getAssignedRobot(), ext.getPort().toString(), count);
		distributeEvent(e);
	}

	public void reset() {
		ext.setOutputState((byte) 0, 0, 0, 0, 0, 0);
	}

	public boolean isEditable() {
		return isEditable;
	}

	public void setEditable(boolean isEditable) {
		this.isEditable = isEditable;
		if (!isEditable) {
			makeStable(ext, true);
		}
	}

	public boolean isRotating() {
		return isRotating;
	}

	public int getRotationCount() {
		return rotationCount;
	}

	public void setRotationCount(int rotationCount) {
		if (outputState == null) {
			outputState = ext.getOutputState();
		}
		int diff = rotationCount - outputState.rotationCount;
		if (diff == 0) {
			return;
		}
		isRotating = true;
		targetRotationCount = rotationCount;
		setRelativeRotation(diff);
	}

	private void setRelativeRotation(int diff) {
		int diffAbs = abs(diff);
		int power = diffAbs > 90 ? 20 :
			(diffAbs > 45 ? 10 :
				(diffAbs > 20 ? 5 : 3));
		// System.out.println(ext.getPort() + ": " + diff + " /w pow " + power);
		ext.setOutputState(
				(byte) (diff > 0 ? power : -power),
				MindstormsNXT.MOTORON | MindstormsNXT.BRAKE | MindstormsNXT.REGULATED,
				MindstormsNXT.REGULATION_MODE_MOTOR_SPEED,
				0,
				MindstormsNXT.MOTOR_RUN_STATE_RUNNING,
				0);
	}

	public boolean isStable() {
		return isStable;
	}

	private int abs(int a) {
		return a > 0 ? a : -a;
	}

	private int diff(int a, int b) {
		int diff = a - b;
		return diff < 0 ? -diff : diff;
	}

	private boolean makeStable(MindstormsNXTExtension ext, boolean isStable) {
		return ext.setOutputState(
				(byte) 0,
				isStable ? (MindstormsNXT.MOTORON | MindstormsNXT.BRAKE | MindstormsNXT.REGULATED) : 0,
				isStable ? MindstormsNXT.REGULATION_MODE_MOTOR_SPEED : 0,
				0,
				isStable ? MindstormsNXT.MOTOR_RUN_STATE_RUNNING : 0,
				0);
	}

	@Override
	public JComponent getConfigurationComponent() {
		return ext == null ? super.getConfigurationComponent() : ext.getConfigurationComponent();
	}
}