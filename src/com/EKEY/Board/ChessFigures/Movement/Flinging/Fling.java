package com.EKEY.Board.ChessFigures.Movement.Flinging;

import com.EKEY.Board.ChessFigures.Figure;

/**
 * An abstract superclass of all Fling related logic (Throwing the figures out of the playing field)
 * 
 * A Fling class is tied to the Movement object. The tied figure should be the same as the one in the Movement class.
 * This is usually set when the Movement class's figure is set.
 * 
 * This class contains a single method that is called in the Movement class.
 */
public abstract class Fling {
	/**
	 * The tied figure to the Fling class. (The Figure that's throwing out another figure. NOT THE TARGET)
	 */
	protected Figure figure = null;
	
	/**
	 * The method that gets called through the movement class. Should be overriden to do custom logic.
	 * 
	 * You shouldn't call this method on your own.
	 * 
	 * @param The targeted figure, which should already be filled out by the Movement object.
	 */
	public abstract void flingOut(Figure targetF);
	
	public Figure getThisF() {
		return figure;
	}

	public void setFigure(Figure figure) {
		this.figure = figure;
	}
	
	
}
