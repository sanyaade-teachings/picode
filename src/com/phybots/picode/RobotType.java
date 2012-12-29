package com.phybots.picode;

import java.util.EnumSet;

import com.phybots.entity.MindstormsNXT;
import com.phybots.entity.MindstormsNXT.Port;
import com.phybots.picode.Robot;
import com.phybots.picode.core.internal.MotorManager;
import com.phybots.picode.ui.PicodeMain;

public enum RobotType {

	MindstormsNXT(new RobotHandler() {
		public void handleInstantiation(com.phybots.entity.Robot robot) {
			MindstormsNXT nxt = (MindstormsNXT) robot;
			nxt.removeDifferentialWheels();
			nxt.addExtension("MindstormsNXTExtension", Port.A);
			nxt.addExtension("MindstormsNXTExtension", Port.B);
			nxt.addExtension("MindstormsNXTExtension", Port.C);
		}
	}),
	Human(new RobotHandler() {
		public void handleInstantiation(com.phybots.entity.Robot robot) {
		}
	});

	private RobotHandler handler;

	private RobotType(RobotHandler handler) {
		this.handler = handler;
	}

	public static interface RobotHandler {
		public void handleInstantiation(com.phybots.entity.Robot robot);
	}

	public static RobotType valueOf(Class<? extends com.phybots.entity.Robot> robotClass) {
		for (RobotType robotType : EnumSet.allOf(RobotType.class)) {
			if (robotClass.equals(robotType.getRobotClass())) {
				return robotType;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	Class<? extends com.phybots.entity.Robot> getRobotClass() {
		try {
			return (Class<? extends com.phybots.entity.Robot>)
					Class.forName(String.format("com.phybots.entity.%s", this.toString()));
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	public com.phybots.entity.Robot newRobotInstance(String connectionString) throws InstantiationException {
		Class<?> robotClass = getRobotClass();
		try {
			com.phybots.entity.Robot robot = (com.phybots.entity.Robot) robotClass.getConstructor(String.class).newInstance(connectionString);
			if (handler != null) {
				handler.handleInstantiation(robot);
			}
			return robot;
		} catch (Exception e) {
			throw new InstantiationException("Robot class instantiation error.");
		}
	}

	@SuppressWarnings("unchecked")
	Class<? extends Pose> getPoseClass() {
		try {
			return (Class<? extends Pose>)
					Class.forName(String.format("com.phybots.picode.core.internal.%sPose", this.toString()));
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	public Pose newPoseInstance() {
		try {
			return getPoseClass().newInstance();
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	Class<? extends MotorManager> getMotorManagerClass() {
		try {
			return (Class<? extends MotorManager>)
					Class.forName(String.format("com.phybots.picode.core.internal.%sMotorManager", this.toString()));
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	public MotorManager newMotorManagerInstance(PicodeMain robokoMain, Robot robot) {
		try {
			return getMotorManagerClass()
					.getConstructor(PicodeMain.class, Robot.class)
					.newInstance(robokoMain, robot);
		} catch (Exception e) {
			return null;
		}
	}
}