package model.Moveable;

import controller.ImageFinder;
import controller.ObjectAnimator;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.Collidable;
import model.Direction;
import model.GameObject;
import model.Immoveable.Tile.FakeWall;
import model.Immoveable.Tile.Wall;

public class Gamer extends MoveableObject implements Collidable {
    public BufferedImage[] leftIdle;
    public BufferedImage[] rightIdle;
    public BufferedImage[] downIdle;
    public BufferedImage[] upIdle;
    public boolean keepSliding;

    private final ObjectAnimator gamerMoves;

    public Gamer(float x, float y) {
        super(x, y);

        moving = Direction.DOWN;
        gamerMoves = new ObjectAnimator();
        upIdle = new BufferedImage[1];
        rightIdle = new BufferedImage[1];
        downIdle = new BufferedImage[1];
        leftIdle = new BufferedImage[1];
        setImages();
    }

    public final void setImages() {
        try {
            BufferedImage image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Chip_S.png");

            downIdle[0] = image;

            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Chip_N.png");

            upIdle[0] = image;

            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Chip_W.png");

            leftIdle[0] = image;

            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Chip_E.png");

            rightIdle[0] = image;
        } catch (Exception e) {
        }
    }

    public void setDirection(Direction d) {
        super.direction = d;
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(gamerMoves.getImage(), (int) super.x, (int) super.y, (int) WIDTH, (int) HEIGHT,
                null);
        g.setColor(Color.blue);
        g.draw(this.getCollisionBox());
    }

    @Override
    public void update() {
        super.update();
        if (isSliding()) {
            slide(moving);
        }
        if (!keepSliding) {
            switch (direction) {
                case LEFT:
                    super.x -= MOVEMENT;
                    moving = this.direction;
                    gamerMoves.setFrames(leftIdle);
                    break;
                case RIGHT:
                    super.x += MOVEMENT;
                    moving = this.direction;
                    gamerMoves.setFrames(rightIdle);
                    break;
                case DOWN:
                    super.y += MOVEMENT;
                    moving = this.direction;
                    gamerMoves.setFrames(downIdle);
                    break;
                case UP:
                    super.y -= MOVEMENT;
                    moving = this.direction;
                    gamerMoves.setFrames(upIdle);
                    break;
            }
        }

        switch (moving) {
            case LEFT:
                gamerMoves.setFrames(leftIdle);
                break;
            case RIGHT:
                gamerMoves.setFrames(rightIdle);
                break;
            case UP:
                gamerMoves.setFrames(upIdle);
                break;
            case DOWN:
                gamerMoves.setFrames(downIdle);
                break;
        }

        gamerMoves.update();
        setDirection(Direction.NONE);
        keepSliding = false;
    }

    @Override
    public void collide(GameObject O) {
        if(O instanceof Wall){
            this.noMove();
        }
        if(O instanceof FakeWall){
            if(((FakeWall) O).wall){
                ((FakeWall) O).image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Wall.png");
                this.noMove();
            }
            if(((FakeWall) O).floor){
                ((FakeWall) O).setAlive(false);
            }
        }
    }
}
