package com.EKEY.Misc;

import java.util.ArrayList;

import com.EKEY.Game;
import com.EKEY.Handler;
import com.EKEY.Board.Board;
import com.EKEY.Board.Builder.NormalTileBuilder;
import com.EKEY.Board.Turns.Player;
import com.EKEY.GUI.Window;
import com.EKEY.Listeners.ClickableMouse;

/**
 * A class to easily share data between classes.
 */
public abstract class DataShare {
	
	public static Game GAME;
	public static Handler HANDLER;
	public static Board BOARD;
	public static Window WINDOW;
	public static ClickableMouse CLICKABLEMOUSE;
	
	private static ArrayList<Player> playerList = new ArrayList<Player>();
	
	public static NormalTileBuilder NORMALTILEBUILDER;
	
	public static void addPlayer(Player player) {
		playerList.add(player);
	}
	
	public static ArrayList<Player> getPlayerList() {
		return playerList;
	}
	
}
