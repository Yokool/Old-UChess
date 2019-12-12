package com.EKEY.Listeners;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.EKEY.Interfaces.Clickable;
import com.EKEY.Misc.DataShare;

public class ClickableMouse implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent EVENT) {
		
		Point clickPoint = EVENT.getPoint();
		
		for(Clickable clickable : DataShare.HANDLER.getClickList()) {
			
			if(clickable.getBounds().contains(clickPoint)) {
				
				clickable.onClick();
				
			}
			
		}
		
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
	public void mouseReleased(MouseEvent arg0) {
		
	}

}
