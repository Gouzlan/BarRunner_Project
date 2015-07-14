package com.barrunner.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.barrunner.Global;
import com.barrunner.controller.PlayerController;
import com.barrunner.model.HeadsUpDisplay;
import com.barrunner.model.World;

/**
 * Used to render additional debug information while still rendering the normal 
 * 	HeadsUpDisplayRenderer information.
 */
public class DebugHeadsUpDisplayRenderer extends HeadsUpDisplayRenderer {
	
	/* Variables */
	private String activeKey;
	private SpriteBatch batch;
	private BitmapFont  blackFont;
	private PlayerController controller;

	/* Constructors */
	public DebugHeadsUpDisplayRenderer(HeadsUpDisplay hud, World world,
			SpriteBatch batch, PlayerController controller) {
		super(hud, world, batch);
		this.batch = batch;
		this.controller = controller;

		activeKey = "";
		blackFont = new BitmapFont(
				Gdx.files.internal("fonts/white_fonts/WhiteFont.fnt"));
	}
	
	
	/* Methods */
	
	public void render(Vector2 cameraPosition) {
		super.render(cameraPosition);
		
		if (isControllerKeyPressed()) {
			blackFont.draw(batch, activeKey, 
						   cameraPosition.x + Global.CAMERA_WIDTH - 100,
					       (-Global.CAMERA_HEIGHT / 2 + 85));
		}
	}

	public void dispose() {
		super.dispose();
	}
	
	
	/* Helper Methods */
	
	private boolean isControllerKeyPressed() {
		activeKey = controller.isKeyPressed();
		if(activeKey.length() > 0) {
			return true;
		}
		return false;
	}
}
