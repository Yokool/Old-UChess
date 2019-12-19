package com.EKEY.Board.ChessFigures.Movement.Wrappers;

import com.EKEY.Board.ChessFigures.Movement.Movement;

public class BaseMovementWrapper extends Movement{
	
	protected Movement movement;
	
	public BaseMovementWrapper(Movement movement) {
		super(null);
		this.movement = movement;
	}

	@Override
	public void recalc() {
		movement.recalc();
	}
	
	@Override
	public void update() {
		movement.update();
	}

}
