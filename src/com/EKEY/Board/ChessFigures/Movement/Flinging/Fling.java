package com.EKEY.Board.ChessFigures.Movement.Flinging;

import com.EKEY.Board.ChessFigures.Figure;

public abstract class Fling {
	
	protected Figure figure = null;
	
	public abstract void flingOut(Figure targetF);
	
	public Figure getThisF() {
		return figure;
	}

	public void setFigure(Figure figure) {
		this.figure = figure;
	}
	
	
}
