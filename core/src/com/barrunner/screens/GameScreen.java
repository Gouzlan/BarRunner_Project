
package com.barrunner.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.barrunner.controller.PlayerController;
import com.barrunner.model.HeadsUpDisplay;
import com.barrunner.model.World;
import com.barrunner.view.GameRenderer;

public class GameScreen extends BarRunnerScreen {

	/* Variables */
	GameRenderer renderer;
	World world;
	HeadsUpDisplay hud;
	PlayerController controller;
	
	
	/* Constructors */
	
	public GameScreen(Game game) {
		super(game);

		world = new World();
		hud = new HeadsUpDisplay(world);

		controller = new PlayerController(world.GetPlayer());
		Gdx.input.setInputProcessor(controller);

		renderer = GameRenderer.CreateDebugGameRenderer(hud, world, controller);
	}

	
	/* Methods */
	
	/**
	 * Main render call method gets called ~60 times/second.
	 * 
	 * @param delta the amount of time passed since that last frame draw.
	 */
	@Override
	public void render(float delta) {
		world.update(delta);
		renderer.render(delta);
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

}
