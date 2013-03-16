package com.phybots.picode.api;

import java.io.IOException;

public class Picode {
	private static Picode instance = null;

	private Picode() {
	}

	public static Picode getInstance() {
		if (instance == null) {
			instance = new Picode();
		}
		return instance;
	}

	public static Pose pose(String poseName) {
		try {
			return PoseLibrary.load(poseName);
		} catch (IOException e) {
			return null;
		}
	}

	public static PoseSet poseSet(String poseSetName) {
		return PoseSet.load(poseSetName);
	}
}