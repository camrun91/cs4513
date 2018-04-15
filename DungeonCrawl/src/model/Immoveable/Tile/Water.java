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
import model.Moveable.Block;
import model.Moveable.Bug;
import model.Moveable.Fireball;
import model.Moveable.Gamer;
import model.Moveable.Tank;
import model.Moveable.Walker;

public class Water extends Tile implements Collidable{

    public BufferedImage image;

    public Water(float x, float y) {
        super(x, y);

        try {
            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Water.png");
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
                    if (((Boot) item).type == BootType.WATER) {
                        gameOver = false;
                        break;
                    }
                }
            }
            //Trigger Game End
            if (gameOver) {
                image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Chip_Drowned.png");
                //TODO Remove the Gamer so That you can see the drowned image. JL 2/19
                DungeonCrawl.bannerPanel.setBannerText("You drowned on Level  " + GameData.currentLevel.getLevelValue());
                ((Gamer)O).setAlive(false);
            }

        }
        //Collide with Block
        if(O instanceof Block)
        {   this.setAlive(false);
            GameData.spawn(new Dirt(this.x/OFFSET,this.y/OFFSET));
            ((Block)O).setAlive(false);
            
        }
        //Collide with Ball
        if(O instanceof Ball){
            ((Ball) O).noMove();
            ((Ball) O).turnAround();
        }
        //Collide with Fireball
        if(O instanceof Fireball){
            ((Fireball) O).setAlive(false);
        }
        //Collision with Bug
        if(O instanceof Bug){
            ((Bug) O).noMove();
            ((Bug) O).turn(((Bug) O).direction.getOppositeDirection());
        }
        if(O instanceof Tank) {
            ((Tank) O).noMove();
            ((Tank) O).setAlive(false);
            
            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Chip_Drowned.png");
            //how do I chage it back to normal water image after 1~2 sec.
        }
        if(O instanceof Walker) {
            ((Walker) O).noMove();
            ((Walker) O).setAlive(false);
            
            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Chip_Drowned.png");
            //how do I chage it back to normal water image after 1~2 sec.
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(image, (int) super.x, (int) super.y, (int) super.WIDTH, (int) super.HEIGHT, null);
    }
}
