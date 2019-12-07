package com.EKEY.Listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.EKEY.Misc.DataShare;

public class MouseDrag implements MouseListener, MouseMotionListener{
	
	private int X;
	private int Y;
	
	private double Speed = 1;
	
	@Override
	public void mouseDragged(MouseEvent EVENT) {
		
		int curX = EVENT.getX();
		int curY = EVENT.getY();
		
		int actualX = (int) ((curX - X) * Speed);
		int actualY = (int) ((curY - Y) * Speed);
		
		X = EVENT.getX();
		Y = EVENT.getY();
		
		DataShare.CAMERA.setCameraX(DataShare.CAMERA.getCameraX() - actualX);
		DataShare.CAMERA.setCameraY(DataShare.CAMERA.getCameraY() - actualY);
		
		System.out.println("CAMERA X: " + DataShare.CAMERA.getCameraX());
		System.out.println("CAMERA Y: " + DataShare.CAMERA.getCameraY());
	}

	@Override
	public void mouseMoved(MouseEvent EVENT) {
		X = EVENT.getX();
		Y = EVENT.getY();
	}

	@Override
	public void mouseClicked(MouseEvent EVENT) {
		X = EVENT.getX();
		Y = EVENT.getY();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent EVENT) {
		X = EVENT.getX();
		Y = EVENT.getY();
		
	}

}
