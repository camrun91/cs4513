package model.Immoveable.Tile;

import controller.ImageFinder;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.Collidable;
import model.GameObject;
import model.Moveable.Ball;
import model.Moveable.MoveableObject;
public class ToggleWall extends Wall implements Collidable{
    
    BufferedImage toggleWallImg;
    
    private boolean open;
    
    public ToggleWall(float x, float y, boolean open){
        super(x, y);
        super.setAlive(true);
        this.open = open;
        
        loadImages();
    }
    
    public boolean isOpen(){
        return open;
    }
    
    public void setOpen(boolean open){
        this.open = open;
    }
    
    public void loadImages(){
        try
        {            
            if(open){
                BufferedImage image = (BufferedImage)ImageFinder.getImage("ImagesFolder", "Toggle_Wall_Open.png");
                toggleWallImg = image;
            }
            else{
                BufferedImage image = (BufferedImage)ImageFinder.getImage("ImagesFolder", "Toggle_Wall_Closed.png");
                toggleWallImg = image;
            }
        } 
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void render(Graphics2D g) {
        loadImages();
        
        g.drawImage(toggleWallImg, (int)super.x, (int)super.y, (int)super.WIDTH, (int)super.HEIGHT, null);
    }

    @Override
    public void collide(GameObject O) {
        if(!open){
            ((MoveableObject)O).noMove();
            if(O instanceof Ball){
                ((Ball)O).turnAround();
            }
        }
        else{
            O.update();
        }
    }
}
