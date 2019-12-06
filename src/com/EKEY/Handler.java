package com.EKEY;

import java.util.LinkedList;

import com.EKEY.Interfaces.Renderable;
import com.EKEY.Interfaces.Tickable;

public class Handler {
	
	private LinkedList<Tickable> tickList = new LinkedList<Tickable>();
	private LinkedList<Renderable> renderList = new LinkedList<Renderable>();
	
	public void tick() {
		
		for(Tickable tickable : tickList) {
			tickable.tick();
		}
		
	}
	
	public void render() {
		
		for(Renderable renderable : renderList) {
			renderable.render();
		}
		
	}
	
	public void registerTick(Tickable tickable) {
		tickList.add(tickable);
	}
	
	public void registerRender(Renderable renderable) {
		renderList.add(renderable);
	}
	
}
