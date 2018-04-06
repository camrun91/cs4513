package model;

import java.util.ArrayList;
import static model.GameData.MAP_HEIGHT;
import static model.GameData.MAP_WIDTH;
import model.Immoveable.Collectible.Chip;
import model.Immoveable.Collectible.FakeChip;
import model.Immoveable.Collectible.Key;
import model.Immoveable.Tile.Button;
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
        super.gamer = new Gamer(1, 1);
    }

    @Override
    public void setImmovableObjects() {
        super.immovableObjects = new ArrayList<>();

        //Walls
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
        
        super.immovableObjects.add(new FakeChip(3,3));
        super.immovableObjects.add(new FakeChip(10,5));
        super.immovableObjects.add(new Fire(11,5));
        super.immovableObjects.add(new Water(11,6));
        super.immovableObjects.add(new Water(28, 13));
        super.immovableObjects.add(new Water(26, 13));
        super.immovableObjects.add(new Water(27, 17));
        super.immovableObjects.add(new Water(25, 17));
     
        super.immovableObjects.add(new Fire(3,4));
        
        //Level Chips
        super.immovableObjects.add(new Chip(2, 2));
        super.immovableObjects.add(new Chip(2, 3));
        super.immovableObjects.add(new Chip(2, 4));
        super.immovableObjects.add(new Chip(23, 15));
        //Portal 
        super.immovableObjects.add(new Portal(9, 2));
        
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
        super.immovableObjects.add(new Button(25, 11, ButtonType.GREEN, togglewalls));
 }

    @Override
    public void setMovableObjects() {
        super.moveableObjects = new ArrayList<>();
        super.moveableObjects.add(new Block(10,6));
        
        super.moveableObjects.add(new Ball(23, 13, Direction.UP));
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
        super.levelChipCount = 6;
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
