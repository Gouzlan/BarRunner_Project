package com.barrunner.model;

import com.badlogic.gdx.math.Rectangle;

public class EntityNew {

	/* Enumerated Types */
	public enum CollisionLocation {
		LEFT, TOP, NONE
	}

	public enum EntityState {
		ACTIVE, INACTIVE, DESTROYED
	}

	/* Constants */
	private final float DEFAULT_TERMINAL_VELOCITY = -.20f;
	private final float DEFAULT_GRAVITY_AMOUNT = 1.4f;

	/* Variables */
	private static int currentEntityNum = 0; // Keeps a running count of total
											// entity's so that serial
											// numbers are not duplicated
	private boolean collidable;
	private boolean grounded;
	private int typeID;
	private int serialNumber;
	private float textureWidth;
	private float textureHeight;
	private float rotation;
	private float xVelocity;
	private float yVelocity;
	private float gravity;
	private float terminalVelocity;
	private Rectangle physicalBounds;
	private EntityPoint textureLocation;
	private Object objectData;
	private EntityState state;

	
	/* Constructors */
	public EntityNew(float textureWidth, float textureHeight, int entityID,
			EntityPoint textureLocation) {
		initializeDefaultValues();
	}

	public EntityNew(float textureWidth, float textureHeight, int entityID,
			EntityPoint textureLocation, float xVelocity, float rotation) {
		initializeDefaultValues();
	}

	
	/* Methods */

	public void translate(float x, float y) {
		setX(x);
		setY(y);
	}

	public void shiftHorizontaily(float valueToShiftBy) {
		physicalBounds.x += valueToShiftBy;
		textureLocation.x += valueToShiftBy;
	}

	public void shiftVertically(float valueToShiftBy) {
		physicalBounds.y += valueToShiftBy;
		textureLocation.y += valueToShiftBy;
	}

	public void deactivate() {
		state = EntityState.INACTIVE;
	}

	public void destroy() {
		state = EntityState.DESTROYED;
	}

	public boolean isActive() {
		return state.equals(EntityState.ACTIVE);
	}

	public void updatePosition() {
		shiftHorizontaily(xVelocity);
		shiftVertically(yVelocity);
	}

	/* Setters */

	public void setX(float x) {
		physicalBounds.x = x + (textureLocation.x - physicalBounds.x);
		textureLocation.x = x;
	}

	public void setY(float y) {
		physicalBounds.y = y + (textureLocation.y - physicalBounds.y);
		textureLocation.y = y;
	}

	public void setCollidableTrue() {
		collidable = true;
	}

	public void setCollidableFalse() {
		collidable = false;
	}

	public void setTextureWidth(float textureWidth) {
		this.textureWidth = textureWidth;
	}

	public void setTextureHeight(float textureHeight) {
		this.textureHeight = textureHeight;
	}

	public void setPhysicalBounds(Rectangle physicalBounds) {
		this.physicalBounds = physicalBounds;
	}

	public void setTextureLocation(EntityPoint textureLocation) {
		this.textureLocation = textureLocation;
	}

	public void setObjectData(Object objectData) {
		this.objectData = objectData;
	}

	public void setXVelocity(float xVelocity) {
		this.xVelocity = xVelocity;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	
	/* Getters */

	public boolean isGrounded() {
		return grounded;
	}

	/**
	 * Checks to see if the current entity is colliding with another entity
	 * being passed in.
	 */
	public boolean isCollidingWith(EntityNew otherEntity) {
		return physicalBounds.overlaps(otherEntity.physicalBounds);
	}

	public float getX() {
		return textureLocation.x;
	}

	public float getY() {
		return textureLocation.y;
	}

	public EntityPoint getPosition() {
		// Returns a deep copy of position
		return textureLocation.clone();
	}

	public boolean isCollidable() {
		return collidable;
	}

	public float getTextureWidth() {
		return textureWidth;
	}

	public float getTextureHeight() {
		return textureHeight;
	}

	public Rectangle getPhysicalBounds() {
		return physicalBounds;
	}

	public EntityPoint getTextureLocation() {
		return textureLocation;
	}

	public Object getObjectData() {
		return objectData;
	}

	public int getTypeID() {
		return typeID;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public EntityState getState() {
		return state;
	}

	public float getXVelocity() {
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
		grounded = false;
		rotation = 0f;
		xVelocity = 0f;
		yVelocity = 0f;
		gravity = DEFAULT_GRAVITY_AMOUNT;
		terminalVelocity = DEFAULT_TERMINAL_VELOCITY;

		serialNumber = currentEntityNum;

		/*
		 * Reset Entity counter so that it doesn't go past the max unsigned int
		 * and crash. Even though this is unlikely. We don't want a donkeyKong
		 * crash happening...
		 */
		if (currentEntityNum == 10001) {
			// Since the obstacles are being destroyed regularly, we can reset
			// the counter safely.
/*
 * Player needs to be Entity number 0 need to refactor this so no
 * dependency
 */
			currentEntityNum = 0;
		}
		++currentEntityNum;

		collidable = false;
		objectData = null;
		state = EntityState.ACTIVE;
	}

}
