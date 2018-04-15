package model.Immoveable.Tile;

import DungeonCrawl.DungeonCrawl;
import controller.ImageFinder;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.Direction;
import model.Moveable.Monster;

public class Trap extends Tile {

    public BufferedImage image;
    public Monster trapped;
    public Direction direction;
    private boolean isTrapped;
    private Button releaseButton;
    private long releaseTime;

    public Trap(float x, float y, Button B ) {
        super(x, y);
        releaseTime = 9999;
        releaseButton = B;
        releaseButton.associatedObjects.add(this);

        try {
            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Trap.png");
        } catch (Exception e) {
        }
        trapped = null;
        direction = null;
        isTrapped = false;

    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(image, (int) super.x, (int) super.y, (int) WIDTH, (int) HEIGHT, null);
    }

    /**
     * trigger sets the monster to immoveable and sets the trap status to
     * closed.
     *
     * @param M The monster object that has collided with the trap.
     */
    public void trigger(Monster M) {
        if (!isTrapped) {
            isTrapped = true;
            trap(M);
        } else {
            //something is already in the trap
            //Do Nothing
        }
    }

    private void trap(Monster M) {
        if (isTrapped && releaseTime<DungeonCrawl.gameData.getTime() ) {
            trapped = M;
            direction = M.direction;
            trapped.direction = Direction.NONE;
        }
    }

    public void release() {
        if(isTrapped){
        releaseTime = DungeonCrawl.gameData.getTime();
        isTrapped = false;
        trapped.direction = direction;}
    }

}
