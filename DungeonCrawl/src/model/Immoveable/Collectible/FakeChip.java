package model.Immoveable.Collectible;

import controller.ImageFinder;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.Collidable;
import model.GameData;
import model.GameObject;
import model.Moveable.Ball;
import model.Moveable.Bug;
import model.Moveable.Fireball;
import model.Moveable.Gamer;
import model.Moveable.Glider;
import model.Moveable.MoveableObject;
import model.Moveable.Walker;

public class FakeChip extends Collectible implements Collidable{
    public BufferedImage fakechip;
    
    public FakeChip(float x, float y) {
        super(x, y);
        
        try {
            fakechip = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Fire.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(fakechip, (int) super.x, (int) super.y, (int) super.WIDTH, (int) super.HEIGHT, null);
    }

    @Override
    public void collide(GameObject O) {
        if(O instanceof Gamer){
            fakechip = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Chip.png");
            GameData.gamer.noMove();
            this.setAlive(false);                                
            GameData.collectChip();                                           
        }           
        else if (O instanceof MoveableObject) {
            ((MoveableObject) O).noMove();
            //Collide with Ball
            if (O instanceof Ball) {
                ((Ball) O).turnAround();
            }
            //Collide with Fireball
            if (O instanceof Fireball) {               
                ((Fireball) O).turn(((Fireball) O).direction.getOppositeDirection());
            }
            //Collision with Bug
            if(O instanceof Bug){                
                ((Bug) O).turn(((Bug) O).direction.getOppositeDirection());
            }
            if (O instanceof Walker) {
                ((Walker) O).turnAround();
            }
            if (O instanceof Glider) {
                ((Glider) O).turn(((Glider) O).direction.getOppositeDirection());
            }
        }
    }
}
