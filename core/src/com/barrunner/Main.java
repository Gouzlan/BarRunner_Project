package com.barrunner;

import com.badlogic.gdx.Game;
import com.barrunner.screens.GameScreen;


public class Main extends Game {
	
	/* Starts Main Game */
	@Override
	public void create() {
		setScreen(new GameScreen(this));
	}

}