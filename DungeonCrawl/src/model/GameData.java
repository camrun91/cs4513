/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import model.Moveable.Gamer;
import model.Moveable.Monster;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Immoveable.Tile.Wall;
import model.Moveable.Ball;
import model.Moveable.Fireball;
import model.Moveable.Tank;
import model.Immoveable.Collectible.Boot;
import model.Immoveable.Collectible.Chip;
import model.Immoveable.Collectible.Key;
import model.Immoveable.Tile.Lock;


/**
 *
 * @author russe_000
 */
public class GameData {
    public static List<GameObject> gameObjects;
    public static List<GameObject> gamerInventory;
    public static Gamer gamer;
    public static Key redKey, yellowKey;
    public static Lock blueLock, yellowLock, socket;
    public static Boot fireBoot, iceBoot;
    public static int level;
    public static Fireball fireball;
    public static Tank tank;
    public static Ball ball;
    public static Wall wall;
    public static int time;
    public static int chipsLeft;
    private int timerCounter;


    public GameData() 
    {
        gameObjects = Collections.synchronizedList(new ArrayList<GameObject>());
        gamerInventory = Collections.synchronizedList(new ArrayList<GameObject>());
        
        // Level specific items

        gamer = new Gamer(2, 1);
        fireball = new Fireball (354,321); 
        tank = new Tank (706, 321);
        ball = new Ball(642,289);
        GameData.gameObjects.add(GameData.fireball); 
        GameData.gameObjects.add(GameData.tank); 
        GameData.gameObjects.add(this.ball);
        
        
        GameData.level = 1;
        GameData.time = 120;
        GameData.chipsLeft = 3;
        timerCounter = 0;
        
        //Level keys
        redKey = new Key(610, 97, LockType.RED);
        yellowKey = new Key(642, 97, LockType.YELLOW);
        gameObjects.add(redKey);
        gameObjects.add(yellowKey);
        
        //Level locks
        blueLock = new Lock(98, 97, LockType.BLUE);
        yellowLock = new Lock(98, 129, LockType.YELLOW);
        socket = new Lock(98, 161, LockType.SOCKET);
        gameObjects.add(blueLock);
        gameObjects.add(yellowLock);
        gameObjects.add(socket);
        
        //Level boots
        fireBoot = new Boot(898, 97, BootType.FIRE);
        iceBoot = new Boot(898, 129, BootType.ICE);
        gameObjects.add(fireBoot);
        gameObjects.add(iceBoot);
        
        //Level chips
        gameObjects.add(new Chip(354, 97));
        gameObjects.add(new Chip(322, 97));
        gameObjects.add(new Chip(322, 129));

    }
    
    public void resetGameData()
    {
        GameData.gamer = new Gamer(2, 1);
        GameData.gamer.update();
    }
    
    public void collectChip(){
        --chipsLeft;
    }
    
    public void update() 
    {
        if(GameData.time > 0)
        {
            GameData.time -= 1000;
        }
        
        gamer.update();
        
        synchronized(gameObjects)
        {
            for(GameObject object: gameObjects)
            {
                if(object instanceof Monster)
                {
                    ((Monster)object).update();
                    
                    // ((Monster)object).findCollision();
                }
            }
        }
        
        ArrayList<GameObject> removeInventory = new ArrayList<>();
        synchronized(gamerInventory){
            for(GameObject object : gamerInventory){
                if(!object.isAlive()){
                    removeInventory.add(object);
                }             
            }
        }
        gamerInventory.removeAll(removeInventory);
                       
    }
}
