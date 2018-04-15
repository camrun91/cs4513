package model.Immoveable.Tile;

import controller.ImageFinder;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.BootType;
import model.Collidable;
import model.Direction;
import model.GameData;
import model.GameObject;
import model.Immoveable.Collectible.Boot;
import model.Moveable.Gamer;
import model.Moveable.MoveableObject;

public class Force extends Tile implements Collidable {

    private BufferedImage[] image;

    public Force(float x, float y) {
        super(x, y);
        super.direction = Direction.DOWN;

        loadImages();
    }

    public Force(float x, float y, Direction d) {
        super(x, y);
        super.direction = d;

        loadImages();
    }

    @Override
    public void render(Graphics2D g) {
        switch (direction) {
            case UP:
                g.drawImage(image[0], (int) super.x, (int) super.y, (int) HEIGHT, (int) WIDTH, null);
                break;
            case DOWN:
                g.drawImage(image[1], (int) super.x, (int) super.y, (int) HEIGHT, (int) WIDTH, null);
                break;
            case RIGHT:
                g.drawImage(image[2], (int) super.x, (int) super.y, (int) HEIGHT, (int) WIDTH, null);
                break;
            case LEFT:
                g.drawImage(image[3], (int) super.x, (int) super.y, (int) HEIGHT, (int) WIDTH, null);
                break;
        }
    }

    @Override
    public void collide(GameObject O) {
        boolean boot = false;
        if (O instanceof Gamer) {
            for (Object item : GameData.gamerInventory) {
                if (item instanceof Boot) {
                    if (((Boot) item).type == BootType.FORCE) {
                        boot = true;
                        break;
                    }
                }
            }
        }
        if (O instanceof MoveableObject && !boot) {
            ((MoveableObject) O).sliding(true);
            ((MoveableObject) O).moving = this.direction;
        }
    }

    private void loadImages() {
        image = new BufferedImage[4];
        try {
            image[0] = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Force_Floor_N.png");
            image[1] = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Force_Floor_S.png");
            image[2] = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Force_Floor_E.png");
            image[3] = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Force_Floor_W.png");
        } catch (Exception e) {
        }
    }
}
