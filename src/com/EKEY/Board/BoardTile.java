package com.EKEY.Board;

import java.awt.Color;
import java.awt.Graphics;

import com.EKEY.GameObject;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Board.ChessFigures.Movement.Movement;
import com.EKEY.Listeners.ClickableMouse;
import com.EKEY.Misc.Camera;
import com.EKEY.Misc.DataShare;

/**
 * An abstract class representing a single tile inside the Board.
 * A super class of all tiles, the tile has its color that will be displayed.
 */
public abstract class BoardTile extends GameObject implements Cloneable{
	
	
	protected Color color;
	
	protected int tileX = -1;
	protected int tileY = -1;
	
	/**
	 * The figure that is currently on the tile.
	 */
	private Figure tileFigure = null;
	
	public BoardTile(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	// A constructor for cloning objects
	public BoardTile(BoardTile tiletoclone) {
		super(tiletoclone);
		this.color = tiletoclone.getColor();
	}
	
	@Override
	public void render(Graphics g) {
		
		Camera camera = Camera.getInstance();
		
		g.setColor(color);
		
		g.fillRect(x - camera.getCameraX(), y - camera.getCameraY(), width, height);
		
	}
	
	public void setTileDimension(int gridX, int gridY) {
		
		this.tileX = gridX;
		this.tileY = gridY;
		
	}
	
	@Override
	public void onClick() {
		
		ClickableMouse clickableMouse = DataShare.CLICKABLEMOUSE;
		
		if(clickableMouse.getSelectedFigure() != null) { // if we selected a figure
			
			for(Movement m : clickableMouse.getSelectedFigure().getMovement()) { // for each movement inside the selected figure
				// TODO: THIS IS SUCH A HORRIBLE WAY OF DOING STUFF
				m.moveFigureWithMovement(this); // notify it that it should move to that tile
				
			}
			
			clickableMouse.getSelectedFigure().setSelected(false);
			clickableMouse.setSelectedFigure(null);
			
		}
		
	}
	
	
	public Figure getTileFigure() {
		return tileFigure;
	}

	public void setTileFigure(Figure tileFigure) {
		this.tileFigure = tileFigure;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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
	
	
	
	
}
