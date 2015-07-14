
package com.barrunner.controller;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.barrunner.model.Player;


public class PlayerController implements InputProcessor {
	
	/* --- Constants--- */
	private final int THRESHOLD_MINIMUM = 10;

	/* --- Variables --- */
	private int    startY;
	private String activeKey;
	private Player player;
	

	/* --- Constructors --- */
	public PlayerController(Player player) {
		this.player = player;
		activeKey = "";
	}

	/* --- Methods --- */
	public void update() {
	}
	
	public String isKeyPressed() {
		return activeKey;
	}

	@Override
    public boolean keyDown(int keycode) {
		switch(keycode) {
		case Keys.SPACE:
		case Keys.UP:		player.Jump();
							activeKey = "JUMP";
			break;
		case Keys.DOWN:     player.Slide();
							activeKey = "SLIDE";
			break;
		}
	    return true;
    }

	@Override
    public boolean keyUp(int keycode) {
		activeKey = "";
	    return false;
    }

	@Override
    public boolean keyTyped(char character) {
	    return false;
    }

	
	@Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		startY = screenY;
	    return true;
    }

	@Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (screenY > startY && screenY - startY > THRESHOLD_MINIMUM) {
			player.Slide();
			activeKey = "SLIDE";
		}
//		else if(screenY < startY && startY - screenY > THRESHOLD_MINIMUM)
//		{
//			player.jump();
//		}
		else {
			player.Jump();
			activeKey = "JUMP";
		}
	    return true;
    }

	@Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
	    return false;
    }

	@Override
    public boolean mouseMoved(int screenX, int screenY) {
		activeKey = "";
	    return false;
    }

	@Override
    public boolean scrolled(int amount) {
	    return false;
    }
	
}
