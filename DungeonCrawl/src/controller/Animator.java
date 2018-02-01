/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DungeonCrawl.DungeonCrawl;

/**
 *
 * @author russe_000
 */
public class Animator implements Runnable {
    public boolean running;
    private final int FRAMES_PER_SECOND = 15;

    @Override
    public void run() 
    {
        running = true;
        
        while (running) 
        {
            long startTime = System.currentTimeMillis();
            
            DungeonCrawl.gameData.update();
            DungeonCrawl.gamePanel.gameRender();
            DungeonCrawl.gamePanel.printScreen();
            
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
}
