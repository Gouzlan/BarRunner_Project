package com.barrunner.view;


import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.barrunner.factories.TileHandler;
import com.barrunner.model.EntityMovable;
import com.barrunner.model.Level;

public class LevelRenderer {
	/* Variables */
	private Level level;
	private SpriteBatch batch;
	private Texture [] floorTextures;
	private Texture [] propTextures;
	private Texture [] backgroundTextures;
	private Texture [] foregroundTextures;
	
	private TextureRegion [] floorRegions;
	private TextureRegion [] propRegions;
	private TextureRegion [] foregroundRegions;
	private TextureRegion [] backgroundRegions;
	
	

	/* Constructors */
	public LevelRenderer(Level level, SpriteBatch batch)
	{
		this.level = level;
		this.batch = batch;
		floorTextures 	   = new Texture[2];
		backgroundTextures = new Texture[2];
		foregroundTextures = new Texture[3];
		propTextures 	   = new Texture[3];
		
		floorRegions	   = new TextureRegion[2];
		backgroundRegions  = new TextureRegion[2];
		foregroundRegions  = new TextureRegion[3];
		propRegions		   = new TextureRegion[3];
		
		
		//HardCoded textures for now
		floorTextures[0]      = new Texture("floors/ground.png");
		floorTextures[1]      = new Texture("floors/ground_inverted.png");
		floorRegions[0]       = new TextureRegion(floorTextures[0]);
		floorRegions[1]       = new TextureRegion(floorTextures[1]);
		
		backgroundTextures[0] = new Texture("backgrounds/smoke.png");
		backgroundTextures[1] = new Texture("backgrounds/trippy.png");
		backgroundRegions[0]  = new TextureRegion(backgroundTextures[0]);
		backgroundRegions[1]  = new TextureRegion(backgroundTextures[1]);
		
		foregroundTextures[0] = new Texture("props/light1.png");
		foregroundTextures[1] = new Texture("props/pooltable1.png");
		foregroundTextures[2] = new Texture("silhouettes/bannana.png");
		foregroundRegions[0]  = new TextureRegion(foregroundTextures[0]);
		foregroundRegions[1]  = new TextureRegion(foregroundTextures[1]); 
		foregroundRegions[2]  = new TextureRegion(foregroundTextures[2]);
		
		propTextures[0] = new Texture("props/bar2.png");
		propTextures[1] = new Texture("props/bar3.png");
		propTextures[2] = new Texture("props/light1.png");
		propRegions[0]  = new TextureRegion(propTextures[0]);
		propRegions[1]  = new TextureRegion(propTextures[1]);		
		propRegions[2]  = new TextureRegion(propTextures[2]);		
		
	}
	
	
	/* Methods */
	
	public void renderBackground()
	{	
		renderTilesForEachSetOfHandlers(level.getBackgroundHandlers(),backgroundRegions);
		renderTilesForEachSetOfHandlers(level.getPropHandlers(),propRegions);
		renderTilesForEachSetOfHandlers(level.getFloorHandlers(),floorRegions);
	}
	
	public void renderForeground()
	{
		renderTilesForEachSetOfHandlers(level.getForegroundHandlers(),foregroundRegions);
	}
	
	
	/* Helper Methods */
	
	private void renderTilesForEachSetOfHandlers(LinkedList<TileHandler> handlers,
											     TextureRegion[] textureArray)
	{
		for(TileHandler handler : handlers) {
			for(Object tile : level.getTilesFromHandler(handler)) {
				
				drawTile(tile, textureArray);
			}
		}
	}

	private void drawTile(Object tile, TextureRegion[] textureArray) 
	{
		batch.draw(textureArray[((EntityMovable) tile).getTypeID()],
				((EntityMovable) tile).getX(), ((EntityMovable) tile).getY(), 0f, 0f, 
				((EntityMovable) tile).getTextureWidth(), 
				((EntityMovable) tile).getTextureHeight(),
				1f, 1f, ((EntityMovable) tile).getRotation());
	}
}


