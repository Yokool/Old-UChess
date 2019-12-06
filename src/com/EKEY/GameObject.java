package com.EKEY;

import com.EKEY.Interfaces.Renderable;
import com.EKEY.Interfaces.Tickable;

public abstract class GameObject implements Renderable, Tickable, Cloneable{
	
	protected int x;
	protected int y;
	
	protected int width;
	protected int height;
	
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
