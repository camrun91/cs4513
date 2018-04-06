package model.Immoveable.Collectible;

import model.LockType;
import controller.ImageFinder;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.Collidable;
import model.GameData;
import model.GameObject;
import model.Moveable.Gamer;

public class Key extends Collectible implements Collidable {
    public LockType type;    
    public BufferedImage[] keyImg;
    
    public Key(float x, float y, LockType k) {
        super(x, y);    
        this.type = k;
        
        keyImg = new BufferedImage[4];
        
        try{
            BufferedImage image = (BufferedImage)ImageFinder.getImage("ImagesFolder", "Blue_Key.png");
            keyImg[0] = image;
            
            image = (BufferedImage)ImageFinder.getImage("ImagesFolder", "Green_Key.png");
            keyImg[1] = image;
            
            image = (BufferedImage)ImageFinder.getImage("ImagesFolder", "Red_Key.png");
            keyImg[2] = image;
            
            image = (BufferedImage)ImageFinder.getImage("ImagesFolder", "Yellow_Key.png");
            keyImg[3] = image;
        } catch(Exception e){
            e.printStackTrace();
        }
    };

    @Override
    public void render(Graphics2D g) {
        if(this.isAlive() && this.isDisplayed){
            BufferedImage image;
            switch(type){
                case BLUE:
                    image = keyImg[0];
                    break;
                case GREEN:
                    image = keyImg[1];
                    break;
                case RED:
                    image = keyImg[2];
                    break;
                default:
                    image = keyImg[3];
            }
            g.drawImage(image, (int)super.x, (int)super.y, (int)super.WIDTH, (int)super.HEIGHT, null);
            }
    };

    @Override
     public void collide(GameObject O){
         if(O instanceof Gamer){
            GameData.gamerInventory.add(this);
            this.isDisplayed = false;
        }
    }
}
