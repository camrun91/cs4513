package model.Moveable;

import controller.ImageFinder;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.Collidable;
import model.Direction;
import model.GameData;
import model.GameObject;
import model.Immoveable.Tile.Fire;
import model.Immoveable.Tile.Wall;

public class Block extends MoveableObject implements Collidable{

    public BufferedImage blockImg;

    public Block(float x, float y) {
        super(x, y);

        try {
            blockImg = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Block.png");
        } catch (Exception e) {
        }

    }

    @Override
    public void render(Graphics2D g) {
        if (this.isAlive()) {
            g.drawImage(blockImg, (int) super.x, (int) super.y, (int) WIDTH, (int) HEIGHT, null);    
        }
    }

    @Override
    public void update() {
        super.update();
        
        if(isSliding()){
            slide(moving);
        }
    }

    @Override
    public void collide(GameObject O) {
        if (O instanceof Gamer) {
            float tempX = x + ((Gamer) O).x - ((Gamer) O).dx;
            float tempY = y + ((Gamer) O).y - ((Gamer) O).dy;
            if (isMovable(tempX / MOVEMENT, tempY / MOVEMENT)) {
                if(((Gamer) O).x - ((Gamer) O).dx > 0){
                    moving = Direction.RIGHT;
                }
                else if(((Gamer) O).x - ((Gamer) O).dx < 0){
                    moving = Direction.LEFT;
                }
                if(((Gamer) O).y - ((Gamer) O).dy > 0){
                    moving = Direction.DOWN;
                }
                else if(((Gamer) O).y - ((Gamer) O).dy < 0){
                    moving = Direction.UP;
                }
                x = tempX;
                y = tempY;
            } 
            else {
                ((Gamer) O).noMove();
            }
        }
        else if(O instanceof MoveableObject){
            ((MoveableObject) O).noMove();
            //Collide with Ball
            if (O instanceof Ball) {
                ((Ball) O).turnAround();
            }
            //Collide with Fireball
            if (O instanceof Fireball) {
                ((Fireball) O).turn(((Fireball) O).direction.turnCCW());
            }
        }
    }

    private boolean isMovable(float x, float y) {
        Block temp = new Block(x, y);
        return GameData.gameObjects.stream().filter((o) -> (o instanceof Wall 
                || o instanceof Block 
                || o instanceof Monster 
                || o instanceof Fire 
                        && o != this))
                .noneMatch((o) -> (
                        temp.getCollisionBox().intersects(
                                o.getCollisionBox())));
    }
}
