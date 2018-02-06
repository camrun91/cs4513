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

/**
 *
 * @author russe_000
 */
public class GameData {
    public static List<GameObject> gameObjects;
    public static Gamer gamer;
    public static String level;
    public static int time;
    public static String chipsLeft;
    //public static Landscape landscape;

    public GameData() 
    {
        gameObjects = Collections.synchronizedList(new ArrayList<GameObject>());
        
        // Level specific items
        gamer = new Gamer(650, 625);
        GameData.gameObjects.add(GameData.gamer);
        GameData.level = "1";
        GameData.time = 120000;
        GameData.chipsLeft = "10";
    }
    
    public void resetGameData()
    {
        GameData.gamer = new Gamer(650, 625);
        GameData.gamer.update();
        
//        if(landscape.getLevel() instanceof YouWinLevel)
//        {
//            hero.hearts += 6;
//            
//            Main.metricPanel.updateHeartsAndArrows();
//        }
//        
//        landscape.setLevel(landscape.getLevel());
    }
    
    public void update() 
    {
        if(GameData.time > 0)
        {
            GameData.time -= 1000;
        }
        
        synchronized(gameObjects)
        {
            for(GameObject object: gameObjects)
            {
                if(object instanceof Monster)
                {
                    ((Monster)object).update();
                    
                    // ((Monster)object).findCollision();
                }
                else if(object instanceof Gamer){
                    ((Gamer)object).update();
                }
            }
        }
    }
}
