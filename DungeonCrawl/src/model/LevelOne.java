package model;

import java.util.ArrayList;
import static model.GameData.MAP_HEIGHT;
import static model.GameData.MAP_WIDTH;
import model.Immoveable.Collectible.Boot;
import model.Immoveable.Collectible.Chip;
import model.Immoveable.Collectible.Key;
import model.Immoveable.Tile.Bomb;
import model.Immoveable.Tile.Button;
import model.Immoveable.Tile.Fire;
import model.Immoveable.Tile.Force;
import model.Immoveable.Tile.Ice;
import model.Immoveable.Tile.Lock;
import model.Immoveable.Tile.Portal;
import model.Immoveable.Tile.Thief;
import model.Immoveable.Tile.ToggleWall;
import model.Immoveable.Tile.Wall;
import model.Immoveable.Tile.Water;
import model.Moveable.Ball;
import model.Moveable.Block;
import model.Moveable.Bug;
import model.Moveable.Fireball;
import model.Moveable.Frog;
import model.Moveable.Gamer;
import model.Moveable.Tank;
import model.Moveable.Glider;
import model.Moveable.Walker;

public final class LevelOne extends Level{
    
    public LevelOne(){
        resetLevel();
        /*Level.fLevelOne = true; 
        Level.fLevelTwo = false;  
        Level.fLevelThree = false; */
    }
    
    @Override
    public void setGamer(){
        super.gamer = new Gamer(4, 1);
    }

    @Override
    public void setImmovableObjects() {   
        super.immovableObjects = new ArrayList<>();
        
        //Walls
        for(int i = 0; i <= MAP_WIDTH; ++i){
            super.immovableObjects.add(new Wall(i, 0));
            super.immovableObjects.add(new Wall(i, MAP_HEIGHT));
        }
        
        for(int i = 0; i <= MAP_HEIGHT; ++i){
            super.immovableObjects.add(new Wall(0, i));
            super.immovableObjects.add(new Wall(MAP_WIDTH, i));
        }        
        
        for(int i = 0; i <= 13; ++i){
            super.immovableObjects.add(new Wall(i, 8));
            if(i != 4 && i < 8){
                super.immovableObjects.add(new Wall(8, i));
            }
        }
        
        for(int i = 10; i <= 20; ++i){
            super.immovableObjects.add(new Wall(8, i));
            super.immovableObjects.add(new Wall(22, i));
        }
        for(int i = 9; i <= 14; ++i){
            super.immovableObjects.add(new Wall(i, 10));
            super.immovableObjects.add(new Wall(i, 20));
        }
        for(int i = 16; i <= 21; ++i){
            super.immovableObjects.add(new Wall(i, 10));
            super.immovableObjects.add(new Wall(i, 20));
        }
        
        for(int i = 12; i < 19; ++i){
            super.immovableObjects.add(new Wall(10, i));
            super.immovableObjects.add(new Wall(20, i));
        }
        
        for(int i = 11; i < 20; ++i){
            if(i != 15){
                super.immovableObjects.add(new Wall(i, 12));
                super.immovableObjects.add(new Wall(i, 18));  
                if(i != 14 && i != 16){
                    super.immovableObjects.add(new Wall(i, 14));
                    super.immovableObjects.add(new Wall(i, 16));
                }
            }            
        }
        
        super.immovableObjects.add(new Wall(11, 15));
        super.immovableObjects.add(new Wall(19, 15));
        
        super.immovableObjects.add(new Wall(14, 8));
        super.immovableObjects.add(new Wall(14, 9));
        super.immovableObjects.add(new Wall(14, 21));
        super.immovableObjects.add(new Wall(14, 22));
        super.immovableObjects.add(new Wall(14, 25));
        super.immovableObjects.add(new Wall(14, 26));
        
        super.immovableObjects.add(new Wall(15, 22));
        super.immovableObjects.add(new Wall(16, 8));
        super.immovableObjects.add(new Wall(16, 9));
        super.immovableObjects.add(new Wall(16, 21));
        super.immovableObjects.add(new Wall(16, 22));
        super.immovableObjects.add(new Wall(16, 25));
        super.immovableObjects.add(new Wall(16, 26));
        
        super.immovableObjects.add(new Wall(17, 22));
        super.immovableObjects.add(new Wall(17, 25));
        super.immovableObjects.add(new Wall(18, 21));
        super.immovableObjects.add(new Wall(18, 26));
        super.immovableObjects.add(new Wall(22, 21));        
        super.immovableObjects.add(new Wall(22, 26));
        super.immovableObjects.add(new Wall(23, 25));
  
        super.immovableObjects.add(new Wall(23, 23));
        super.immovableObjects.add(new Wall(23, 22));
        super.immovableObjects.add(new Wall(24, 22));
        super.immovableObjects.add(new Wall(25, 22));
        super.immovableObjects.add(new Wall(27, 22));
        super.immovableObjects.add(new Wall(28, 22));
        super.immovableObjects.add(new Wall(29, 22));
        
        
        for (int i = 24; i < 29; i += 2) {
            for (int j = 11; j < 20; j += 4) {
                super.immovableObjects.add(new Wall(i, j));
            }
        }
        for (int i = 23; i < 30; i += 2) {
            for (int j = 9; j < 18; j += 4) {
                super.immovableObjects.add(new Wall(i, j));
            }
        }
        
        //Level keys
        super.immovableObjects.add(new Key(4, 4, LockType.BLUE));
        super.immovableObjects.add(new Key(11, 13, LockType.GREEN));
        super.immovableObjects.add(new Key(11, 17, LockType.RED));
        super.immovableObjects.add(new Key(19, 13, LockType.BLUE));
        super.immovableObjects.add(new Key(15, 21, LockType.YELLOW));
        
        //Level locks
        super.immovableObjects.add(new Lock(8, 4, LockType.BLUE));
        super.immovableObjects.add(new Lock(12, 13, LockType.RED));
        super.immovableObjects.add(new Lock(12, 17, LockType.YELLOW));
        super.immovableObjects.add(new Lock(18, 13, LockType.GREEN));
        super.immovableObjects.add(new Lock(18, 17, LockType.BLUE));
        super.immovableObjects.add(new Lock(15, 25, LockType.SOCKET));
        
        //Level boots
        super.immovableObjects.add(new Boot(3, 3, BootType.FIRE));
        super.immovableObjects.add(new Boot(15, 10, BootType.WATER));
        super.immovableObjects.add(new Boot(13, 21, BootType.FORCE));
        super.immovableObjects.add(new Boot(13, 26, BootType.ICE));
        
        //Level Chips
        super.immovableObjects.add(new Chip(4, 3));
        super.immovableObjects.add(new Chip(4, 5));
        super.immovableObjects.add(new Chip(3, 4));
        super.immovableObjects.add(new Chip(5, 4));
        super.immovableObjects.add(new Chip(19, 17));
        super.immovableObjects.add(new Chip(23, 26));
        
        //Level Elemental Walls
        super.immovableObjects.add(new Water(13,19));
        super.immovableObjects.add(new Bomb(2,9));
        super.immovableObjects.add(new Bomb(9,6));
        super.immovableObjects.add(new Water(15, 8));
        super.immovableObjects.add(new Water(15, 9));
        super.immovableObjects.add(new Water(15, 12));
        super.immovableObjects.add(new Water(20, 23));
        //for testing of glider
        super.immovableObjects.add(new Water(5, 18));
        super.immovableObjects.add(new Water(4, 18));
        super.immovableObjects.add(new Water(6, 18));
        super.immovableObjects.add(new Water(5, 17));
        super.immovableObjects.add(new Water(5, 16));
        
        super.immovableObjects.add(new Fire(17,19));
        super.immovableObjects.add(new Fire(10, 4));
        super.immovableObjects.add(new Fire(14, 6));
        super.immovableObjects.add(new Fire(20, 24));
        
        //Theif tile
        super.immovableObjects.add(new Thief(15, 15));
        
        //Toggle Walls
        ArrayList<GameObject> toggleWalls = new ArrayList<>();
        toggleWalls.add(new ToggleWall(13, 13, true));
        toggleWalls.add(new ToggleWall(13, 17, false));
        toggleWalls.add(new ToggleWall(17, 13, false));
        toggleWalls.add(new ToggleWall(17, 17, true));
        super.immovableObjects.addAll(toggleWalls);
        
        //Buttons
        super.immovableObjects.add(new Button(15, 11, ButtonType.GREEN, toggleWalls));
        
        //Exit Portal
        super.immovableObjects.add(new Portal(15, 26));
        
        //Floors
        for(int i = 15; i < 20; ++i){
            super.immovableObjects.add(new Ice(i, 4));
        }        
        super.immovableObjects.add(new Ice(20, 4, Direction.NE));
        super.immovableObjects.add(new Ice(20, 5));
        super.immovableObjects.add(new Ice(20, 6, Direction.SE));
        super.immovableObjects.add(new Ice(19, 6));
        super.immovableObjects.add(new Ice(18, 6));
        super.immovableObjects.add(new Ice(17, 6, Direction.SW));
        super.immovableObjects.add(new Ice(17,5));
        super.immovableObjects.add(new Ice(17, 3, Direction.NW));
        super.immovableObjects.add(new Ice(18, 2));
        super.immovableObjects.add(new Ice(18, 1));
        super.immovableObjects.add(new Ice(18, 3));
        super.immovableObjects.add(new Ice(19, 3));
        super.immovableObjects.add(new Ice(20, 3));
        super.immovableObjects.add(new Ice(21, 3, Direction.NW));
        
        for (int i = 22; i < 26; i++) {
            super.immovableObjects.add(new Ice(26, i));
        }
        super.immovableObjects.add(new Ice(26, 26, Direction.SW));
        super.immovableObjects.add(new Ice(27, 26));
        super.immovableObjects.add(new Ice(28, 26));
        super.immovableObjects.add(new Ice(29, 26, Direction.SE));
        super.immovableObjects.add(new Ice(29, 25));
        super.immovableObjects.add(new Ice(29, 24));

        for (int i = 25; i < 29; i++) {
            super.immovableObjects.add(new Ice(i, 23));
        }
        super.immovableObjects.add(new Ice(29, 23, Direction.NE));
        super.immovableObjects.add(new Ice(24, 23, Direction.NW));
        super.immovableObjects.add(new Ice(24, 24));
        super.immovableObjects.add(new Ice(24, 25, Direction.SW));
        super.immovableObjects.add(new Ice(25, 25));
        super.immovableObjects.add(new Ice(27, 25));
        super.immovableObjects.add(new Ice(28, 25, Direction.SE));
        super.immovableObjects.add(new Ice(28, 24  , Direction.NE));
        super.immovableObjects.add(new Ice(27, 24));
        super.immovableObjects.add(new Ice(25, 24));
        
        
        for(int i = 14; i < 18; ++i){
            super.immovableObjects.add(new Force(i, 24, Direction.UP));
        }
        for(int i = 14; i < 18; ++i){
            super.immovableObjects.add(new Force(i, 23, Direction.LEFT));
        }
        
    }

    @Override
    public void setMovableObjects() {
        super.moveableObjects = new ArrayList<>();
        
        //Monsters
        //Fireball
        super.moveableObjects.add(new Fireball(4, 2, Direction.LEFT));
        super.moveableObjects.add(new Fireball(4, 6, Direction.RIGHT));
        super.moveableObjects.add(new Fireball(2, 4, Direction.DOWN));
        super.moveableObjects.add(new Fireball(6, 4, Direction.UP));
        
        //Ball
        super.moveableObjects.add(new Ball(14,15,Direction.DOWN));
        super.moveableObjects.add(new Ball(15,19,Direction.LEFT));
        super.moveableObjects.add(new Ball(13,4,Direction.RIGHT));

        super.moveableObjects.add(new Glider(5,20,Direction.UP)); 
        super.moveableObjects.add(new Glider(17,9,Direction.UP));
        //super.moveableObjects.add(new Bug(18, 19, Direction.RIGHT));
        super.moveableObjects.add(new Bug(12, 19, Direction.LEFT));
        super.moveableObjects.add(new Frog(1, 4));
                
        //Tank
        ArrayList<GameObject> tanks = new ArrayList<>();
        tanks.add(new Tank (23, 10, Direction.RIGHT));
        tanks.add(new Tank (29, 12, Direction.LEFT));
        tanks.add(new Tank (23, 14, Direction.RIGHT));
        tanks.add(new Tank (29, 16, Direction.LEFT));
        tanks.add(new Tank (23, 18, Direction.RIGHT));
        tanks.add(new Tank (29, 20, Direction.LEFT));
        super.moveableObjects.addAll(tanks);
        
        //Walker
        super.moveableObjects.add(new Walker (18, 22, Direction.RIGHT));
        super.moveableObjects.add(new Walker (19, 21, Direction.RIGHT));
        super.moveableObjects.add(new Walker (21, 19, Direction.LEFT));
        super.moveableObjects.add(new Walker (9, 11, Direction.LEFT));
        
        //Button
        for (int i = 24; i < 30; i += 2) {            
            super.moveableObjects.add(new Button(i, 9, ButtonType.BLUE, tanks));
        }
        for (int i = 23; i < 30; i += 2) {
            super.moveableObjects.add(new Button(i, 15, ButtonType.BLUE, tanks));
        }
        
        //Level blocks
        super.moveableObjects.add(new Block(12, 6));
        super.moveableObjects.add(new Block(13, 6));
        
    }

    @Override
    public void setLevelValue() {
        super.levelValue = 1;
    }

    @Override
    public void setLevelTime() {
        super.levelTime = 200;
    }

    @Override
    public void setLevelChipCount() {
        super.levelChipCount = 6;
    }
    
    @Override
    public void resetLevel(){
        setGamer();
        setImmovableObjects();
        setMovableObjects();
        setLevelValue();
        setLevelTime();
        setLevelChipCount();
    }
}
