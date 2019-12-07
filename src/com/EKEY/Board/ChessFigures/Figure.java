package com.EKEY.Board.ChessFigures;

import java.awt.Graphics;
import java.awt.Image;

import com.EKEY.GameObject;
import com.EKEY.Misc.DataShare;

public abstract class Figure extends GameObject{
	
	protected Image figureImage;
	
	protected int HP = 100;
	
	public Figure(int x, int y, int width, int height, Image image) {
		super(x, y, width, height);
		this.figureImage = image;
	}
	
	public Figure() {
		super(0, 0, 0, 0);
		this.figureImage = null;
	}
	
	@Override
	public void render(Graphics g) {
		
		g.drawImage(figureImage, x - DataShare.CAMERA.getCameraX(), y - DataShare.CAMERA.getCameraY(), width, height, null);
		
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
	
	

}
