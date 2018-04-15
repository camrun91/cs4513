package model.Moveable;

import controller.ImageFinder;
import controller.ObjectAnimator;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.Direction;
import model.GameObject;
import model.Immoveable.Tile.FakeWall;
import model.Immoveable.Tile.Ice;
import model.Immoveable.Tile.Spawner;
import model.Immoveable.Tile.ToggleWall;
import model.Immoveable.Tile.Wall;
import model.Immoveable.Tile.Water;

public class Ball extends Monster {

    private ObjectAnimator ballMoves;
    private BufferedImage[] ballSprites;
    private int counter;

    public Ball(float x, float y, Direction D) {
        super(x, y);
        ballMoves = new ObjectAnimator();
        ballSprites = new BufferedImage[1];
        direction = D;
        moving = D;

        try {
            BufferedImage image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Pink_Ball.png");
            ballSprites[0] = image;
        } catch (Exception e) {
        }
    }

    public void turnAround() {
        direction = direction.getOppositeDirection();
        moving = direction;

        moveOneTile();
    }

    public void moveOneTile() {
        switch (direction) {
            case LEFT:
                super.x -= MOVEMENT;
                break;
            case RIGHT:
                super.x += MOVEMENT;
                break;
            case UP:
                super.y -= MOVEMENT;
                break;
            case DOWN:
                super.y += MOVEMENT;
                break;
        }
        moving = direction;
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(ballMoves.getImage(), (int) super.x, (int) super.y, 32, 32,
                null);
    }

    @Override
    public void update() {
        super.update();

        ballMoves.setFrames(ballSprites);

        if (isSliding()) {
            direction = moving;
            slide(moving);
        } else {
            if (counter == 1000) {
                counter = 0;
                moveOneTile();
            } else {
                counter += 100;
            }
        }
        ballMoves.update();
    }
    
    @Override
    public void collide(GameObject O) {
        super.collide(O);
        if (O instanceof Wall || O instanceof FakeWall) {
            if (!(O instanceof ToggleWall)) {
                this.noMove();
                this.turnAround();
            }


        }
    }
}
