package model;

import java.util.ArrayList;
import static model.GameData.MAP_HEIGHT;
import static model.GameData.MAP_WIDTH;
import model.Immoveable.Collectible.Boot;
import model.Immoveable.Collectible.Chip;
import model.Immoveable.Collectible.Key;
import model.Immoveable.Tile.Bomb;
import model.Immoveable.Tile.Button;
import model.Immoveable.Tile.FakePortal;
import model.Immoveable.Tile.FakeWall;
import model.Immoveable.Tile.Force;
import model.Immoveable.Tile.Ice;
import model.Immoveable.Tile.Lock;
import model.Immoveable.Tile.Portal;
import model.Immoveable.Tile.Wall;
import model.Immoveable.Tile.Water;
import model.Immoveable.Tile.Trap;
import model.Moveable.Ball;
import model.Moveable.Fireball;
import model.Moveable.Frog;
import model.Moveable.Gamer;

public final class LevelTwo extends Level {

    public LevelTwo() {
        resetLevel();
    }

    @Override
    public void setGamer() {
        super.gamer = new Gamer(1, 19);
    }

    @Override
    public void setImmovableObjects() {
        super.immovableObjects = new ArrayList<>();

        //Fake Walls
        super.immovableObjects.add(new FakeWall(1, 12, true, false));
        super.immovableObjects.add(new FakeWall(29, 12, false, true));
        super.immovableObjects.add(new FakeWall(1, 6, false, true));
        super.immovableObjects.add(new FakeWall(29, 6, true, false));

        for (int i = 1; i <= 4; i++) {
            super.immovableObjects.add(new FakeWall(15, i, false, true));
        }
        for (int i = 7; i <= 9; i++) {
            super.immovableObjects.add(new FakeWall(15, i, false, true));
        }
        super.immovableObjects.add(new FakeWall(15, 11, false, true));
        for (int i = 14; i <= 18; i++) {
            super.immovableObjects.add(new FakeWall(15, i, false, true));
        }

        super.immovableObjects.add(new FakeWall(15, 5, true, false));
        super.immovableObjects.add(new FakeWall(15, 10, true, false));
        super.immovableObjects.add(new FakeWall(15, 13, true, false));

        //Walls
        for (int i = 0; i <= MAP_WIDTH; ++i) {
            super.immovableObjects.add(new Wall(i, 0));
            super.immovableObjects.add(new Wall(i, MAP_HEIGHT));
        }
        for (int i = 0; i <= MAP_HEIGHT; ++i) {
            super.immovableObjects.add(new Wall(0, i));
            super.immovableObjects.add(new Wall(MAP_WIDTH, i));
        }

        for (int i = 26; i >= 20; --i) {
            super.immovableObjects.add(new Wall(8, i));
        }
        for (int i = 1; i <= 28; i++) {
            super.immovableObjects.add(new Wall(i, 18));
        }
        for (int i = 18; i <= 25; i++) {
            super.immovableObjects.add(new Wall(22, i));
        }
        for (int i = 2; i <= 28; i++) {
            super.immovableObjects.add(new Wall(i, 12));
        }

        for (int i = 2; i <= 28; i++) {
            super.immovableObjects.add(new Wall(i, 6));
        }

        for (int i = 25; i >= 21; i--) {
            super.immovableObjects.add(new Wall(2, i));
            for (int j = 23; j >= 21; j--) {
                super.immovableObjects.add(new Wall(3, j));
            }
            for (int k = 23; k >= 21; k--) {
                super.immovableObjects.add(new Wall(4, k));
            }
            for (int l = 21; l >= 21; l--) {
                super.immovableObjects.add(new Wall(5, l));
            }

        }

        for (int i = 25; i <= 28; i += 3) {
            super.immovableObjects.add(new Wall(i, 25));
            super.immovableObjects.add(new Wall(i, 26));
        }

        for (int i = 2; i <= 28; i++) {
            super.immovableObjects.add(new Wall(i, 12));
        }

        for (int i = 2; i <= 28; i++) {
            super.immovableObjects.add(new Wall(i, 6));
        }

        //Force Floors 
        super.immovableObjects.add(new Force(2, 26, Direction.RIGHT));
        for (int i = 3; i < 8; ++i) {
            super.immovableObjects.add(new Force(i, 26, Direction.UP));
            for (int j = 3; j < 8; ++j) {
                super.immovableObjects.add(new Force(j, 25, Direction.UP));
            }
            for (int k = 4; k < 8; ++k) {
                super.immovableObjects.add(new Force(k, 24, Direction.UP));
            }
            for (int l = 5; l < 8; ++l) {
                super.immovableObjects.add(new Force(l, 23, Direction.UP));
            }
            for (int m = 6; m < 8; ++m) {
                super.immovableObjects.add(new Force(m, 22, Direction.UP));
            }
            for (int n = 7; n < 8; ++n) {
                super.immovableObjects.add(new Force(n, 21, Direction.UP));
            }
        }
        super.immovableObjects.add(new Force(3, 24, Direction.RIGHT));
        super.immovableObjects.add(new Force(4, 24, Direction.RIGHT));
        super.immovableObjects.add(new Force(5, 22, Direction.RIGHT));
        super.immovableObjects.add(new Force(6, 21, Direction.RIGHT));
        for (int i = 7; i > 2; i--) {
            super.immovableObjects.add(new Force(i, 20, Direction.LEFT));
        }

        //Ice
        for (int i = 10; i < 21; i++) {
            super.immovableObjects.add(new Ice(i, 19));
            super.immovableObjects.add(new Ice(i, 26));
        }
        for (int i = 9; i < 22; i++) {
            super.immovableObjects.add(new Ice(i, 20));
            super.immovableObjects.add(new Ice(i, 21));
            super.immovableObjects.add(new Ice(i, 24));
            super.immovableObjects.add(new Ice(i, 25));
        }
        super.immovableObjects.add(new Ice(15, 26, Direction.SW));
        super.immovableObjects.add(new Ice(9, 25, Direction.SW));
        super.immovableObjects.add(new Ice(21, 25, Direction.SE));
        super.immovableObjects.add(new Ice(21, 19, Direction.NE));
        super.immovableObjects.add(new Ice(14, 26, Direction.SE));

        //Water       
        super.immovableObjects.add(new Water(24, 22));
        super.immovableObjects.add(new Water(25, 22));
        super.immovableObjects.add(new Water(27, 22));
        super.immovableObjects.add(new Water(28, 22));
        for (int i = 24; i <= 28; i++) {
            super.immovableObjects.add(new Water(i, 21));
            super.immovableObjects.add(new Water(i, 23));
        }

        //Fake Portal 
        super.immovableObjects.add(new FakePortal(26, 26, 1));

        //Portal 
        super.immovableObjects.add(new Portal(27, 26));

        //Locks
        super.immovableObjects.add(new Lock(8, 19, LockType.BLUE));
        super.immovableObjects.add(new Lock(22, 26, LockType.RED));
        super.immovableObjects.add(new Lock(29, 18, LockType.YELLOW));
        super.immovableObjects.add(new Lock(26, 25, LockType.SOCKET));
        super.immovableObjects.add(new Lock(27, 25, LockType.SOCKET));

        //Keys
        super.immovableObjects.add(new Key(1, 26, LockType.BLUE));
        super.immovableObjects.add(new Key(15, 22, LockType.RED));
        super.immovableObjects.add(new Key(26, 22, LockType.YELLOW));

        //Level Chips
        super.immovableObjects.add(new Chip(2, 20));
        super.immovableObjects.add(new Chip(14, 22));
        super.immovableObjects.add(new Chip(16, 22));

        super.immovableObjects.add(new Chip(23, 17));
        super.immovableObjects.add(new Chip(23, 13));

        super.immovableObjects.add(new Chip(8, 15));

        for (int i = 2; i <= 4; i++) {
            super.immovableObjects.add(new Chip(22, i));
            super.immovableObjects.add(new Chip(23, i));
        }

        super.immovableObjects.add(new Chip(8, 3));

        //Boots
        super.immovableObjects.add(new Boot(9, 26, BootType.WATER));

        //Bombs
        super.immovableObjects.add(new Bomb(2, 9));
        super.immovableObjects.add(new Bomb(22, 5));
        super.immovableObjects.add(new Bomb(1, 14));
        super.immovableObjects.add(new Bomb(1, 16));
    }

    @Override
    public void setMovableObjects() {
        super.moveableObjects = new ArrayList<>();

        //Ball button
        super.immovableObjects.add(new Button(29, 17, ButtonType.BROWN, new ArrayList<GameObject>()));
        //ball trap
        super.immovableObjects.add(new Trap(23, 15, (Button) super.immovableObjects.get(super.immovableObjects.size() - 1)));
        //Ball
        super.moveableObjects.add(new Ball(23, 15, Direction.UP));

        //Frog
        super.moveableObjects.add(new Frog(5, 19));
   //     super.moveableObjects.add(new Frog(13, 22));
        super.moveableObjects.add(new Frog(17, 23));

        super.moveableObjects.add(new Frog(1, 15));
        super.moveableObjects.add(new Frog(29, 1));
        super.moveableObjects.add(new Frog(8, 9));

        //Fireball
        super.moveableObjects.add(new Fireball(16, 9, Direction.DOWN));
        super.moveableObjects.add(new Fireball(23, 11, Direction.RIGHT));
        super.moveableObjects.add(new Fireball(23, 7, Direction.LEFT));
        super.moveableObjects.add(new Fireball(29, 9, Direction.UP));

    }

    @Override
    public void setLevelValue() {
        super.levelValue = 2;
    }

    @Override
    public void setLevelTime() {
        super.levelTime = 200;
    }

    @Override
    public void setLevelChipCount() {
        super.levelChipCount = 13;
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
