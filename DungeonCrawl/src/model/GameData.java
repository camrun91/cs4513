 package model;

import model.Moveable.Gamer;
import model.Moveable.Monster;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import model.Immoveable.Tile.FakePortal;

public class GameData {

    public static final int MAP_WIDTH = 30;
    public static final int MAP_HEIGHT = 27;
    public static List<GameObject> gameObjects;
    public static List<GameObject> gamerInventory;
    public static ArrayList<GameObject> spawnObjects = new ArrayList<>();

    public static Map<LevelNumber, Level> gameLevels;
    public static Level currentLevel;
    public static int time;
    public static Gamer gamer;
    public static Monster monster;
    public static int chipsLeft;
    private static long currentTime, previousTime;
    public static boolean levelInProgress = false;
    public static boolean paused = false;
    

    public GameData() {
        gameObjects = Collections.synchronizedList(new ArrayList<>());
        gamerInventory = Collections.synchronizedList(new ArrayList<>());

        // List of Levels
        gameLevels = new HashMap();
        gameLevels.put(LevelNumber.LEVELONE, new LevelOne());
        gameLevels.put(LevelNumber.LEVELTWO, new LevelTwo());
        gameLevels.put(LevelNumber.LEVELTHREE, new LevelThree());
        
        currentLevel = gameLevels.get(LevelNumber.LEVELONE);

        resetGameData();
    }

    public static long getTime() {
        return currentTime;
    }

    public static void resetGameData() {
        time = currentLevel.getLevelTime();
        currentTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        previousTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        currentLevel.resetLevel();
        chipsLeft = currentLevel.getLevelChipCount();

        //Clear out game objects
        gameObjects.clear();
        gamerInventory.clear();

        //Moveable Objects
        gameObjects.addAll(currentLevel.getImmovableObjects());

        //Immoveable Objects
        gameObjects.addAll(currentLevel.getMoveableObjects());

        gamer = currentLevel.getGamer();
        gameObjects.add(gamer);

        levelInProgress = true;
    }

    public static void collectChip() {
        --chipsLeft;
    }

    public void update() {
        if (!GameData.paused) {
            if (GameData.time > 0) {
                currentTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());

                if (currentTime > previousTime) {
                    previousTime = currentTime;
                    GameData.time--;
                }
            }
            
            gameObjects.addAll(spawnObjects);
            spawnObjects.clear(); 

            synchronized (gameObjects) {
                for (GameObject object : gameObjects) {
                    object.update();
                }
            }

            ArrayList<GameObject> removeInventory = new ArrayList<>();
            synchronized (gamerInventory) {
                for (GameObject object : gamerInventory) {
                    if (!object.isAlive()) {
                        removeInventory.add(object);
                    }
                }
            }
            gamerInventory.removeAll(removeInventory);

            ArrayList<GameObject> removeKilledObjects = new ArrayList<>();
            synchronized (gameObjects) {
                for (GameObject object : GameData.gameObjects) {
                    if (!object.isAlive()) {
                        removeKilledObjects.add(object);
                    }
                }
            }
            GameData.gameObjects.removeAll(removeKilledObjects);

            if (!gamer.isAlive()) {
                levelInProgress = false;
            }
        }
    }

    public static void goToNextLevel() {
        levelInProgress = false;

        //Logic for next level
        if (currentLevel == gameLevels.get(LevelNumber.LEVELONE)) {
            currentLevel = gameLevels.get(LevelNumber.LEVELTWO);
        } else {
            currentLevel = gameLevels.get(LevelNumber.LEVELTHREE);
        }
    }

    public static void goToPreviousLevel() {
        levelInProgress = false;

        //Logic for next level
        if (FakePortal.goBack == true) {
            if (FakePortal.levelChange == 1) {
                currentLevel = gameLevels.get(LevelNumber.LEVELONE);
                FakePortal.goBack = false;
            } else {
                currentLevel = gameLevels.get(LevelNumber.LEVELTWO);
                FakePortal.goBack = false;
            }
        }
    }

    public static void spawn(GameObject monster) {
        spawnObjects.add(monster);
    }
}