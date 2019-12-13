package com.EKEY;

import java.awt.Rectangle;

import com.EKEY.Interfaces.Clickable;
import com.EKEY.Interfaces.Renderable;
import com.EKEY.Interfaces.Tickable;
import com.EKEY.Misc.Camera;

public abstract class GameObject implements Renderable, Tickable, Cloneable, Clickable{
	
	protected int x = 0;
	protected int y = 0;
	
	protected int width = 0;
	protected int height = 0;
	
	public GameObject(int x, int y, int width, int height) {
		
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
		
	}
	
	
	public GameObject(GameObject gameobjecttoclone) {
		this.x = gameobjecttoclone.x;
		this.y = gameobjecttoclone.y;
		this.width = gameobjecttoclone.width;
		this.height = gameobjecttoclone.height;
	}
	
	public Rectangle getBounds() {
		Camera cam = Camera.getInstance();
		return new Rectangle(x - cam.getCameraX(), y - cam.getCameraY(), width, height);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
