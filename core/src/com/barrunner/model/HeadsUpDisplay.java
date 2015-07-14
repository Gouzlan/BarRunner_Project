
package com.barrunner.model;

import com.badlogic.gdx.Gdx;

public class HeadsUpDisplay {
	
	/* Variables */
	private float  timeElapsed;
	private World  world;
	
	/* Constructors */
	
	public HeadsUpDisplay(World world)
	{
		this.world = world;
		InitializeHUD();
	}
	
	
	/* Methods */
	
	public void update() {
		timeElapsed += Gdx.graphics.getDeltaTime();
	}

	public float GetTimeElapsed() {
		return timeElapsed;
	}

	public int GetDrunkPercentage() {
		return world.GetDrunkPercentage();
	}		
	
	
	/* Helper Methods */
	
	private void InitializeHUD() {
		timeElapsed = 0f;
	}
}
