package com.barrunner.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;
import com.barrunner.model.World;

/**
 * Used to render Debug shapes/outlines over the normal worldRenderings 
 */
public class DebugWorldRenderer extends WorldRenderer implements Disposable {
	
	/* Variables */
	private ShapeRenderer debugRenderer;
	
	
	/* Constructors */
	public DebugWorldRenderer(World world, OrthographicCamera camera,
			SpriteBatch batch) {
		super(world, camera, batch);
	}
	
	
	/* Methods */

	@Override
	public void dispose() {
		debugRenderer.dispose();
	}
	
	
}
