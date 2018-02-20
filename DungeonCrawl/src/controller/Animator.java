/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DungeonCrawl.DungeonCrawl;
import java.util.ArrayList;
import model.GameData;
import static model.GameData.gamerInventory;
import model.GameObject;
import model.Immoveable.Tile.Button;


/**
 *
 * @author russe_000
 */
public class Animator implements Runnable {

    public boolean running;
    private final int FRAMES_PER_SECOND = 15;

    @Override
    public void run() {
        running = true;

        while (running) {
            long startTime = System.currentTimeMillis();

            if(GameData.levelInProgress){
                DungeonCrawl.gameData.update();
                processCollisions();
                DungeonCrawl.gamePanel.gameRender();
                DungeonCrawl.gamePanel.printScreen();
                DungeonCrawl.inventoryPanel.updateInventoryPanel();
            }
            else{
                DungeonCrawl.bannerPanel.setVisible(true);
                DungeonCrawl.gamePanel.requestFocus();
            }

            long endTime = System.currentTimeMillis();
            int sleepTime = (int) (1.0 / FRAMES_PER_SECOND * 1000)
                    - (int) (endTime - startTime);

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime); // ms
                } catch (InterruptedException e) {

                }
            }
        }
    }

    private void processCollisions() {
        for (GameObject object : GameData.gameObjects) {
            // If there is a collision between the gamer and a game object
            if (GameData.gamer.getCollisionBox().intersects(
                    object.getCollisionBox())) {
                //GameData.gamer.collide(object);
                object.collide(GameData.gamer);
            }
            else{ 
                if(object instanceof Button){
                    ((Button) object).pressed = false;
                }
                }
            for(GameObject go: GameData.gameObjects){
                if(object != go && object.getCollisionBox().intersects(
                        go.getCollisionBox())){
                    object.collide(go);
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
