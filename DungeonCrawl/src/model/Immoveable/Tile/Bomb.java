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
import model.Moveable.Block;
import model.Moveable.Gamer;
import model.Moveable.Monster;

public class Bomb extends Tile implements Collidable {

    public BufferedImage image;
    int counter = 0;

    public Bomb(float x, float y) {
        super(x, y);

        try {
            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Bomb.png");
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
                image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "explosion.gif");
                //TODO Remove the Gamer so That you can see the drowned image. JL 2/19
                DungeonCrawl.bannerPanel.setBannerText("¯\\_(ツ)_/¯  " + GameData.currentLevel.getLevelValue());
                ((Gamer)O).setAlive(false);
            }

        }
        //Collide with Block
        if(O instanceof Block)
        {
            this.setAlive(false);
            ((Block)O).setAlive(false);
        }
        //Collide with Monster
        if(O instanceof Monster){
            ((Monster) O).setAlive(false);
            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "explosion.gif");
            //how do I remove the explosion image from the screen after 1~2 sec.
            
            if (counter == 10000) {
                counter = 0;
                this.setAlive(false);
            }
            
        }

    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(image, (int) super.x, (int) super.y, (int) super.WIDTH, (int) super.HEIGHT, null);
    }

}
