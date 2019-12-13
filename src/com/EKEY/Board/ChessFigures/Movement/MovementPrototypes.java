package com.EKEY.Board.ChessFigures.Movement;

import java.util.LinkedList;

public class MovementPrototypes {
	
	private static LinkedList<Movement> whitePawnMovement = new LinkedList<Movement>();
	private static LinkedList<Movement> blackPawnMovement = new LinkedList<Movement>();
	
	public static void createMovementPrototypes() {
		
		whitePawnMovement.add(new StepMovement(null, 0, -1, 2));
		blackPawnMovement.add(new StepMovement(null, 0, 1, 2));
		
	}

	public static LinkedList<Movement> getWhitePawnMovementSet() {
		
		LinkedList<Movement> buffer = new LinkedList<Movement>();
		
		for(Movement m : whitePawnMovement) {
			buffer.add((Movement) m.clone());
		}
		
		return buffer;
		
	}

	public static LinkedList<Movement> getBlackPawnMovement() {
		
		LinkedList<Movement> buffer = new LinkedList<Movement>();
		
		for(Movement m : blackPawnMovement) {
			buffer.add((Movement) m.clone());
		}
		
		return buffer;
		
	}
	
	
	
}
