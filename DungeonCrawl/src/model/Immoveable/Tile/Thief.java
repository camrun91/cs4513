package model.Immoveable.Tile;

import controller.ImageFinder;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.Collidable;
import static model.GameData.gamerInventory;
import model.GameObject;

public class Thief extends Tile implements Collidable{
    
    public BufferedImage image;

    public Thief(float x, float y) {
        super(x, y);
        
        try {
            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Theif.png");
        } catch (Exception e) {
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(image, (int) super.x, (int) super.y, (int) super.WIDTH, (int) super.HEIGHT, null);
    }

    @Override
    public void collide(GameObject O) {       
        gamerInventory.clear();
    }   
}
