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
	
	private LinkedList<Renderable> figureRenderList = new LinkedList<Renderable>();
	
	public void tick() {
		
		for(Tickable tickable : tickList) {
			tickable.tick();
		}
		
	}
	
	public void render(Graphics g) {
		
		for(Renderable renderable : renderList) {
			renderable.render(g);
		}
		
		for(Renderable renderable : figureRenderList) {
			renderable.render(g);
		}
		
	}
	
	public void registerTick(Tickable tickable) {
		tickList.add(tickable);
	}
	
	public void registerRender(Renderable renderable) {
		renderList.add(renderable);
	}
	
	public void registerFigureRender(Renderable renderable) {
		figureRenderList.add(renderable);
	}
	
}
