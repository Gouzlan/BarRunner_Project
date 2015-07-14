package com.barrunner.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.barrunner.model.Player;

public class PlayerRenderer {
	
	/* Constants */
	private final float FRAME_DURATION = .04f;
	private final float PLAYER_OFFSET_FROM_SCREEN_EDGE = 350;
	
	/* Variables */
	private int currentFrame;
	private float animationTime;
	private Player player;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	
	private Texture [] runTextures;

	public PlayerRenderer(Player player, OrthographicCamera camera,
			SpriteBatch batch) {
		currentFrame = 0;
		this.player = player;
		this.camera = camera;
		this.batch = batch;

		runTextures = new Texture[11];

		for (int index = 0; index < 11; ++index) {
			runTextures[index] = new Texture("player/walk" + index + ".png");
		}
	}
	
	
	/* Methods */
	
	public void render() {
		// Controls how fast the player is animated
		animatePlayer();
		batch.draw(runTextures[currentFrame], player.getX(), player.getY(),
				player.getTextureWidth(), player.getTextureHeight());

	}
	
	public void updateCamera() {
		camera.position.x = player.getX() + PLAYER_OFFSET_FROM_SCREEN_EDGE;
		camera.update();
		batch.setProjectionMatrix(camera.combined);
	}
	
	private void animatePlayer() {
		animationTime += Gdx.graphics.getDeltaTime();

		if (currentFrame == 10) {
			currentFrame = 0;
		}

		if (animationTime > FRAME_DURATION) {
			++currentFrame;
			animationTime = 0;
		}
	}
}
