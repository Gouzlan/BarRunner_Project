package com.barrunner.factories;

import java.util.LinkedList;

import com.barrunner.model.EntityMovable;
import com.barrunner.model.Player;
import com.barrunner.model.definitions.EntityDef;

public class TileHandler {
	
	/* Variables */
	private Player player;
	private EntityDef definition;
	private EntityFactory factory;
	private LinkedList <EntityMovable> list;
	
	
	/* Constructors */
	public TileHandler(Player player, EntityDef definition) {
		this.player = player;
		this.definition = definition;
		factory = new EntityFactory(this.definition);
		list = new LinkedList<EntityMovable>();
	}
	
	
	/* Methods */
	
	public void update() {
		//Skips updating position if the X and Y velocity are zero
		if (definition.xVelocity != 0 || definition.yVelocity != 0) {
			for (EntityMovable tile : list) {
				tile.updatePosition();
			}
			factory.translateX();
		}
		
		if (definition.isEnabled) {
			if (!list.isEmpty()) {
				if (TileScopeManager.isPlayerInScope(player,list)) {
					TileScopeManager.addTileToList(factory.createTile(),list);
				}
			} else {
				TileScopeManager.addTileToList(factory.createTile(),list);
			}
		}
	}
	
	
	/* Getters */
	
	public LinkedList<EntityMovable> getTiles() {
		return list;
	}
	
	public int getTypeID() { return definition.typeID; }
	
	public float getXVelocity() { return definition.xVelocity; }
	
	public float getYVelocity() { return definition.yVelocity; }
}
