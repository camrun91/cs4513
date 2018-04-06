package model.Immoveable.Tile;

import controller.ImageFinder;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.GameData;
import model.GameObject;
import DungeonCrawl.DungeonCrawl;
import java.util.ArrayList;
import model.Collidable;

public class Teleporter extends Tile implements Collidable {

    public BufferedImage teleporterImg;
    Teleporter up, down, left, right;
    ArrayList<GameObject> onTeleporter = new ArrayList<>();
    ArrayList<GameObject> prevOnTeleporter = new ArrayList<>();
    
    public Teleporter(float x, float y){
        super(x, y);
        
        loadImages();
    }
    
    public Teleporter(float x, float y, Teleporter matchingDuplet){
        super(x, y);
        
        up = matchingDuplet;
        down = matchingDuplet;
        left = matchingDuplet;
        right = matchingDuplet;
        
        matchingDuplet.setUp(this);
        matchingDuplet.setDown(this);
        matchingDuplet.setLeft(this);
        matchingDuplet.setRight(this);
        
        loadImages();
    }
    
    public Teleporter(float x, float y, Teleporter up, Teleporter down, Teleporter left, Teleporter right){
        super(x, y);
        
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        
        loadImages();
    }
    
    public void loadImages(){
        try{            
            BufferedImage image = (BufferedImage)ImageFinder.getImage("ImagesFolder", "Teleporter.png");
            teleporterImg = image;
        } catch(Exception e){
            DungeonCrawl.thread.interrupt();
        }
    }
    
    @Override
    public void render(Graphics2D g) {
        g.drawImage(teleporterImg, (int)super.x, (int)super.y, (int)super.WIDTH, (int)super.HEIGHT, null);
        g.draw(this.getCollisionBox());
    }

    @Override
    public void collide(GameObject O) {
        onTeleporter.add(O);
        if(O.equals(GameData.gamer) && !(prevOnTeleporter.contains(O))){
            
            switch(GameData.gamer.moving){
                case UP:
                    GameData.gamer.x = up.x;
                    GameData.gamer.y = up.y;
                    up.onTeleporter.add(O);
                    up.prevOnTeleporter.add(O);
                    break;
                case DOWN:
                    GameData.gamer.x = down.x;
                    GameData.gamer.y = down.y;
                    down.onTeleporter.add(O);
                    down.prevOnTeleporter.add(O);
                    break;
                case LEFT:
                    GameData.gamer.x = left.x;
                    GameData.gamer.y = left.y;
                    left.onTeleporter.add(O);
                    left.prevOnTeleporter.add(O);
                    break;
                case RIGHT:
                    GameData.gamer.x = right.x;
                    GameData.gamer.y = right.y;
                    right.onTeleporter.add(O);
                    right.prevOnTeleporter.add(O);
                    break;
            }
        }
    }
    
    @Override
    public void update(){
        prevOnTeleporter.clear();
        prevOnTeleporter.addAll(onTeleporter);
        onTeleporter.clear();
    }
    
    public void setUp(Teleporter up){
        this.up = up;
    }
    
    public void setDown(Teleporter down){
        this.down = down;
    }
    
    public void setLeft(Teleporter left){
        this.left = left;
    }
    
    public void setRight(Teleporter right){
        this.right = right;
    }
}
