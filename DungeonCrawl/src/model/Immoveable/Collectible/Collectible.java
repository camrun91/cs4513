package model.Immoveable.Collectible;

import model.Immoveable.ImmovableObject;

public  abstract class Collectible extends ImmovableObject {
    
    public boolean isDisplayed = true;
    
    public Collectible(float x, float y) {
        super(x, y);
    }        
}
