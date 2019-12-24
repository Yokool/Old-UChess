package com.EKEY.Board.Turns;

import java.util.ArrayList;

import com.EKEY.Misc.DataShare;

public class TurnSystem {
	
	/**
	 * Local reference of the DataShare player list.
	 */
	private ArrayList<Player> playerList;
	
	public TurnSystem() {
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
	 * Calls this when the player is finished with their turn
	 */
	public void playerFinished() {
		incrementIndex();
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
