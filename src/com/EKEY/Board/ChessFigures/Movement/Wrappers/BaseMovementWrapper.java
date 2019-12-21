package com.EKEY.Board.ChessFigures.Movement.Wrappers;

import java.awt.Graphics;
import java.util.ArrayList;

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
	public void recalc() {
		wrappedMovement.recalc();
	}
	
	@Override
	public void update() {
		wrappedMovement.update();
	}
	
	@Override
	public void render(Graphics g) {
		wrappedMovement.render(g);
	}
	
	@Override
	public void notified(BoardTile tile) {
		wrappedMovement.notified(tile);
	}
	
	@Override
	public void setFigure(Figure figure) {
		wrappedMovement.setFigure(figure);
	}
	
	@Override
	public ArrayList<BoardTile> getBufferList() {
		return wrappedMovement.getBufferList();
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
