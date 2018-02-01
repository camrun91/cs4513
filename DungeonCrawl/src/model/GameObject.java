/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author russe_000
 */
public interface GameObject {
    public abstract void render(Graphics g);
    
    public Rectangle2D.Double getCollisionBox();
    
    public abstract boolean isAlive();
}
