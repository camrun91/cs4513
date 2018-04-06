package model.Immoveable.Tile;

import DungeonCrawl.DungeonCrawl;
import controller.ImageFinder;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.BootType;
import model.Collidable;
import model.GameData;
import model.GameObject;
import model.Immoveable.Collectible.Boot;
import model.Moveable.Ball;
import model.Moveable.Bug;
import model.Moveable.Fireball;
import model.Moveable.Gamer;
import model.Moveable.Glider;
import model.Moveable.Walker;
import model.Moveable.MoveableObject;

public class Fire extends Tile implements Collidable {

    public BufferedImage image;

    public Fire(float x, float y) {
        super(x, y);

        try {
            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Fire.png");
        } catch (Exception e) {
        }
    }

    @Override
    public void collide(GameObject O) {
        if (O instanceof Gamer) {
            //Check for boot
            boolean gameOver = true;
            for (Object item : GameData.gamerInventory) {
                if (item instanceof Boot) {
                    if (((Boot) item).type == BootType.FIRE) {
                        gameOver = false;
                    }
                }
            }
            //Trigger Game End
            if (gameOver) {
                image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Chip_In_Fire.png");
                //TODO Remove the Gamer so That you can see the burned image. JL 2/19
                DungeonCrawl.bannerPanel.setBannerText("You burned on Level  " + GameData.currentLevel.getLevelValue());
                ((Gamer) O).setAlive(false);
            }
        } else if (O instanceof MoveableObject) {
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

    @Override
    public void render(Graphics2D g) {
        g.drawImage(image, (int) super.x, (int) super.y, (int) super.WIDTH, (int) super.HEIGHT, null);
    }

}
