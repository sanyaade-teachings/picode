package com.phybots.picode.camera;

import java.awt.image.BufferedImage;

public interface Camera {
	public boolean start();
	public void stop();
	public void dispose();
	public BufferedImage getImage();
	public void addImageListener(CameraImageListener listener);
	public boolean removeImageListener(CameraImageListener listener);
}
