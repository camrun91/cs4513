package model.Immoveable.Tile;

import controller.ImageFinder;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.Collidable;
import model.GameObject;
import model.Moveable.Ball;
import model.Moveable.Block;
import model.Moveable.Bug;
import model.Moveable.Fireball;
import model.Moveable.Gamer;
import model.Moveable.Tank;
import model.Moveable.Walker;

public class Dirt extends Tile implements Collidable {

    public BufferedImage image;

    public Dirt(float x, float y) {
        super(x, y);
        try {
            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Dirt.png");
        } catch (Exception e) {
            System.out.println("Error in Dirt" + e.getMessage());
        }
    }

    @Override
    public void collide(GameObject O) {
        if (O instanceof Gamer) {
            this.setAlive(false);
        }
        //Collide with Block
        if (O instanceof Block) {
          
            ((Block) O).noMove();
        }
        //Collide with Ball
        if (O instanceof Ball) {
            ((Ball) O).noMove();
            ((Ball) O).turnAround();
        }
        //Collide with Fireball
        if (O instanceof Fireball) {
            ((Fireball) O).noMove();
            ((Fireball) O).turn(((Fireball) O).direction.turnCW());
        }
        //Collision with Bug
        if (O instanceof Bug) {
            ((Bug) O).noMove();
            ((Bug) O).turn(((Bug) O).direction.getOppositeDirection());
        }
        if (O instanceof Tank) {
            ((Tank) O).noMove();
            ((Tank) O).direction = ((Tank) O).direction.turnCW();


        }
        if (O instanceof Walker) {
            ((Walker) O).noMove();
            ((Walker) O).changeDirection();


            
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(image, (int) super.x, (int) super.y, (int) super.WIDTH, (int) super.HEIGHT, null);
    }

}
