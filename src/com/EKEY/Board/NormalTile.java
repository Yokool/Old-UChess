package com.EKEY.Board;

/**
 * A standart chess tile, with nothing special happening.
 */
public class NormalTile extends BoardTile{

	// Cloning constructor
	public NormalTile(NormalTile tiletoclone) {
		super(tiletoclone);
	}
	
	public NormalTile(int x, int y, int width, int height) {
		super(x, y, width, height);
	}


	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public NormalTile clone() {
		return new NormalTile(this);
	}

	@Override
	public void onClick() {
		// TODO: NOT IMPLEMENTED YET
	}
	

}
