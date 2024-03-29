package com.EKEY.Board.ChessFigures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import com.EKEY.GameObject;
import com.EKEY.Handler;
import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Movement.Movement;
import com.EKEY.Board.Turns.Player;
import com.EKEY.Listeners.ClickableMouse;
import com.EKEY.Misc.Camera;
import com.EKEY.Misc.DataShare;

public class Figure extends GameObject{
	
	protected Image figureImage;
	
	protected int HP = 100;
	
	protected int tileX = -1;
	protected int tileY = -1;
	
	protected LinkedList<Movement> movement = new LinkedList<Movement>();
	protected ColorEnum colorEnum;
	
	protected boolean selected = false;
	
	protected boolean readyToPlay = false;
	
	public Figure(int x, int y, int width, int height, Image image, ColorEnum color, Movement... movement) {
		super(x, y, width, height);
		this.figureImage = image;
		this.colorEnum = color;
		
		for(Movement m : movement) {
			this.addMovement(m);
		}
		
	}
	
	public Figure() {
		super(0, 0, 0, 0);
		this.figureImage = null;
	}
	
	public Figure(Figure clone) {
		super(clone);
		
		for(Movement m : clone.getMovement()) {
			this.addMovement((Movement) m.clone());
		}
		
		this.figureImage = clone.getFigureImage();
		this.colorEnum = clone.colorEnum;
	}
	
	@Override
	public void render(Graphics g) {
		
		Camera camera = Camera.getInstance();
		g.drawImage(figureImage, x - camera.getCameraX(), y - camera.getCameraY(), width, height, null);
		
		if(selected) {
			g.setColor(Color.BLACK); // TODO: DEBUGGING RECTANGLE REMOVE
			g.drawRect(x - camera.getCameraX(), y - camera.getCameraY(), width, height);
			
			for(Movement m : movement) {
				m.render(g);
			}
			
		}
	}
	
	@Override
	public Object clone() {
		return new Figure(this);
	}
	
	@Override
	public void onClick() {
		
		ClickableMouse clickableMouse = DataShare.CLICKABLEMOUSE;
		
		if(clickableMouse.getSelectedFigure() == null || clickableMouse.getSelectedFigure() != this) {
			
			clickableMouse.setSelectedFigure(this);
			
			if(clickableMouse.getSelectedFigure() != null) {
				clickableMouse.getSelectedFigure().setSelected(false);
			}
			
		}
		
		this.setSelected(true);
		
		for(Movement m : movement) {
			m.update();
		}
	}
	
	@Override
	public void tick() { // TODO: UNIMPLEMENTED
		
	}
	
	public Image getFigureImage() {
		return figureImage;
	}

	public void setFigureImage(Image figureImage) {
		this.figureImage = figureImage;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getTileX() {
		return tileX;
	}

	public void setTileX(int tileX) {
		this.tileX = tileX;
	}

	public int getTileY() {
		return tileY;
	}

	public void setTileY(int tileY) {
		this.tileY = tileY;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public LinkedList<Movement> getMovement() {
		return movement;
	}

	public void addMovement(Movement movement) {
		this.movement.add(movement);
		movement.setFigure(this);
	}
	
	public void addMovementSet(LinkedList<Movement> movementBundle) {
		
		this.movement.clear();
		
		for(Movement m : movementBundle) {
			m.setFigure(this);
			this.movement.add(m);
			
		}
		
	}
	
	@Override
	public void deleteObject() {
		
		try {
			this.finalize(); // finalize the object incase we miss some references
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		Handler handler = DataShare.HANDLER;
		
		// unregistering all the related renders...
		handler.unregisterTick(this);
		handler.unregisterFigureRender(this);
		handler.unregisterClickable(this);
		
		BoardTile tile = DataShare.BOARD.getTileByLoc(this.tileY, this.tileX); // removing from the tile the figure is on
		
		if(tile != null) {
			tile.setTileFigure(null); // removing the tied tile figure from the tile the figure is currently on (if it isn't null)
		}
		
		// removing the figure from the player with the same color enum
		for(int i = 0; i < DataShare.getPlayerList().size(); i++) {
			Player p = DataShare.getPlayerList().get(i);
			if(p.getPlayerColor().equals(this.getColorEnum())) {
				if(p.getPlayerFigures().contains(this)) {
					p.removeFigure(this);
				}
			}
			
		}
		
		System.gc(); // try to clear the heap now incase we missed some references and we really want the object gone
	}

	public ColorEnum getColorEnum() {
		return colorEnum;
	}

	public void setColorEnum(ColorEnum colorEnum) {
		this.colorEnum = colorEnum;
	}

	public boolean isReadyToPlay() {
		return readyToPlay;
	}

	public void setReadyToPlay(boolean readyToPlay) {
		this.readyToPlay = readyToPlay;
	}
	
	
	
}
