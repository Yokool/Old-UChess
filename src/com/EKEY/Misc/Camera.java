package com.EKEY.Misc;

public final class Camera {
	
	public Camera() {
		
		DataShare.CAMERA = this;
		
	}
	
	private int cameraX = 0;
	private int cameraY = 0;
	
	public int getCameraX() {
		return cameraX;
	}
	public void setCameraX(int cameraX) {
		this.cameraX = cameraX;
	}
	public int getCameraY() {
		return cameraY;
	}
	public void setCameraY(int cameraY) {
		this.cameraY = cameraY;
	}
	
	
	
	
}
