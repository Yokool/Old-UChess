package com.EKEY.Board.ChessFigures.Movement;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Board.ChessFigures.Movement.Flinging.Fling;
import com.EKEY.Board.ChessFigures.Movement.Flinging.VanillaFling;
import com.EKEY.Interfaces.Renderable;
import com.EKEY.Interfaces.Tickable;
import com.EKEY.Misc.Camera;
import com.EKEY.Misc.DataShare;

/**
 * A class for moving a figure, each figure in the game can have any amount of Movement objects
 * tied to it.
 * 
 * Using composition, you can get any result you want.
 * 
 * These movement objects are best configured using the constructor.
 * 
 * Preconfigured objects can be found in the Prototype class.
 * 
 * The movement class can be tied to a Fling object, which allows it to throw out figures out of the playing field.
 * 
 * The class must be tied to a figure to work correctly. The figure is not initialized using the constructor and must be
 * set manually using the setFigure method.
 * 
 * The setFigure method can also inialize the tied fling object if it exists.
 */
public abstract class Movement implements Cloneable, Renderable{
	
	/**
	 * The figure that is tied to the movement object. Is set using the setFigure method and not the constructor.
	 */
	protected Figure figure;
	
	protected ArrayList<BoardTile> bufferList = new ArrayList<BoardTile>();
	
	protected BoardTile lastTile = null; // TODO: IS THIS NECESSARY?
	
	/**
	 * The tied fling object.
	 */
	protected Fling fling;
	
	/**
	 * The constructor of the Movement class
	 * @param Fling The tied fling object
	 */
	public Movement(Fling fling) {
		this.fling = fling;
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
	public abstract void recalc();
	
	public void update() {
		bufferList.clear();
		recalc();
		
		for(int i = 0; i < bufferList.size(); i++) {
			
			BoardTile tile = bufferList.get(i);
			
			if(tile.getTileFigure() != null) {
				
				if(fling == null) {
					bufferList.remove(i);
					continue;
				}
				
				
				
				if(tile.getTileFigure().getColorEnum() != null && tile.getTileFigure().getColorEnum().equals(figure.getColorEnum())) {
					bufferList.remove(i);
					continue;
				}
				
			}
			
		}
	}
	
	
	
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
	@Override
	public void render(Graphics g) {
		
		for(int i = 0; i < bufferList.size(); i++) {
			
			Camera cam = Camera.getInstance();
			
			
			BoardTile tile = bufferList.get(i);
			
			
			
			
			g.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
			g.fillOval(tile.getX() - cam.getCameraX() + 47, tile.getY() - cam.getCameraY() + 47, 32, 32); // TODO: Make sure that the circles get drawn above the figures
			
		}
		
	}
	
	/**
	 * This method should not be called directly, it is used in the ClickableMouse class.
	 * 
	 * This method is called everytime a user clicks a BoardTile.
	 * 
	 * The method is used to handle moving the figure and to fling figures out.
	 * 
	 * @param tile
	 */
	public void notified(BoardTile tile) {
		
		if(bufferList.contains(tile)) { // When the tile is inside the bufferList only then can the figure be moved onto the tile
			
			if(fling != null && tile.getTileFigure() != null) {
				fling.flingOut(tile.getTileFigure());
				update();
			}
			
			moveFigure(tile);
			
		}
		
	}
	
	@Deprecated
	// TODO: REMOVE THIS
	protected void moveFigure(BoardTile tile) { // TODO: IS THIS METHOD NECESSARY?
		
		lastTile = tile;
		DataShare.BOARD.moveFigureToTile(figure, lastTile);
		
	}
	
	/**
	 * This method should be called once upon initialization. It sets up this class to work correctly and if
	 * the class has a tied Fling object, that one gets set aswell.
	 * 
	 * @param figure
	 */
	public void setFigure(Figure figure) {
		this.figure = figure;
		
		if(fling != null) {
			fling.setFigure(figure);
		}
		
	}
	
	public ArrayList<BoardTile> getBufferList() {
		return bufferList;
	}
	
	public Fling getFling() {
		return fling;
	}
	
	public void setFling(Fling fling) {
		this.fling = fling;
	}
	
	public Figure getFigure() {
		return figure;
	}
	
	
}
