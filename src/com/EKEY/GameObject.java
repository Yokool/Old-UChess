package com.EKEY;

import com.EKEY.Interfaces.Renderable;
import com.EKEY.Interfaces.Tickable;

public abstract class GameObject implements Renderable, Tickable{
	
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
	
	/**
	 * A constructor that creates an "empty" object.
	 */
	public GameObject() {
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
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
