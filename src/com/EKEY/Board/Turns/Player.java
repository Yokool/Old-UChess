package com.EKEY.Board.Turns;

import java.util.LinkedList;

import com.EKEY.Board.ChessFigures.ColorEnum;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Board.ChessFigures.Movement.Movement;
import com.EKEY.Misc.DataShare;

/**
 * The player class represting an instance of a single player.
 */
public class Player {
	
	/**
	 * The color the player is playing as.
	 */
	private ColorEnum playerColor;
	
	/**
	 * A list containing all the figures belonging to the player.
	 */
	private LinkedList<Figure> playerFigures = new LinkedList<Figure>(); // TODO: UNREGISTERING FIGURES ON DELETION FROM THIS
	
	/**
	 * The constructor for a new player
	 * 
	 * Players get automatically added to the DataShare player list when they are instantiated.
	 * 
	 * @param playerColor - The color that the player will be playing as.
	 */
	public Player(ColorEnum playerColor) {
		this.playerColor = playerColor;
		DataShare.addPlayer(this);
	}
	
	/**
	 * Updates the movement objects of all figures in this players figures list.
	 * 
	 * An updated figure refers to a figure that has all of their tied Movement objects updated (Their bufferLists have been
	 * cleared and reassigned).
	 */
	
	/**
	 * Sets all the figures in the list belonging to this player to ready to play.
	 */
	private void unblockAllFigures() {
		for(int i = 0; i < playerFigures.size(); i++) {
			Figure figure = playerFigures.get(i);
			figure.setReadyToPlay(true);
		}
	}
	/**
	 * Sets all the figures in the list belonging to this player to not ready to play.
	 */
	private void blockAllFigures() {
		for(int i = 0; i < playerFigures.size(); i++) {
			Figure figure = playerFigures.get(i);
			figure.setReadyToPlay(false);
		}
	}
	/**
	 * Called when the player starts their turn.
	 * 
	 * Updates and unblocks this players figures.
	 */
	public void playerStarted() {
		unblockAllFigures();
	}
	/**
	 * Called when the player finishes their turn.
	 * 
	 * Updates and blocks this players figures.
	 */
	public void playerFinished() {
		blockAllFigures();
	}
	
	// getters/setters

	public ColorEnum getPlayerColor() {
		return playerColor;
	}

	public void setPlayerColor(ColorEnum playerColor) {
		this.playerColor = playerColor;
	}

	public LinkedList<Figure> getPlayerFigures() {
		return playerFigures;
	}

	public void addFigure(Figure figure) {
		this.playerFigures.add(figure);
	}
	
	public void removeFigure(Figure figure) {
		this.playerFigures.remove(figure);
	}
	
	
	
}
