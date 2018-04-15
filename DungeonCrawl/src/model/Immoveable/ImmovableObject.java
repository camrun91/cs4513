package model.Immoveable;

import java.awt.geom.Rectangle2D;
import model.Direction;
import model.GameObject;

public abstract class ImmovableObject implements GameObject {
    
    public float x, y;
    public Direction direction;
    private boolean alive;    
    
    public ImmovableObject(float x, float y){
        this.x = x * OFFSET;
        this.y = y * OFFSET;
        alive = true;
    }
    
    @Override
    public Rectangle2D.Double getCollisionBox(){
        return new Rectangle2D.Double(x, y, WIDTH, HEIGHT);
    }
    
    @Override
    public boolean isAlive(){
        return alive;
    }
    
    public void setAlive(boolean a){
        this.alive = a;
    }
    
    @Override
    public void update(){}    
}
