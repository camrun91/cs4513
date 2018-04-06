package model.Immoveable.Tile;

import controller.ImageFinder;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Wall extends Tile {

    public BufferedImage image;

    public Wall(float x, float y) {
        super(x, y);

        try {
            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Wall.png");
        } catch (Exception e) {
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(image, (int) super.x, (int) super.y, (int) WIDTH, (int) HEIGHT, null);
    }

}
