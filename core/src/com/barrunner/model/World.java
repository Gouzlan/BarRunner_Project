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
		level = new Level(player);
	}

	public void update(float delta) {
		player.update();
		level.update();
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
