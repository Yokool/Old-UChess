package com.EKEY;

import java.awt.Graphics;
import java.util.LinkedList;

import com.EKEY.Interfaces.Renderable;
import com.EKEY.Interfaces.Tickable;
import com.EKEY.Misc.DataShare;

public class Handler {
	
	public Handler() {
		DataShare.HANDLER = this;
	}
	
	private LinkedList<Tickable> tickList = new LinkedList<Tickable>();
	private LinkedList<Renderable> renderList = new LinkedList<Renderable>();
	
	public void tick() {
		
		for(Tickable tickable : tickList) {
			tickable.tick();
		}
		
	}
	
	public void render(Graphics g) {
		
		for(Renderable renderable : renderList) {
			renderable.render(g);
		}
		
	}
	
	public void registerTick(Tickable tickable) {
		tickList.add(tickable);
	}
	
	public void registerRender(Renderable renderable) {
		renderList.add(renderable);
	}
	
}
