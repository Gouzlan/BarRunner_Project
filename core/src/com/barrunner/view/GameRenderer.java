
package com.barrunner.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.barrunner.Global;
import com.barrunner.controller.PlayerController;
import com.barrunner.model.HeadsUpDisplay;
import com.barrunner.model.World;

public class GameRenderer implements Disposable {
	
	/* Variables */
	protected OrthographicCamera camera;
	
	private Vector2	cameraPosition;
	private SpriteBatch	batch;
	private WorldRenderer worldRenderer;
	private HeadsUpDisplayRenderer headsUpDisplayRenderer;
//	private FrameBuffer buffer;

	/* Constructors */
	private GameRenderer() {
		InitializeCameraBatchandBuffer();
	}
		
	
	/* Factories */
	
	/* Regular Renderer Factory */
	public static GameRenderer CreateGameRenderer(HeadsUpDisplay hud,World world) {
		GameRenderer renderer = new GameRenderer();
		renderer.worldRenderer = new WorldRenderer(world, renderer.camera, renderer.batch);
		renderer.headsUpDisplayRenderer = new HeadsUpDisplayRenderer(hud,world, renderer.batch);
		
		return renderer;
	}
	
	/* DEBUG Renderer Factory */
	public static GameRenderer CreateDebugGameRenderer(HeadsUpDisplay hud, World world,PlayerController controller) {
		GameRenderer renderer = new GameRenderer();
		renderer.worldRenderer = new DebugWorldRenderer(world, renderer.camera, renderer.batch);
		renderer.headsUpDisplayRenderer = new DebugHeadsUpDisplayRenderer(hud, world, renderer.batch,
																		  controller);
		return renderer;
	}
	
	
	/* Methods */
	
	/**
	 * Render method gets called ~60 times/second. Responsible for rendering what
	 * 	you see on the screen.
	 */
	public void render(float delta)	{		
		Gdx.gl.glClearColor(.5f, .5f, .5f, .5f);
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT);

		UpdateCameraPosition();

		batch.begin();

		// Clears Screen before rendering new one
		Gdx.graphics.getGL20().glClearColor(1, 1, 1, 1);
		Gdx.graphics.getGL20().glClear(
				GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		worldRenderer.render();
		headsUpDisplayRenderer.render(cameraPosition);

		batch.end();
		// System.out.println(batch.renderCalls);
	}
	
	/** 
	 * Disposes of batch(es) that are no longer in use
	 */
	@Override
	public void dispose() {
		batch.dispose();
		headsUpDisplayRenderer.dispose();
	}
	
	
	/* Helper Methods */
	
	private void InitializeCameraBatchandBuffer() {
		/* 
		 * Create camera and batch, set batch to use camera's projection matrix 
		 * 	before passing the batch to sub renderer's 
		 */
		camera = new OrthographicCamera(Global.CAMERA_WIDTH,
										Global.CAMERA_HEIGHT);
		cameraPosition = new Vector2(camera.position.x - Global.CAMERA_WIDTH/2,
									 camera.position.y - Global.CAMERA_HEIGHT/2);
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
		
//		buffer = new FrameBuffer(Pixmap.Format.RGB565, Global.CAMERA_WIDTH, 
//									Global.CAMERA_HEIGHT, false);
	}
	
	private void UpdateCameraPosition() {
		cameraPosition.x = camera.position.x - Global.CAMERA_WIDTH/2;
		cameraPosition.y = camera.position.y - Global.CAMERA_HEIGHT/2;
	}
}
