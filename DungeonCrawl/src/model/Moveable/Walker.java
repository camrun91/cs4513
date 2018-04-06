package model.Moveable;

import model.Direction;
import java.awt.Graphics2D;
import controller.ImageFinder;
import controller.ObjectAnimator;
import java.awt.image.BufferedImage;
import model.GameObject;
import model.Immoveable.Tile.FakeWall;
import model.Immoveable.Tile.Fire;
import model.Immoveable.Tile.Water;
import model.Immoveable.Tile.Wall;

public class Walker extends Monster {
    
    public BufferedImage[] walker_NS;
    public BufferedImage[] walker_WE;
    int counter = 0;
    
    private final ObjectAnimator walkerMoves;
    
    public Walker(float x, float y, Direction d) {
        super(x, y);
        walkerMoves = new ObjectAnimator();
        super.direction = d;
        moving = direction;
        
        walker_NS = new BufferedImage[1];
        walker_WE = new BufferedImage[1];
        
        try {
            BufferedImage image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Walker_NS.png");
            walker_NS[0] = image;
            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Walker_WE.png");
            walker_WE[0] = image;
        } catch (Exception e) {
        }
    }

    public void turnAround() {
        direction = direction.getOppositeDirection();
        moving = direction;
    }
            
    public void changeDirection() {
        direction = direction.walkerMovement();
        moving = direction;
    }
    
    @Override
    public void render(Graphics2D g) {
        g.drawImage(walkerMoves.getImage(), (int) super.x, (int) super.y, (int) HEIGHT, (int) WIDTH,
                null);
    }

    @Override
    public void update() {
        super.update();
        
        if(isSliding()){
            slide(moving);
        } else {
            if (counter == 1000) {
                counter = 0;
                switch (direction) {
                    case LEFT:
                        walkerMoves.setFrames(walker_WE);
                        super.x -= MOVEMENT;
                        break;
                    case RIGHT:
                        walkerMoves.setFrames(walker_WE);
                        super.x += MOVEMENT;
                        break;
                    case UP:
                        walkerMoves.setFrames(walker_NS);
                        super.y -= MOVEMENT;
                        break;
                    case DOWN:
                        walkerMoves.setFrames(walker_NS);
                        super.y += MOVEMENT;
                        break;                        
                }
                moving = direction;
            } else {
                counter += 100;
            }
        }
        
        switch (moving) {
            case LEFT:
                walkerMoves.setFrames(walker_WE);
                break;
            case RIGHT:
                walkerMoves.setFrames(walker_WE);
                break;
            case UP:
                walkerMoves.setFrames(walker_NS);
                break;
            case DOWN:
                walkerMoves.setFrames(walker_NS);
                break;
        }
        walkerMoves.update();
    }
    
    @Override
     public void collide(GameObject O){
         super.collide(O);
         
         if (O instanceof Water || O instanceof Fire) {
            direction = direction.getOppositeDirection();
        }
         if(O instanceof Wall || O instanceof FakeWall){
            this.noMove();
            this.changeDirection();
        }
    }
}
