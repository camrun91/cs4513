
package model.Immoveable.Tile;

import DungeonCrawl.DungeonCrawl;
import controller.ImageFinder;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.Collidable;
import model.GameData;
import model.GameObject;

public class FakePortal extends Tile implements Collidable{
    
    public BufferedImage fakePortalImg;
    public static boolean goBack = false; 
    public static int levelChange; 

    public FakePortal(float x, float y, int level) {
        super(x, y);
        loadImages();
        levelChange = level; 
    }

    public void loadImages(){
        try{            
            BufferedImage image = (BufferedImage)ImageFinder.getImage("ImagesFolder", "Portal.png");
            fakePortalImg = image;
        } catch(Exception e){
            DungeonCrawl.thread.interrupt();
        }
    }
    @Override
    public void render(Graphics2D g) {
        g.drawImage(fakePortalImg, (int)super.x, (int)super.y, (int)super.WIDTH, (int)super.HEIGHT, null);
        g.draw(this.getCollisionBox());
    }

    @Override
    public void collide(GameObject O) {
        if(GameData.chipsLeft == 0){            
            goBack = true; 
            DungeonCrawl.bannerPanel.setBannerText("You Completed Level " + GameData.currentLevel.getLevelValue());
            GameData.goToPreviousLevel();
        }
    }
    
}
