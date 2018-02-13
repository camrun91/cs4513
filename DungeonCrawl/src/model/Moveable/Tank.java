/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.Moveable;


/**
 *
 * @author russe_000
 */

package model.Moveable;

import java.awt.Color;
import model.GameData;
import java.awt.Graphics2D;
import controller.ImageFinder;
import controller.ObjectAnimator;
import java.awt.image.BufferedImage;

public class Tank extends Monster{
        
    public BufferedImage[] tank_S;
    public BufferedImage[] tank_N;
    public BufferedImage[] tank_W;
    public BufferedImage[] tank_E;
    
    int counter = 0;
    
    public int facing = 2; //0 = North, 1 = East, 2 = South, 3 = West,
    public boolean right, up, left = false; 
    public boolean down = true; 
    
    private final ObjectAnimator tankMoves;
    
    public Tank(float x, float y) {
        super(x, y);        
        tankMoves = new ObjectAnimator();
        
        tank_S = new BufferedImage[1];
        tank_N = new BufferedImage[1];
        tank_W = new BufferedImage[1];
        tank_E = new BufferedImage[1];
        
        try {
            BufferedImage image = (BufferedImage)ImageFinder.getImage("ImagesFolder", "Tank_S.png");           
            tank_S[0] = image; 
            image = (BufferedImage)ImageFinder.getImage("ImagesFolder", "Tank_N.png");           
            tank_N[0] = image; 
            image = (BufferedImage)ImageFinder.getImage("ImagesFolder", "Tank_W.png");           
            tank_W[0] = image; 
            image = (BufferedImage)ImageFinder.getImage("ImagesFolder", "Tank_E.png");           
            tank_E[0] = image; 
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(tankMoves.getImage(), (int)super.x, (int)super.y, (int)super.height, (int)super.width, 
            null);
        //Draw Collision Box
        g.setColor(Color.blue);
        g.draw(this.getCollisionBox());
    }
    
    @Override
    public void update() {
        if (GameData.time > 0) {     
            if (down) {
                tankMoves.setFrames(tank_S);
                if (counter == 1000) {
                    counter = 0;
                    for (int i = 0; i < 1; i++) {                        
                        super.y += super.MOVEMENT;
                        //tankMoves.setFrames(tank_S);
                    }
                    if (super.y >= 500) {
                        facing = 2;
                        tankMoves.setFrames(tank_S);
                        left = false; 
                        right = true; 
                        up = false; 
                        down = false; 
                    }                    
                    tankMoves.setFrames(tank_S);
                }
                else {
                    counter += 100;
                }
                
            }
            else if (right) {  
                tankMoves.setFrames(tank_E);
                if (counter == 1000) {
                    counter = 0;
                    
                    for (int i = 0; i < 1; i++) {                        
                        super.x += super.MOVEMENT;
                        //tankMoves.setFrames(tank_E);
                    }                    
                    if (super.x >= 800) {
                        facing = 1;
                        left = false; 
                        right = false; 
                        up = true; 
                        down = false; 
                    }
                    tankMoves.setFrames(tank_E);
                } else {
                    counter += 100;
                }
            }
            else if (up) {
                tankMoves.setFrames(tank_N);
                if (counter >= 1000) {
                    counter = 0;
                    
                    for (int i = 0; i < 1; i++) {                        
                        super.y -= super.MOVEMENT;
                        //tankMoves.setFrames(tank_N);
                    }
                    if (super.y <= 300) {
                        facing = 0;
                        left = true; 
                        right = false; 
                        up = false; 
                        down = false; 
                    }
                    tankMoves.setFrames(tank_N);
                } else {
                    counter += 100;
                }
            }
            else if (left) {
                tankMoves.setFrames(tank_W);
                if (counter == 1000) {
                    counter = 0;
                    
                    for (int i = 0; i < 1; i++) {                        
                        super.x -= super.MOVEMENT;
                        //tankMoves.setFrames(tank_W);
                    }
                    
                    if (super.x >= 700) {
                        facing = 3;
                        left = false; 
                        right = false; 
                        up = false; 
                        down = true; 
                    } 
                    tankMoves.setFrames(tank_W);
                } else {
                    counter += 100;
                }
            }tankMoves.update();
        }
        
    }
}