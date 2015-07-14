
package com.barrunner.factories;

import com.barrunner.Global;
import com.barrunner.model.EntityMovable;
import com.barrunner.model.EntityPoint;
import com.barrunner.model.definitions.EntityDef;

public class EntityFactory {
	
	/* Variables */
	private float previousXCoord;
	private EntityDef definition;
	private EntityMovable tile;
	

	/* Constructors */
	public EntityFactory(EntityDef definition) {
		this.definition = definition;
		previousXCoord = -(Global.CAMERA_WIDTH - definition.offset);
	}

	
	/* Methods */
	
	public EntityMovable createTile() {
		initializeTile(previousXCoord);
		previousXCoord += definition.frequency;
		return tile;
	}
	
	public void translateX() {
		previousXCoord += definition.xVelocity;
	}
	
	
	/* Getters */
	
	public EntityMovable getTile() {
		return tile;
	}
	
	
	/* Helper Methods */
	
	private void initializeTile(float xCoordinate) {
		tile = new EntityMovable(definition.width,definition.height,
						definition.typeID,new EntityPoint(xCoordinate,
						-(Global.CAMERA_HEIGHT / 2f) + definition.spawnHeight),
						definition.xVelocity,definition.rotation);
	}
}
