package com.EKEY.Misc;

/**
 * The camera representing our viewport. The MouseDrag class changees the x and y of the camera.
 * Every object rendered should subtract the x and y to be rendered correctly (Inside the render function, not the actual coordinates of
 * the objcet.)
 */
public final class Camera {
	
	private static Camera camera;
	
	private Camera() {
		
	}
	
	public static Camera getInstance() {
		
		if(camera == null) {
			camera = new Camera();
		}
		
		return camera;
		
	}
	
	/**
	 * The X of the camera in the game world.
	 */
	private int cameraX = 0;
	/**
	 * The Y of the camera in the game world.
	 */
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
