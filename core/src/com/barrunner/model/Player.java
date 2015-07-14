package com.barrunner.model;

import com.barrunner.Global;
import com.barrunner.model.definitions.PlayerDef;

public class Player extends EntityMovable {
	
	/* Constants */
	private static final float X_SPAWN = (-512 + 70f);
	private static final float Y_SPAWN = (-256 + 64f);
	private static final float PLAYER_WIDTH = 65f;
	private static final float PLAYER_HEIGHT = 86f;
	
	
	/* Variables */
	public String activeKey;
	public PlayerDef playerDef;
	private int drunkPercentage;
	
	/* Constructors */
	public Player() {
		super(PLAYER_WIDTH,PLAYER_HEIGHT,0,
				new EntityPoint(X_SPAWN,Y_SPAWN));
		
		playerDef = new PlayerDef();
		drunkPercentage = 0;
		
		setXVelocity(Global.XVELOCITY);
	}
	
	/* Methods */
	
	public void update() {
		updatePosition();
	}

	public void Jump() {
	}

	public void Slide() {
	}


	/* Getters */
	
	public int getDrunkPercentage() { return drunkPercentage; }

	public float getXVelocity() { return getXVelocity(); }
	
	public float getYVelocity() { return getXVelocity(); }
		
	/* Setters */
	
	
	/* Helpers */
}
