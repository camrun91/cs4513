/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
package model.Moveable;

import java.awt.Graphics;
import model.GameObject;

public abstract class MoveableObject implements GameObject {
    public float x, y;
    private boolean alive;
    
    public MoveableObject(float x, float y){
        this.x = x;
        this.y = y;
        this.alive = true;
    }
    
    @Override
    public abstract void render(Graphics g);
    
    public void setAlive(boolean alive){
        this.alive = alive;
    }
    
    public boolean isAlive(){
        return alive;
    }
    
    public abstract void update();
    
    public abstract void findCollision();
}
