package com.EKEY.Board.Turns;

import java.util.ArrayList;

import com.EKEY.Misc.DataShare;

public class TurnSystem {
	
	/**
	 * Local reference of the DataShare player list.
	 */
	private ArrayList<Player> playerList;
	
	public TurnSystem() {
		DataShare.TURNSYSTEM = this;
		playerList = DataShare.getPlayerList();
	}
	/**
	 * The index of the player that is ready to do their turn.
	 */
	private int index = 0;
	
	/**
	 * 
	 * @return Returns the player that is ready to make their turn
	 */
	public Player getPlayerWithTurn() {
		return playerList.get(index);
	}
	
	/**
	 * Starts the first player in the playerList to do their turn.
	 */
	public void startTheGame() {
		playerList.get(0).playerStarted();
	}
	
	/**
	 * When the player is done with their turn this is called.
	 * 
	 * This method is currently called from the Movement class when a player moves a figure, thus ending their round.
	 * This applies for every Movement subclass and currently can't be changed.
	 */
	public void nextTurn() {
		
		getPlayerWithTurn().playerFinished(); // the player that just played is done with their turn and finished
		
		incrementIndex(); // incremement the player index -> get the player ready to make their turn
		
		getPlayerWithTurn().playerStarted(); // unblock the players figures and make him ready to do his turn
	}
	
	public int getIndex() {
		return index;
	}
	
	/**
	 * Increments the index (moves to the player that is waiting for their turn), if the incrementation would
	 * exceed the size snap back to the first player.
	 */
	private void incrementIndex() {
		this.index++;
		if(this.index >= playerList.size()) {
			this.index = 0;
		}
	}
	
	
}
