package com.EKEY.Board.ChessFigures.Movement.Wrappers;

import java.awt.Graphics;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Movement.Movement;

public class BaseMovementWrapper extends Movement{
	
	protected Movement movement;
	
	public BaseMovementWrapper(Movement movement) {
		super(null);
		this.movement = movement;
	}
	/*
	@Override
	public void recalc() {
		this.movement.recalc();
	}
	
	@Override
	public void update() {
		this.movement.update();
	}
	*/
	
	@Override
	public void update() {
		this.movement.update();
	}

	@Override
	public void recalc() {
		
		this.movement.recalc();
		
	}
	
	@Override
	public void render(Graphics g) {
		
		this.movement.render(g);
		
	}
	
	@Override
	public void notified(BoardTile tile) {
		
		this.movement.notified(tile);
		
	}
	
	@Override
	public Object clone() {
		return this.movement.clone(); // FIXME: RETURNING BASEMOVEMENTWRAPPER
	}
}
