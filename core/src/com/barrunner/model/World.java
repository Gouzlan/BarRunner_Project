package com.barrunner.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

/**
 * Responsible for updating the Player, Level and HeadsUpDisplay (HUD) elements.
 * 	The World will act as a pipeline for information to travel between these 
 * 	assets as the game progresses
 */
public class World {
	
	/* Variables */
	private Player player;
	private Level  level;

	public World() {
		player = new Player();
		level = new Level(player, "lua/level1.lua");
		
//		level = new Level(player);
//		level.load("lua/level1.lua");
	}

	private int timer = 0;
	public static int time = 100;
	public void update(float delta) {
		player.update();
		level.update();
		
//		level.load(luaFile);
	}
	
	public void updateVelocity() {
		
	}
	

	public Player GetPlayer() {
		return player;
	}

	public Level GetLevel() {
		return level;
	}

	public int GetDrunkPercentage() {
		return player.getDrunkPercentage();
	}
}
