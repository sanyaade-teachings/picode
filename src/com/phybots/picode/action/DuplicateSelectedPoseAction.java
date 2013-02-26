package com.phybots.picode.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.phybots.picode.PicodeMain;
import com.phybots.picode.api.GlobalPoseLibrary;
import com.phybots.picode.api.Pose;
import com.phybots.picode.api.PoserManager;

public class DuplicateSelectedPoseAction extends AbstractAction {
	private static final long serialVersionUID = -5297099138353745191L;
	private transient PicodeMain picodeMain;

	public DuplicateSelectedPoseAction(PicodeMain picodeMain) {
		this.picodeMain = picodeMain;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Pose pose = picodeMain.getFrame().getSelectedPose();
		GlobalPoseLibrary poseLibrary = PoserManager.getInstance().getPoseLibrary();
		poseLibrary.duplicatePose(pose);
	}
}
