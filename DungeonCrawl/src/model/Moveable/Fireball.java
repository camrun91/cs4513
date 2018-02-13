/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Moveable;


import static DungeonCrawl.DungeonCrawl.gameData;
import controller.ImageFinder;
import controller.ObjectAnimator;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


/**
 *
 * @author russe_000
 */
public class Fireball extends Monster {
    
    private int counter = 0;
    
    public BufferedImage[] fireballSprites;
    
    public boolean turnRight, turnUp, turnDown = false; 
    public boolean turnLeft = true; 
    
    private final ObjectAnimator fireballMoves;
    
    public Fireball(float x, float y) {
        super(x, y);
        fireballMoves = new ObjectAnimator();
        
        fireballSprites = new BufferedImage[1];
        try{
            BufferedImage image = (BufferedImage)ImageFinder.getImage("ImagesFolder", "Fireball.png");           
            fireballSprites[0] = image;                       
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void render(Graphics2D g) {
        g.drawImage(fireballMoves.getImage(), (int)super.x, (int)super.y, (int)super.width, (int)super.height, 
            null);
        
        //Draw Collision Box
        g.setColor(Color.blue);
        g.draw(this.getCollisionBox());
    }
       
    @Override
    public void update() {
            fireballMoves.setFrames(fireballSprites);             
            if (turnLeft){
                if (gameData.time >0){
                    if (counter == 1000){
                        counter = 0; 
                        for(int i = 0; i < 1; i++){
                            super.x -= super.MOVEMENT; 
                        }
                        if (super.x <= 200) {
                        fireballMoves.setFrames(fireballSprites);
                        turnLeft = false; 
                        turnRight = false; 
                        turnUp = false; 
                        turnDown = true;
                        }
                    }
                    else{
                        counter += 100; 
                    }
                } 
            } 
            else if(turnDown)
            {
                if(gameData.time > 0){
                    if(counter == 1000){
                        counter = 0; 
                        for(int i = 0; i < 1; i++){
                            super.y += super.MOVEMENT;
                        }
                        if (super.y >= 500) {
                        fireballMoves.setFrames(fireballSprites);
                        turnLeft = false; 
                        turnRight = true; 
                        turnUp = false; 
                        turnDown = false;
                        }
                    }
                    else{
                        counter += 100;                         
                    }
                }   
            }
            else if(turnRight)
            {
                if(gameData.time > 0){                    
                    if(counter == 1000){
                        counter = 0; 
                        for(int i = 0; i < 1; i++){
                            super.x += super.MOVEMENT;                            
                        }
                        if (super.x >= 350) {
                        fireballMoves.setFrames(fireballSprites);
                        turnLeft = false; 
                        turnRight = false; 
                        turnUp = true; 
                        turnDown = false;
                        }
                    }
                    else{
                        counter += 100; 
                    }
                }                    
            } 
            else if(turnUp)
            {
                if(gameData.time > 0){                    
                    if(counter == 1000){
                        counter = 0; 
                        for(int i = 0; i < 1; i++){
                            super.y -= super.MOVEMENT;                      
                        }
                        if (super.y <= 350) {
                        fireballMoves.setFrames(fireballSprites);
                        turnLeft = true; 
                        turnRight = false; 
                        turnUp = false; 
                        turnDown = false;
                        }
                    }
                    else{
                        counter += 100; 
                    }
                }                
            }           
        fireballMoves.update();             
    }
}
