package com.EKEY.GUI;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.EKEY.Game;

/**
 * A class that acts as a wrapper for the main Window (JFrame) of our game.
 * Contains method to initalize all the components and set the graphics of the components tied to the window.
 */
public final class Window extends JFrame{
	
	private static final long serialVersionUID = -5932003979053292641L;
	
	private JFrame frame = null;
	
	/**
	 * The tied game to the Window. This variables is used when building the frame.
	 */
	private Game gameComponent = null;
	
	private String nameWindow = null;
	
	/**
	 * The initialize size of the window, this can change so this variable shouldn't be relied upon when trying
	 * to get the actual size of the window. TODO: SCREEN RESIZE LISTENER
	 */
	
	
	private Dimension winInitialSize = null;
	
	/**
	 * Create a new window.
	 * @param name - The name of the window.
	 * @param size - The size represented as a dimension object.
	 * @param game - The game canvas the JFrame is registered to.
	 */
	public Window(String name, Dimension size, Game game) {
		
		this.nameWindow = name;
		this.winInitialSize = size;
		this.gameComponent = game;
	}
	
	/**
	 * A method that builds a completely new frame in the Window object.
	 * The frame is then set visible, it gets its name from the constructor params.
	 */
	public void buildFrame() {
		
		frame = new JFrame(nameWindow);
		frame.setSize(winInitialSize);
		frame.setLocationRelativeTo(null);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildComponents();
		
		frame.setVisible(true);
		
	}
	
	/**
	 * A method to initialize and register all the components tied to the frame.
	 * Event listeners are also made and registered in this method.
	 */
	public void buildComponents() {
		
		frame.add(gameComponent);
		
	}
	
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Game getGameComponent() {
		return gameComponent;
	}

	public void setGameComponent(Game gameComponent) {
		this.gameComponent = gameComponent;
	}
	
	
	
}
