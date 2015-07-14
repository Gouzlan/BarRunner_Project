package com.barrunner.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.barrunner.Global;
import com.barrunner.model.HeadsUpDisplay;
import com.barrunner.model.World;

public class HeadsUpDisplayRenderer {
	
	/* Variables */
	private float 		   timeElapsed;
	private HeadsUpDisplay hud;
	private World 		   world;
	private SpriteBatch    batch;
	private BitmapFont     blackFont;

	
	/* Constructors */
	
	public HeadsUpDisplayRenderer(HeadsUpDisplay hud, World world,
			SpriteBatch batch) {
		timeElapsed = 0f;

		 this.world = world;
		this.batch = batch;
		this.hud = hud;

		blackFont = new BitmapFont(
				Gdx.files.internal("fonts/black_fonts/BlackFont.fnt"));
	}
	
	
	/* Methods */
	
	/**
	 * Render method gets called ~60 times/second from parent render method.
	 * 
	 * @param delta the amount of time passed since that last frame draw.
	 */
	public void render(Vector2 cameraPosition) {
		hud.update();
		timeElapsed = hud.GetTimeElapsed();

		// Draw Timer at specific coordinates to keep it at the top middle of
		// screen
		blackFont.draw(batch, String.format("%.2f", timeElapsed),
				cameraPosition.x + Global.CAMERA_WIDTH / 2 - 39,
				Global.CAMERA_HEIGHT - 270);

		blackFont.draw(
				batch,
				"Drunk Percentage: "
						+ Integer.toString(hud.GetDrunkPercentage()),
				cameraPosition.x, -230);

	}
	
	public void dispose() {
	}
}
