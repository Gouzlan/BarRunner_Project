package com.barrunner.model;

import java.util.LinkedList;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;

import com.badlogic.gdx.Gdx;
import com.barrunner.Global;
import com.barrunner.factories.TileHandler;
import com.barrunner.lua.GdxLuaGlobals;
import com.barrunner.model.definitions.EntityDef;

public class Level {
	
	/* Constants */
	private final float BACKGROUND_XVELOCITY = (Global.XVELOCITY/2f);
	
	/* Variables */
	private Player player;
	private LinkedList<TileHandler> backgroundHandlers;
	private LinkedList<TileHandler> floorHandlers;
	private LinkedList<TileHandler> propHandlers;
	private LinkedList<TileHandler> foregroundHandlers;
	
	public Level(Player player, String luaFile) {
		this.player = player;
		load(luaFile);
	}
	
	public void load(String luaFile) {
		backgroundHandlers = new LinkedList<TileHandler>();
		floorHandlers      = new LinkedList<TileHandler>();
		propHandlers       = new LinkedList<TileHandler>();
		foregroundHandlers = new LinkedList<TileHandler>();

		try {
			Globals globals = new GdxLuaGlobals();
			LuaValue chunk  = globals.loadfile(luaFile);
			
			LuaValue levelLoader      = chunk.call();
			LuaValue backgroundLoader = levelLoader.get("loadBackground");
			LuaValue floorLoader      = levelLoader.get("loadFloor");
			LuaValue propLoader       = levelLoader.get("loadProp");
			LuaValue foregroundLoader = levelLoader.get("loadForegound");
			
			backgroundLoader.invoke(CoerceJavaToLua.coerce(player), CoerceJavaToLua.coerce(backgroundHandlers));
			floorLoader.invoke(CoerceJavaToLua.coerce(player), CoerceJavaToLua.coerce(floorHandlers));
			propLoader.invoke(CoerceJavaToLua.coerce(player), CoerceJavaToLua.coerce(propHandlers));
			foregroundLoader.invoke(CoerceJavaToLua.coerce(player), CoerceJavaToLua.coerce(foregroundHandlers));
		} catch (Exception ex) {
			Gdx.app.log("Level", "could not load " + luaFile);
		}
	}
	/* Constructors */
	
	public Level (Player player) {
		this.player = player;
		
		EntityDef backgroundDef1 = new EntityDef();
		backgroundDef1.width     = Global.CAMERA_WIDTH;
		backgroundDef1.height    = Global.CAMERA_HEIGHT;
		backgroundDef1.typeID    = 1;
		backgroundDef1.xVelocity = BACKGROUND_XVELOCITY/2f;
		backgroundDef1.frequency = Global.CAMERA_WIDTH;
		
		EntityDef backgroundDef2 = new EntityDef();
		backgroundDef2.width     = Global.CAMERA_WIDTH;
		backgroundDef2.height    = Global.CAMERA_HEIGHT;
		backgroundDef2.typeID    = 0;
		backgroundDef2.xVelocity = BACKGROUND_XVELOCITY;
		backgroundDef2.frequency = Global.CAMERA_WIDTH;
		
		backgroundHandlers = new LinkedList<TileHandler>();
		
		backgroundHandlers.addLast(new TileHandler(player, backgroundDef1));
		
		backgroundHandlers.addLast(new TileHandler(player, backgroundDef2));
		
		EntityDef floorDef1 = new EntityDef();
		floorDef1.width     = Global.FLOOR_WIDTH;
		floorDef1.height    = Global.FLOOR_HEIGHT;
		floorDef1.typeID    = 1;
		floorDef1.frequency = Global.FLOOR_HEIGHT;
		
		EntityDef floorDef2 = new EntityDef();
		floorDef2.width     = Global.FLOOR_WIDTH;
		floorDef2.height    = Global.FLOOR_HEIGHT;
		floorDef2.typeID    = 1;
		floorDef2.frequency = Global.FLOOR_HEIGHT;
		
		floorHandlers = new LinkedList<TileHandler>();
		floorHandlers.addLast(new TileHandler(player, floorDef1));
		
//		Hard coded for now until file reader is working
//		Prop Factories
		EntityDef propDef1 = new EntityDef();
		propDef1.width  = 624;
		propDef1.height = 334;
		propDef1.spawnHeight = Global.FLOOR_HEIGHT - 20f;
		propDef1.typeID = 0;
		propDef1.frequency = 3072;
//		propDef1.offset = 0;
		
		EntityDef propDef2 = new EntityDef();
		propDef2.width  = 624;
		propDef2.height = 334;
		propDef2.spawnHeight = Global.FLOOR_HEIGHT - 20f;
		propDef2.typeID = 1;
		propDef2.frequency = 3072;
		propDef2.offset = 1024;
		
		EntityDef propDef3 = new EntityDef();
		propDef3.width = 152;
		propDef3.height = 178;
		propDef3.spawnHeight = Global.CAMERA_HEIGHT-propDef3.height;
		propDef3.typeID = 2;
		propDef3.frequency = 3072;
		propDef3.offset = 236;
		
		EntityDef propDef4 = new EntityDef();
		propDef4.width = 152;
		propDef4.height = 178;
		propDef4.spawnHeight = Global.CAMERA_HEIGHT-propDef4.height;
		propDef4.typeID = 2;
		propDef4.frequency = 3072;
		propDef4.offset = 1260;
		
		propHandlers = new LinkedList<TileHandler>();
		propHandlers.addLast(new TileHandler(player,propDef1));
		propHandlers.addLast(new TileHandler(player,propDef2));
		propHandlers.addLast(new TileHandler(player,propDef3));
		propHandlers.addLast(new TileHandler(player,propDef4));
		
		
//		Foreground factories
		EntityDef foregroundDef1 = new EntityDef();
		foregroundDef1.width = 360;
		foregroundDef1.height = 90;
		foregroundDef1.spawnHeight = Global.FLOOR_HEIGHT - 20f;
		foregroundDef1.typeID = 1;
		foregroundDef1.frequency = 3072;
		foregroundDef1.offset = 1156;
		
		EntityDef foregroundDef2 = new EntityDef();
		foregroundDef2.width = 152;
		foregroundDef2.height = 178;
		foregroundDef2.spawnHeight = Global.CAMERA_HEIGHT-foregroundDef2.height;
		foregroundDef2.typeID = 0;
		
		foregroundHandlers = new LinkedList<TileHandler>();
		foregroundHandlers.addLast(new TileHandler(player,foregroundDef1));
	}
	
	
	/* Methods */

	public void update() {
		updateHandler(floorHandlers);
		updateHandler(backgroundHandlers);
		updateHandler(propHandlers);
		updateHandler(foregroundHandlers);
	}

	
	/* Getters */
	
	public Player getPlayer() {	return player; }

	public LinkedList<TileHandler> getBackgroundHandlers() { 
		return backgroundHandlers;
	}

	public LinkedList<TileHandler> getFloorHandlers() {	return floorHandlers; }

	public LinkedList<TileHandler> getPropHandlers() { return propHandlers; }

	public LinkedList<TileHandler> getForegroundHandlers() {
		return foregroundHandlers;
	}

	public LinkedList<EntityMovable> getTilesFromHandler(TileHandler handler) {
		return handler.getTiles();
	}
	
	
	/* Helper Methods */
	private void updateHandler(LinkedList<TileHandler> tileHandlerList) {
		for (TileHandler tileHandler : tileHandlerList) {
			tileHandler.update();
		}
	}
	
}
