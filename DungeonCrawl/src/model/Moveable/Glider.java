/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Moveable;

import DungeonCrawl.DungeonCrawl;
import java.awt.Color;
import java.awt.Graphics2D;
import model.GameData;
import model.GameObject;

/**
 *
 * @author russe_000
 */
public class Glider extends Monster {
    public Glider(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(Graphics2D g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        //Draw Collision Box
        //g.setColor(Color.blue);
        //g.draw(this.getCollisionBox());
    }

    @Override
    public boolean isAlive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*      @Override
     public void collide(GameObject O){
         if(O instanceof Gamer){
             DungeonCrawl.bannerPanel.setBannerText("You colided with the Ball on Level  " + GameData.currentLevel.getLevelValue());
             GameData.levelInProgress = false;
         }
     }*/
}
