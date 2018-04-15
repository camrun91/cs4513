package model.Moveable;

import model.Direction;
import java.awt.Graphics2D;
import controller.ImageFinder;
import controller.ObjectAnimator;
import java.awt.image.BufferedImage;
import model.GameObject;
import model.Immoveable.Tile.FakeWall;
import model.Immoveable.Tile.Fire;
import model.Immoveable.Tile.Wall;
import model.Immoveable.Tile.Water;

public class Tank extends Monster {

    public BufferedImage[] tank_S;
    public BufferedImage[] tank_N;
    public BufferedImage[] tank_W;
    public BufferedImage[] tank_E;

    int counter = 0;

    private final ObjectAnimator tankMoves;

    public Tank(float x, float y, Direction d) {
        super(x, y);
        tankMoves = new ObjectAnimator();
        super.direction = d;
        moving = direction;

        tank_S = new BufferedImage[1];
        tank_N = new BufferedImage[1];
        tank_W = new BufferedImage[1];
        tank_E = new BufferedImage[1];

        try {
            BufferedImage image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Tank_S.png");
            tank_S[0] = image;
            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Tank_N.png");
            tank_N[0] = image;
            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Tank_W.png");
            tank_W[0] = image;
            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Tank_E.png");
            tank_E[0] = image;
        } catch (Exception e) {
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(tankMoves.getImage(), (int) super.x, (int) super.y, (int) HEIGHT, (int) WIDTH,
                null);
    }

    @Override
    public void update() {
        super.update();

        if (isSliding()) {
            direction = moving;
            slide(moving);
        } else {
            if (counter == 1000) {
                counter = 0;
                switch (direction) {
                    case LEFT:
                        tankMoves.setFrames(tank_W);
                        super.x -= MOVEMENT;
                        break;
                    case RIGHT:
                        tankMoves.setFrames(tank_E);
                        super.x += MOVEMENT;
                        break;
                    case UP:
                        tankMoves.setFrames(tank_N);
                        super.y -= MOVEMENT;
                        break;
                    case DOWN:
                        tankMoves.setFrames(tank_S);
                        super.y += MOVEMENT;
                        break;                        
                }
                moving = direction;
            } else {
                counter += 100;
            }
        }
        
        switch (moving) {
            case LEFT:
                tankMoves.setFrames(tank_W);
                break;
            case RIGHT:
                tankMoves.setFrames(tank_E);
                break;
            case UP:
                tankMoves.setFrames(tank_N);
                break;
            case DOWN:
                tankMoves.setFrames(tank_S);
                break;
        }
        tankMoves.update();
    }

    @Override
    public void collide(GameObject O) {
        super.collide(O);
        
        if (O instanceof Water || O instanceof Fire) {
            this.setAlive(false);
        }
        if(O instanceof Wall || O instanceof FakeWall){
            this.noMove();
        }
    }
}
