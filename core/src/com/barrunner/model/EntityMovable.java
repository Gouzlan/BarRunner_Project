package com.barrunner.model;

public class EntityMovable extends Entity {
	
	/* Constants */
	private final float DEFAULT_TERMINAL_VELOCITY = -.20f;
	private final float DEFAULT_GRAVITY_AMOUNT = 1.4f;
	
	/* Variables */
	private boolean grounded;
	private float   rotation;
	private float   xVelocity;
	private float   yVelocity;
	private float   gravity;
	private float   terminalVelocity;

	/* Constructors */
	public EntityMovable(float textureWidth, float textureHeight, int entityID,
			EntityPoint textureLocation) {
		super(textureWidth, textureHeight, entityID, textureLocation);
		initializeDefaultValues();
	}
	
	public EntityMovable(float textureWidth, float textureHeight, int entityID,
			EntityPoint textureLocation, float xVelocity, float rotation) {
		super(textureWidth, textureHeight, entityID, textureLocation);
		initializeDefaultValues();
		this.xVelocity = xVelocity;
		this.rotation = rotation;
	}

	
	/* Methods */
	
	public void update() {
	}
	
	public void updatePosition() {
		shiftHorizontaily(xVelocity);
		shiftVertically(yVelocity);
    }
	
	
	/* Setters */
	
	public void setXVelocity(float xVelocity) {
		this.xVelocity = xVelocity;
	}
	
	public void setRotation(float rotation)	{
		this.rotation = rotation;
	}
	
	
	/* Getters */
	
	public boolean isGrounded() {
		return grounded;
	}
	
	public float getXVelocity()	{
		return xVelocity;
	}
	
	public float getRotation() {
		return rotation;
	}
	
	public float getTerminalVelocity() {
		return terminalVelocity;
	}
	
	public float getGravity() {
		return gravity;
	}
	
	
	/* Helper Methods */
	
	private void initializeDefaultValues() {
		grounded  = false;
		rotation  = 0f;
		xVelocity = 0f;
		yVelocity = 0f;
		gravity   = DEFAULT_GRAVITY_AMOUNT;
		terminalVelocity = DEFAULT_TERMINAL_VELOCITY;
		
	}
}
