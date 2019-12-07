package com.EKEY.Board.ChessFigures;

import java.awt.Graphics;
import java.awt.Image;

import com.EKEY.GameObject;

public abstract class Figure extends GameObject{
	
	protected Image figureImage;
	
	public Figure(int x, int y, int width, int height, Image image) {
		super(x, y, width, height);
		this.figureImage = image;
	}
	
	@Override
	public void render(Graphics g) {
		
		g.drawImage(figureImage, x, y, width, height, null);
		
	}
	
	public Image getFigureImage() {
		return figureImage;
	}

	public void setFigureImage(Image figureImage) {
		this.figureImage = figureImage;
	}
	
	

}
