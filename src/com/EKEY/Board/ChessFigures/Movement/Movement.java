package com.EKEY.Board.ChessFigures.Movement;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Misc.Camera;
import com.EKEY.Misc.DataShare;

/**
 * A class for moving a figure, each figure in the game can have a any amount of Movement objects
 * tied to it.
 * 
 * Using composition and configuration, you can get any result you want.
 * 
 * These movement objects are best configured using the constructor.
 * 
 * Preconfigured objects can be find in the Prototype class.
 */
public abstract class Movement implements Cloneable{
	
	protected Figure figure;
	
	protected ArrayList<BoardTile> bufferList = new ArrayList<BoardTile>();
	
	protected BoardTile lastTile = null;
	
	/**
	 * The constructor of the Movement class
	 * @param figure The figure this movement object is tied to.
	 */
	public Movement(Figure figure) {
		this.figure = figure;
	}
	
	
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This method must be implemented in each subclass of Movement. This is the most important method of the movement
	 * system as it determines which tiles will be rendered with the dot on them and which ones are walkable.
	 */
	protected abstract void recalc();
	
	/**
	 * This method should not be changed unless fully needed to, it renders the transparent dots showing
	 * where you are allowed to go.
	 * 
	 * The tiles that the dot shows upon is determined by the bufferList which is centered around the recalc method
	 * which must be overriden in subclass of Movement.
	 * 
	 * @param g This method is called in the Figure class to this parameter is filled in. Thus you shouldn't call this
	 * method yourself.
	 */
	public void renderOptions(Graphics g) {
		
		bufferList.clear();
		recalc();
		
		for(BoardTile tile : bufferList) {
			Camera cam = Camera.getInstance();
			g.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
			g.fillOval(tile.getX() - cam.getCameraX() + 47, tile.getY() - cam.getCameraY() + 47, 32, 32);
			
		}
		
	}
	
	/**
	 * This method should not be called directly, it is used in the ClickableMouse class.
	 * 
	 * This method is called everytime a user clicks a BoardTile.
	 * 
	 * @param tile
	 */
	public void notified(BoardTile tile) {
		
		if(bufferList.contains(tile)) { // When the tile is inside the bufferList only then can the figure be moved onto the tile
			moveFigure(tile);
		}
		
	}
	
	protected void moveFigure(BoardTile tile) {
		
		if(tile == lastTile) {
			return;
		}
		
		lastTile = tile;
		DataShare.BOARD.moveFigureToTile(figure, lastTile);
		
		
		

	}

	public void setFigure(Figure figure) {
		this.figure = figure;
	}
	
	
	
	
}
