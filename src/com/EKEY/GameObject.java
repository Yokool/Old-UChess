package com.EKEY;

import java.awt.Rectangle;
import java.util.Iterator;
import java.util.ListIterator;

import com.EKEY.Interfaces.Clickable;
import com.EKEY.Interfaces.Renderable;
import com.EKEY.Interfaces.Tickable;
import com.EKEY.Misc.Camera;
import com.EKEY.Misc.DataShare;

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
	
	public void deleteObject() {
		
		try {
			this.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		Handler handler = DataShare.HANDLER;
		
		ListIterator<Clickable> it = handler.getClickList().listIterator();
		while(it.hasNext()) {
			if(it.next().equals(this)) {
				it.remove();
			}
		}
		
		ListIterator<Tickable> it_ti = handler.getTickList().listIterator();
		
		while(it_ti.hasNext()) {
			if(it_ti.next().equals(this)) {
				it_ti.remove();
			}
		}
		
		ListIterator<Renderable> it_r = handler.getRenderList().listIterator();
		
		while(it_r.hasNext()) {
			if(it_r.next().equals(this)) {
				it_r.remove();
			}
		}
		
		
		System.gc();
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
