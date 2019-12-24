package com.EKEY.Board.Turns;

import java.util.LinkedList;

import com.EKEY.Board.ChessFigures.ColorEnum;
import com.EKEY.Board.ChessFigures.Figure;
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
