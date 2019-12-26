package com.EKEY.Board.ChessFigures.Movement.Wrappers;

import java.awt.Graphics;
import java.util.LinkedList;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Board.ChessFigures.Movement.Movement;
import com.EKEY.Board.ChessFigures.Movement.Flinging.Fling;

public abstract class BaseMovementWrapper extends Movement{
	
	protected Movement wrappedMovement;
	
	public BaseMovementWrapper(Movement wrappedMovement) {
		super(null);
		this.wrappedMovement = wrappedMovement;
	}
	
	@Override
	public Object clone() {
		return super.clone();
	}
	
	@Override
	public LinkedList<BoardTile> recalc() {
		return wrappedMovement.recalc();
	}
	
	@Override
	public LinkedList<BoardTile> update() {
		return wrappedMovement.update();
	}
	
	@Override
	public void setFigure(Figure figure) {
		wrappedMovement.setFigure(figure);
	}
	
	@Override
	public Fling getFling() {
		return wrappedMovement.getFling();
	}
	
	@Override
	public void setFling(Fling fling) {
		wrappedMovement.setFling(fling);
	}
	
	@Override
	public Figure getFigure() {
		return wrappedMovement.getFigure();
	}
	
}
