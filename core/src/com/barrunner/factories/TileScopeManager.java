package com.barrunner.factories;

import java.util.LinkedList;

import com.barrunner.Global;
import com.barrunner.model.EntityMovable;
import com.barrunner.model.Player;

public class TileScopeManager {
	/* Static Methods */
	
	public static boolean isPlayerInScope(Player player, LinkedList<EntityMovable> tiles) {
		if(tiles.getLast().getX() < (player.getX() + Global.CAMERA_WIDTH * 2)) {
			return true;
		}
	removeTileIfOutOfScope(player, tiles);
	
	return false;
	}
	
	public static void addTileToList(EntityMovable tile, LinkedList<EntityMovable> tiles) {
		tiles.addLast(tile);
	}
	
	
	/* Static Helper Methods */
	
	private static void removeTileIfOutOfScope(Player player, LinkedList<EntityMovable> tiles) {
		if(tiles.getFirst().getX() < (player.getX() - Global.CAMERA_WIDTH * 2))
		{
			tiles.remove();
		}
	}
}
