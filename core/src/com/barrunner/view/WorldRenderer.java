package com.barrunner.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.barrunner.model.World;

public class WorldRenderer {
	
	/* Variables */
	SpriteBatch batch;
	LevelRenderer levelRenderer;
	PlayerRenderer playerRenderer;

	public WorldRenderer(World world, OrthographicCamera camera,
			SpriteBatch batch) {
		this.batch = batch;
		playerRenderer = new PlayerRenderer(world.GetPlayer(), camera, batch);
		levelRenderer = new LevelRenderer(world.GetLevel(), batch);
	}

	public void render() {
		/*
		 * Order Matters Things rendered first will be displayed in the back of
		 * screen, and likewise things rendered last will be in the front of
		 * screen. Treated as though it is a stack of render methods.
		 */
		playerRenderer.updateCamera();
		levelRenderer.renderBackground();
		playerRenderer.render();
		levelRenderer.renderForeground();
	}
}
