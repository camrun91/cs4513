/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DungeonCrawl.DungeonCrawl;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.GameObject;
import model.Moveable.Gamer;

/**
 *
 * @author russe_000
 */
public class KeyController implements KeyListener  {

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        GameObject firstGameObject = DungeonCrawl.gameData.gamer;
        
        if(firstGameObject instanceof Gamer)
        {
            Gamer gamer = (Gamer)firstGameObject;

            switch (ke.getKeyCode()) 
            {
                case KeyEvent.VK_LEFT:
                    gamer.setLeft(true);
                    break;
                case KeyEvent.VK_RIGHT:
                    gamer.setRight(true);
                    break;
                case KeyEvent.VK_UP:
                    gamer.setUp(true);
                    break;
                case KeyEvent.VK_DOWN:
                    gamer.setDown(true);
                    break;

                case KeyEvent.VK_SPACE:
                    if(!DungeonCrawl.thread.isAlive())
                        DungeonCrawl.bannerPanel.setVisible(false);
                    DungeonCrawl.startGame();

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        Object firstGameObject = DungeonCrawl.gameData.gamer;
        
        if(firstGameObject instanceof Gamer)
        {
            Gamer gamer = (Gamer)firstGameObject;
            switch (ke.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    gamer.setLeft(false);
                    break;
                case KeyEvent.VK_RIGHT:
                    gamer.setRight(false);
                    break;
                case KeyEvent.VK_DOWN:
                    gamer.setDown(false);
                    break;
                case KeyEvent.VK_UP:
                    gamer.setUp(false);
                    break;
            }
        }
    }
    
}
