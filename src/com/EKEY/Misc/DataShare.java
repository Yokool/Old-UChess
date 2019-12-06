package com.EKEY.Misc;

import com.EKEY.Game;
import com.EKEY.Handler;
import com.EKEY.Board.Board;
import com.EKEY.Board.Builder.NormalTileBuilder;
import com.EKEY.GUI.Window;

public abstract class DataShare {
	
	public static Game GAME;
	public static Handler HANDLER;
	public static Board BOARD;
	public static Window WINDOW;
	public static Camera CAMERA;
	
	public static NormalTileBuilder NORMALTILEBUILDER;
	
	
}
