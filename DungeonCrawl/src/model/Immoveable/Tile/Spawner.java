package model.Immoveable.Tile;

import controller.ImageFinder;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.Collidable;
import model.GameData;
import model.GameObject;
import model.Moveable.Monster;
import model.Moveable.MoveableObject;

public class Spawner extends Wall implements Collidable{

    BufferedImage spawnerImage;
    Monster monster;
    
    public Spawner(float x, float y, Monster m) {
        super(x, y);
        super.setAlive(true);
        monster = m;
        loadImage();
    }

    @Override
    public void collide(GameObject O) {
        ((MoveableObject)O).noMove();
    }

    private void loadImage() {
        try{
            spawnerImage = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Spawner.png");
        }
        catch(Exception e){
            
        }
    }
    
    @Override
    public void render(Graphics2D g) {
        g.drawImage(spawnerImage, (int)super.x, (int)super.y, (int)WIDTH, (int)HEIGHT, null);
    }

    public void spawn() {
        Monster newMonster = null;
        try{
            newMonster = (Monster) monster.clone();
        }catch(CloneNotSupportedException e){
            System.out.println(e);
        }
        if(newMonster != null){
            GameData.spawn(newMonster);
        }
    }
    
}
