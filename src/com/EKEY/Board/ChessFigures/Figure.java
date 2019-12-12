package com.EKEY.Board.ChessFigures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import com.EKEY.GameObject;
import com.EKEY.Misc.Camera;
import com.EKEY.Misc.DataShare;

public abstract class Figure extends GameObject{
	
	protected Image figureImage;
	
	protected int HP = 100;
	
	protected int tileX = -1;
	protected int tileY = -1;
	
	protected boolean selected = false;
	
	public Figure(int x, int y, int width, int height, Image image) {
		super(x, y, width, height);
		this.figureImage = image;
	}
	
	public Figure() {
		super(0, 0, 0, 0);
		this.figureImage = null;
	}
	
	public Figure(Figure clone) {
		super(clone);
		this.figureImage = clone.getFigureImage();
	}
	
	@Override
	public void render(Graphics g) {
		
		Camera camera = Camera.getInstance();
		g.drawImage(figureImage, x - camera.getCameraX(), y - camera.getCameraY(), width, height, null);
		
		if(selected) {
			g.setColor(Color.BLACK); // TODO: DEBUGGING RECTANGLE REMOVE
			g.drawRect(x - camera.getCameraX(), y - camera.getCameraY(), width, height);
		}
	}
	
	@Override
	public void onClick() {
		System.out.println("Clicked figure " + this);
	}
	
	public Image getFigureImage() {
		return figureImage;
	}

	public void setFigureImage(Image figureImage) {
		this.figureImage = figureImage;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getTileX() {
		return tileX;
	}

	public void setTileX(int tileX) {
		this.tileX = tileX;
	}

	public int getTileY() {
		return tileY;
	}

	public void setTileY(int tileY) {
		this.tileY = tileY;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
	
	

}
