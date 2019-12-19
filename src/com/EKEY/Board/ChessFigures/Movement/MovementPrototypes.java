package com.EKEY.Board.ChessFigures.Movement;

import java.util.LinkedList;

import com.EKEY.Board.ChessFigures.Movement.Flinging.VanillaFling;
import com.EKEY.Board.ChessFigures.Movement.Wrappers.CheckWrapper;

public class MovementPrototypes {
	
	private static LinkedList<Movement> whitePawnMovement = new LinkedList<Movement>();
	private static LinkedList<Movement> blackPawnMovement = new LinkedList<Movement>();
	private static LinkedList<Movement> rookMovement = new LinkedList<Movement>();
	private static LinkedList<Movement> queenMovement = new LinkedList<Movement>();
	private static LinkedList<Movement> bishopMovement = new LinkedList<Movement>();
	private static LinkedList<Movement> knightMovement = new LinkedList<Movement>();
	private static LinkedList<Movement> kingMovement = new LinkedList<Movement>();
	
	public static void createMovementPrototypes() {
		
		whitePawnMovement.add(new StepMovement(null, 0, -1, 2));
		whitePawnMovement.add(new ConditionalSingleMovement(new VanillaFling(), -1, -1));
		whitePawnMovement.add(new ConditionalSingleMovement(new VanillaFling(), 1, -1));
		
		blackPawnMovement.add(new StepMovement(null, 0, 1, 2));
		blackPawnMovement.add(new ConditionalSingleMovement(new VanillaFling(), -1, 1));
		blackPawnMovement.add(new ConditionalSingleMovement(new VanillaFling(), 1, 1));
		
		rookMovement.add(new StepMovement(new VanillaFling(), 1, 0, 8));
		rookMovement.add(new StepMovement(new VanillaFling(), -1, 0, 8));
		rookMovement.add(new StepMovement(new VanillaFling(), 0, 1, 8));
		rookMovement.add(new StepMovement(new VanillaFling(), 0, -1, 8));
		
		queenMovement.add(new StepMovement(new VanillaFling(), 1, 0, 8));
		queenMovement.add(new StepMovement(new VanillaFling(), -1, 0, 8));
		queenMovement.add(new StepMovement(new VanillaFling(), 0, 1, 8));
		queenMovement.add(new StepMovement(new VanillaFling(), 0, -1, 8));
		
		queenMovement.add(new StepMovement(new VanillaFling(), 1, 1, 8));
		queenMovement.add(new StepMovement(new VanillaFling(), -1, 1, 8));
		queenMovement.add(new StepMovement(new VanillaFling(), 1, -1, 8));
		queenMovement.add(new StepMovement(new VanillaFling(), -1, -1, 8));
		
		bishopMovement.add(new StepMovement(new VanillaFling(), 1, 1, 8));
		bishopMovement.add(new StepMovement(new VanillaFling(), -1, 1, 8));
		bishopMovement.add(new StepMovement(new VanillaFling(), 1, -1, 8));
		bishopMovement.add(new StepMovement(new VanillaFling(), -1, -1, 8));
		
		knightMovement.add(new SingleMovement(new VanillaFling(), 1, -2));
		knightMovement.add(new SingleMovement(new VanillaFling(), -1, -2));
		
		knightMovement.add(new SingleMovement(new VanillaFling(), 2, -1));
		knightMovement.add(new SingleMovement(new VanillaFling(), 2, 1));
		
		knightMovement.add(new SingleMovement(new VanillaFling(), 1, 2));
		knightMovement.add(new SingleMovement(new VanillaFling(), -1, 2));
		
		knightMovement.add(new SingleMovement(new VanillaFling(), -2, -1));
		knightMovement.add(new SingleMovement(new VanillaFling(), -2, 1));
		/*
		kingMovement.add(new SingleMovement(new VanillaFling(), 1, -1));
		kingMovement.add(new SingleMovement(new VanillaFling(), 0, -1));
		kingMovement.add(new SingleMovement(new VanillaFling(), -1, -1));
		
		kingMovement.add(new SingleMovement(new VanillaFling(), 1, 1));
		kingMovement.add(new SingleMovement(new VanillaFling(), 0, 1));
		kingMovement.add(new SingleMovement(new VanillaFling(), -1, 1));
		
		kingMovement.add(new SingleMovement(new VanillaFling(), -1, 0));
		kingMovement.add(new SingleMovement(new VanillaFling(), 1, 0));
		*/
		kingMovement.add(new CheckWrapper(new SingleMovement(new VanillaFling(), 1, -1)));
		kingMovement.add(new CheckWrapper(new SingleMovement(new VanillaFling(), 0, -1)));
		kingMovement.add(new CheckWrapper(new SingleMovement(new VanillaFling(), -1, -1)));
		
		kingMovement.add(new CheckWrapper(new SingleMovement(new VanillaFling(), 1, 1)));
		kingMovement.add(new CheckWrapper(new SingleMovement(new VanillaFling(), 0, 1)));
		kingMovement.add(new CheckWrapper(new SingleMovement(new VanillaFling(), -1, 1)));
		
		kingMovement.add(new CheckWrapper(new SingleMovement(new VanillaFling(), -1, 0)));
		kingMovement.add(new CheckWrapper(new SingleMovement(new VanillaFling(), 1, 0)));
	}

	public static LinkedList<Movement> getWhitePawnMovementSet() {
		
		return cloneList(whitePawnMovement);
		
	}

	public static LinkedList<Movement> getBlackPawnMovement() {
		
		return cloneList(blackPawnMovement);
		
	}
	
	public static LinkedList<Movement> getRookMovement() {
		
		return cloneList(rookMovement);
		
	}
	
	public static LinkedList<Movement> getQueenMovement() {
		
		return cloneList(queenMovement);
		
	}

	public static LinkedList<Movement> getBishopMovement() {
	
		return cloneList(bishopMovement);
	
	}
	
	public static LinkedList<Movement> getKnightMovement(){
		
		return cloneList(knightMovement);
		
	}
	
	public static LinkedList<Movement> getKingMovement(){
		
		return cloneList(kingMovement);
		
	}
	
	private static LinkedList<Movement> cloneList(LinkedList<Movement> movementList){
		
		LinkedList<Movement> buffer = new LinkedList<Movement>();
		
		for(Movement m : movementList) {
			buffer.add((Movement) m.clone());
		}
		
		return buffer;
		
	}
	
	
}
