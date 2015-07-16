local Global      = luajava.bindClass('com.barrunner.Global')
local EntityDef   = luajava.bindClass('com.barrunner.model.definitions.EntityDef')
local TileHandler = luajava.bindClass('com.barrunner.factories.TileHandler')

levelLoader = {}

local BACKGROUND_XVELOCITY = Global.XVELOCITY / 2

levelLoader.loadBackground = function(player, backgroundHandlers)  
  
  local backgroundDef1 = luajava.new(EntityDef)
  backgroundDef1.width  = Global.CAMERA_WIDTH
  backgroundDef1.height = Global.CAMERA_HEIGHT
  backgroundDef1.typeID = 1
  backgroundDef1.xVelocity = BACKGROUND_XVELOCITY
  backgroundDef1.frequency = Global.CAMERA_WIDTH

  local backgroundDef2 = luajava.new(EntityDef)
  backgroundDef2.width  = Global.CAMERA_WIDTH
  backgroundDef2.height = Global.CAMERA_HEIGHT
  backgroundDef2.typeID = 0
  backgroundDef2.xVelocity = BACKGROUND_XVELOCITY / 2
  backgroundDef2.frequency = Global.CAMERA_WIDTH
  
  backgroundHandlers:addLast(luajava.new(TileHandler, player, backgroundDef1));
  backgroundHandlers:addLast(luajava.new(TileHandler, player, backgroundDef2));
end

levelLoader.loadFloor = function(player, floorHandlers)
  local floorDef1     = luajava.new(EntityDef)
  floorDef1.width     = Global.FLOOR_WIDTH
  floorDef1.height    = Global.FLOOR_HEIGHT
  floorDef1.typeID    = 1
  floorDef1.frequency = Global.FLOOR_HEIGHT

  local floorDef2     = luajava.new(EntityDef)
  floorDef2.width     = Global.FLOOR_WIDTH
  floorDef2.height    = Global.FLOOR_HEIGHT
  floorDef2.typeID    = 1
  floorDef2.frequency = Global.FLOOR_HEIGHT

  floorHandlers:addLast(luajava.new(TileHandler, player, floorDef1))   
end

levelLoader.loadProp = function(player, propHandlers)
    local propDef1 = luajava.new(EntityDef)
    propDef1.width  = 624
    propDef1.height = 334
    propDef1.spawnHeight = Global.FLOOR_HEIGHT - 20
    propDef1.typeID = 0
    propDef1.frequency = 3072
--    propDef1.offset = 0;
    
    local propDef2 = luajava.new(EntityDef)
    propDef2.width  = 624
    propDef2.height = 334
    propDef2.spawnHeight = Global.FLOOR_HEIGHT - 20
    propDef2.typeID = 1
    propDef2.frequency = 3072
    propDef2.offset = 1024
    
    local propDef3 = luajava.new(EntityDef)
    propDef3.width = 152
    propDef3.height = 178
    propDef3.spawnHeight = Global.CAMERA_HEIGHT - propDef3.height
    propDef3.typeID = 2
    propDef3.frequency = 3072
    propDef3.offset = 236
    
    local propDef4 = luajava.new(EntityDef)
    propDef4.width = 152
    propDef4.height = 178
    propDef4.spawnHeight = Global.CAMERA_HEIGHT - propDef4.height
    propDef4.typeID = 2
    propDef4.frequency = 3072
    propDef4.offset = 1260
    
    propHandlers:addLast(luajava.new(TileHandler, player, propDef1))
    propHandlers:addLast(luajava.new(TileHandler, player, propDef2))    
    propHandlers:addLast(luajava.new(TileHandler, player, propDef3))    
    propHandlers:addLast(luajava.new(TileHandler, player, propDef4))    
end


levelLoader.loadForegound = function(player, foregroundHandlers)  
    local foregroundDef1 = luajava.new(EntityDef)
    foregroundDef1.width = 360
    foregroundDef1.height = 90
    foregroundDef1.spawnHeight = Global.FLOOR_HEIGHT - 20
    foregroundDef1.typeID = 1
    foregroundDef1.frequency = 3072
    foregroundDef1.offset = 1156
    
    local foregroundDef2 = luajava.new(EntityDef)
    foregroundDef2.width = 152
    foregroundDef2.height = 178
    foregroundDef2.spawnHeight = Global.CAMERA_HEIGHT - foregroundDef2.height
    foregroundDef2.typeID = 0
    
    local foregroundDef3 = luajava.new(EntityDef)
    foregroundDef3.width  = 150
    foregroundDef3.height = 250
    foregroundDef3.typeID = 2
    foregroundDef3.spawnHeight = Global.FLOOR_HEIGHT - 40
    foregroundDef3.xVelocity = BACKGROUND_XVELOCITY / 2
    foregroundDef3.frequency = Global.CAMERA_WIDTH   

    foregroundHandlers:addLast(luajava.new(TileHandler, player, foregroundDef1)) 
    foregroundHandlers:addLast(luajava.new(TileHandler, player, foregroundDef2))
    foregroundHandlers:addLast(luajava.new(TileHandler, player, foregroundDef3)) 
end

return levelLoader
