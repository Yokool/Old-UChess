package com.EKEY;

import java.awt.Graphics;
import java.util.LinkedList;

import com.EKEY.Interfaces.Clickable;
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
	
	private LinkedList<Clickable> clickList = new LinkedList<Clickable>();
	
	public void tick() {
		
		for(int i = 0; i < tickList.size(); i++) {
			tickList.get(i).tick();
		}
		
	}
	
	public void render(Graphics g) {
		
		for(int i = 0; i < renderList.size(); i++) {
			renderList.get(i).render(g);
		}
		
		for(int i = 0; i < figureRenderList.size(); i++) {
			figureRenderList.get(i).render(g);
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
	
	public void registerClickable(Clickable clickable) {
		clickList.add(clickable);
	}
	
	public void unregisterTick(Tickable tickable) {
		tickList.remove(tickable);
	}
	
	public void unregisterRender(Renderable renderable) {
		renderList.remove(renderable);
	}
	
	public void unregisterFigureRender(Renderable renderable) {
		figureRenderList.remove(renderable);
	}
	
	public void unregisterClickable(Clickable clickable) {
		clickList.remove(clickable);
	}
	
	public LinkedList<Clickable> getClickList(){
		return clickList;
	}

	public LinkedList<Tickable> getTickList() {
		return tickList;
	}

	public LinkedList<Renderable> getRenderList() {
		return renderList;
	}

	public LinkedList<Renderable> getFigureRenderList() {
		return figureRenderList;
	}
	
	
	
}
