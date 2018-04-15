package model;

import java.util.ArrayList;
import static model.GameData.MAP_HEIGHT;
import static model.GameData.MAP_WIDTH;
import model.Immoveable.Collectible.Chip;
import model.Immoveable.Collectible.FakeChip;
import model.Immoveable.Collectible.Key;
import model.Immoveable.Tile.Bomb;
import model.Immoveable.Tile.Button;
import model.Immoveable.Tile.Dirt;
import model.Immoveable.Tile.FakeWall;
import model.Immoveable.Tile.Fire;
import model.Immoveable.Tile.Ice;
import model.Immoveable.Tile.Lock;
import model.Immoveable.Tile.Portal;
import model.Immoveable.Tile.Spawner;
import model.Immoveable.Tile.Teleporter;
import model.Immoveable.Tile.ToggleWall;
import model.Immoveable.Tile.Trap;
import model.Immoveable.Tile.Wall;
import model.Immoveable.Tile.Water;
import model.Moveable.Ball;
import model.Moveable.Block;
import model.Moveable.Bug;
import model.Moveable.Fireball;
import model.Moveable.Frog;
import model.Moveable.Gamer;
import model.Moveable.Glider;
import model.Moveable.Tank;
import model.Moveable.Walker;

public final class LevelThree extends Level {

    public LevelThree() {
        resetLevel();
    }

    @Override
    public void setGamer() {
        super.gamer = new Gamer(4, 24);
    }

    @Override
    public void setImmovableObjects() {
        super.immovableObjects = new ArrayList<>();
        
        //Start
        super.immovableObjects.add(new FakeWall(1, 22, true, false));
        for (int i = 2; i <= 5; i++) {
            super.immovableObjects.add(new FakeWall(i, 22, false, true));
        }
        super.immovableObjects.add(new FakeWall(1, 22, true, false));
        
        for (int i = 22; i <= 24; i++) {
           super.immovableObjects.add(new FakeWall(5, i, false, true));
        }
        super.immovableObjects.add(new FakeWall(5, 25, true, false));
        super.immovableObjects.add(new FakeWall(5, 26, false, true));
        
        super.immovableObjects.add(new Wall(2, 26));
        super.immovableObjects.add(new Wall(2, 25));
        
        for (int i = 2; i <= 6; i++) {
           super.immovableObjects.add(new FakeWall(i, 7, false, true));           
        }
        super.immovableObjects.add(new FakeWall(1, 7, true, false));
        for (int i = 3; i <= 6; i++) {
           super.immovableObjects.add(new FakeWall(6, i, false, true));           
        }
        super.immovableObjects.add(new FakeWall(6, 2, true, false));
        super.immovableObjects.add(new FakeWall(6, 1, false, true));
        
        //Portal 
        super.immovableObjects.add(new Portal(1, 26));        
        //Socket
        super.immovableObjects.add(new Lock(1,25 , LockType.SOCKET));
        
        //Walls
        
        for(int i = 6; i <= 22; ++i){
            super.immovableObjects.add(new Wall(i, 23));           
        }
        for(int i = 17; i <= 22; ++i){
            super.immovableObjects.add(new Wall(22, i));           
        }
        
        
        Teleporter teleportOne = new Teleporter(29, 6);
        Teleporter teleportTwo = new Teleporter(12 , 14, teleportOne);
        super.immovableObjects.add(teleportOne);
        super.immovableObjects.add(teleportTwo);
        
        Teleporter teleportThree = new Teleporter(16, 18);
        Teleporter teleportFour = new Teleporter(21 , 4, teleportThree);
        super.immovableObjects.add(teleportThree);
        super.immovableObjects.add(teleportFour);
        
        Teleporter teleportFive = new Teleporter(12, 10);
        Teleporter teleportSix = new Teleporter(21 , 12, teleportFive);
        super.immovableObjects.add(teleportFive);
        super.immovableObjects.add(teleportSix);
        
        
        
        super.immovableObjects.add(new FakeChip(7,24));
        super.immovableObjects.add(new Fire(9,24));
        super.immovableObjects.add(new FakeChip(11,24));
        super.immovableObjects.add(new Fire(13,24));
        super.immovableObjects.add(new FakeChip(15,24));
        super.immovableObjects.add(new Fire(17,24));
        super.immovableObjects.add(new Fire(19,24));
        super.immovableObjects.add(new Fire(21,24));        
        super.immovableObjects.add(new FakeChip(6,26));
        super.immovableObjects.add(new Fire(8,26));
        super.immovableObjects.add(new FakeChip(10,26));
        super.immovableObjects.add(new Fire(12,26));
        super.immovableObjects.add(new FakeChip(14,26));
        super.immovableObjects.add(new Fire(16,26));
        super.immovableObjects.add(new Fire(18,26));
        super.immovableObjects.add(new FakeChip(20,26));
        super.immovableObjects.add(new Fire(22,26));
        super.immovableObjects.add(new Bomb(23, 24));
        super.immovableObjects.add(new FakeChip(3,3));
        super.immovableObjects.add(new Chip(8,10));
        super.immovableObjects.add(new Chip(8,18));
        
        for (int i = 0; i <= MAP_WIDTH; ++i) {
            super.immovableObjects.add(new Wall(i, 0));
            super.immovableObjects.add(new Wall(i, MAP_HEIGHT));
        }
        for (int i = 0; i <= MAP_HEIGHT; ++i) {
            super.immovableObjects.add(new Wall(0, i));
            super.immovableObjects.add(new Wall(MAP_WIDTH, i));
        }
        
        for(int i = 28; i >= 24; --i){
            super.immovableObjects.add(new Wall(i, 12));
            super.immovableObjects.add(new Wall(i, 10));
        }
        super.immovableObjects.add(new Wall(24, 13));
        super.immovableObjects.add(new Wall(24, 14));
        super.immovableObjects.add(new Wall(24, 16));
        super.immovableObjects.add(new Wall(24, 17));
        super.immovableObjects.add(new Wall(23, 14));
        super.immovableObjects.add(new Wall(22, 14));
        super.immovableObjects.add(new Wall(22, 15));
        super.immovableObjects.add(new Wall(22, 16));
        super.immovableObjects.add(new Wall(23, 16));
        super.immovableObjects.add(new Wall(24, 11));
        super.immovableObjects.add(new Wall(24, 10));
        super.immovableObjects.add(new Wall(22, 10));
        super.immovableObjects.add(new Wall(22, 11));
        super.immovableObjects.add(new Wall(22, 12));
        super.immovableObjects.add(new Wall(22, 13)); 
        
        super.immovableObjects.add(new Lock(29, 10, LockType.GREEN));
        super.immovableObjects.add(new Key(24, 15, LockType.GREEN));
        
        for(int i = 1; i <= 9; ++i){
            super.immovableObjects.add(new Wall(22, i));            
        }        
        super.immovableObjects.add(new Wall(10, 9)); 
        super.immovableObjects.add(new Wall(10, 10)); 
        super.immovableObjects.add(new Wall(10, 11));
        super.immovableObjects.add(new Wall(14, 9)); 
        
        super.immovableObjects.add(new Wall(14, 11)); 
        super.immovableObjects.add(new Wall(14, 18)); 
        super.immovableObjects.add(new Wall(14, 19)); 
        super.immovableObjects.add(new Wall(14, 17)); 
        super.immovableObjects.add(new Wall(10, 17));
        super.immovableObjects.add(new Wall(10, 19));
        for(int i = 6; i <= 21; ++i){
            super.immovableObjects.add(new Wall(i, 8));  
            super.immovableObjects.add(new Wall(i, 20));  
        }
        for(int i = 9; i <= 19; ++i){
           super.immovableObjects.add(new Wall(6, i));
           super.immovableObjects.add(new Wall(18, i));
        }
        super.immovableObjects.add(new Wall(7, 12));
        super.immovableObjects.add(new Wall(9, 12));
        super.immovableObjects.add(new Wall(10, 12));
        super.immovableObjects.add(new Wall(11, 12));
        super.immovableObjects.add(new Lock(12, 12, LockType.RED));         
        super.immovableObjects.add(new Key(4, 26, LockType.RED));
        super.immovableObjects.add(new Key(7, 9, LockType.RED));
        super.immovableObjects.add(new Key(7, 19, LockType.RED));
        super.immovableObjects.add(new Key(17, 9, LockType.RED));
        for(int i = 13; i <= 18; ++i){
            super.immovableObjects.add(new Wall(i, 12));            
        }
        for(int i = 7; i <= 11; ++i){
            super.immovableObjects.add(new Wall(i, 16));            
        }
        super.immovableObjects.add(new Lock(12, 16, LockType.RED));
        super.immovableObjects.add(new Wall(10, 13));
        super.immovableObjects.add(new Wall(10, 15));
        super.immovableObjects.add(new Lock(10, 14, LockType.RED));
        super.immovableObjects.add(new Lock(14, 14, LockType.RED));
        super.immovableObjects.add(new Wall(14, 13));
        super.immovableObjects.add(new Wall(14, 15));
        super.immovableObjects.add(new Wall(13, 16));
        super.immovableObjects.add(new Wall(14, 16));
        super.immovableObjects.add(new Wall(15, 16));
        super.immovableObjects.add(new Wall(17, 16));
       
        super.immovableObjects.add(new Water(28, 13));
        super.immovableObjects.add(new Water(26, 13));
        super.immovableObjects.add(new Water(27, 17));
        super.immovableObjects.add(new Water(25, 17));
     
        super.immovableObjects.add(new Fire(3,4));
        
        //Level Chips
        super.immovableObjects.add(new Chip(2, 2));
        super.immovableObjects.add(new Chip(2, 3));
        super.immovableObjects.add(new Chip(2, 4));
        super.immovableObjects.add(new Chip(2, 5));
        super.immovableObjects.add(new Chip(3, 5));
        super.immovableObjects.add(new Chip(4, 5));
        super.immovableObjects.add(new Chip(4, 4));
        super.immovableObjects.add(new Chip(4, 3));
        super.immovableObjects.add(new Chip(4, 2));
        super.immovableObjects.add(new Chip(3, 2));
        super.immovableObjects.add(new Chip(23, 15)); 
        for(int i = 10; i <= 18; ++i){
           super.immovableObjects.add(new Chip(i, 4));           
        }
        
        //Spawner
        ArrayList<GameObject> spawners = new ArrayList<>();
        spawners.add(new Spawner(28, 17, new Fireball(28, 17, Direction.UP)));
        spawners.add(new Spawner(27, 13, new Fireball(27, 13, Direction.DOWN)));
        spawners.add(new Spawner(26, 17, new Fireball(26, 17, Direction.UP)));
        spawners.add(new Spawner(25, 13, new Fireball(25, 13, Direction.DOWN)));
        super.immovableObjects.addAll(spawners);
        
        //ToggleWalls
        ArrayList<GameObject> togglewalls = new ArrayList<>();
        togglewalls.add(new ToggleWall(23, 10, false));
        super.immovableObjects.addAll(togglewalls);
        
         //Buttons
        super.immovableObjects.add(new Button(23, 12, ButtonType.RED, spawners));
        super.immovableObjects.add(new Button(11, 25, ButtonType.RED, spawners));
        super.immovableObjects.add(new Button(15, 25, ButtonType.RED, spawners));
        super.immovableObjects.add(new Button(25, 11, ButtonType.GREEN, togglewalls));
        super.immovableObjects.add(new Button(19, 25, ButtonType.GREEN, togglewalls));
        
        for (int i = 8; i < 11; i++) {
            super.immovableObjects.add(new Ice(1, i));            
        }
        for (int i = 8; i < 12; i++) {
            for(int j = 1; j < 6; j++) {
                super.immovableObjects.add(new Ice(j, i));            
            }            
        }
        super.immovableObjects.add(new Ice(5, 11, Direction.NE));
        super.immovableObjects.add(new Ice(1, 11, Direction.SW));
 }

    @Override
    public void setMovableObjects() {
        super.moveableObjects = new ArrayList<>();
        
        super.moveableObjects.add(new Block(16, 10));
        super.moveableObjects.add(new Block(8, 10));
        super.moveableObjects.add(new Block(12, 18));
        super.moveableObjects.add(new Block(8, 14));
        super.moveableObjects.add(new Block(8, 18));
        
        super.moveableObjects.add(new Block(16, 14));
        
        super.moveableObjects.add(new Ball(23, 13, Direction.UP));
        super.moveableObjects.add(new Frog(23, 17));
        super.moveableObjects.add(new Frog(24, 2));
        super.moveableObjects.add(new Frog(24, 3));
        super.moveableObjects.add(new Frog(24, 4));
        super.moveableObjects.add(new Frog(24, 5));
        super.moveableObjects.add(new Frog(25, 2));
        super.moveableObjects.add(new Frog(26, 2));
        super.moveableObjects.add(new Frog(27, 2));
        super.moveableObjects.add(new Frog(3, 17));
        
        super.moveableObjects.add(new Glider(7, 1, Direction.RIGHT));
        super.moveableObjects.add(new Glider(14, 1, Direction.RIGHT));
        super.moveableObjects.add(new Glider(21, 1, Direction.DOWN));
        super.moveableObjects.add(new Glider(21, 7, Direction.LEFT));
        super.moveableObjects.add(new Glider(14, 7, Direction.LEFT));
        super.moveableObjects.add(new Glider(7, 7, Direction.UP));
        
        super.moveableObjects.add(new Glider(1, 18, Direction.UP));
        super.moveableObjects.add(new Glider(5, 12, Direction.DOWN));
        
        
        super.moveableObjects.add(new Walker(20, 19, Direction.UP));
        super.moveableObjects.add(new Walker(19, 19, Direction.UP));
        super.moveableObjects.add(new Walker(21, 19, Direction.UP));
        super.moveableObjects.add(new Bug(24, 25, Direction.LEFT));
        super.moveableObjects.add(new Fireball(25, 25, Direction.RIGHT));
        
        ArrayList<GameObject> tanks = new ArrayList<>();
        tanks.add(new Tank (20, 21, Direction.LEFT));
        tanks.add(new Tank (20, 22, Direction.LEFT));
        tanks.add(new Tank (23, 18, Direction.RIGHT));
        super.moveableObjects.addAll(tanks);
        super.moveableObjects.add(new Button(1, 21, ButtonType.BLUE, tanks));
    }

    @Override
    public void setLevelValue() {
        super.levelValue = 3;
    }

    @Override
    public void setLevelTime() {
        super.levelTime = 120;
    }

    @Override
    public void setLevelChipCount() {
        super.levelChipCount = 30;
    }

    @Override
    public void resetLevel() {
        setGamer();
        setImmovableObjects();
        setMovableObjects();
        setLevelValue();
        setLevelTime();
        setLevelChipCount();
    }

}
