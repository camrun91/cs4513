package model.Moveable;

import controller.ImageFinder;
import controller.ObjectAnimator;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.Direction;
import model.GameData;
import model.GameObject;
import model.Immoveable.Tile.FakeWall;
import model.Immoveable.Tile.Wall;

public class Fireball extends Monster {

    private int counter = 0;

    public BufferedImage[] fireballSprites;

    private final ObjectAnimator fireballMoves;

    public Fireball(float x, float y, Direction d) {
        super(x, y);
        fireballMoves = new ObjectAnimator();
        super.direction = d;
        moving = d;

        fireballSprites = new BufferedImage[1];
        try {
            BufferedImage image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Fireball.png");
            fireballSprites[0] = image;
        } catch (Exception e) {
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(fireballMoves.getImage(), (int) super.x, (int) super.y, (int) WIDTH, (int) HEIGHT,
                null);

        //Draw Collision Box
        g.setColor(Color.blue);
        g.draw(this.getCollisionBox());
    }

    @Override
    public void update() {
        super.update();
        fireballMoves.setFrames(fireballSprites);

        if (GameData.currentLevel.getLevelValue() == 1) {
            if (isSliding()) {
                direction = moving;
                slide(moving);
            } else {
                if (counter == 1000) {
                    counter = 0;
                    switch (direction) {
                        case LEFT:
                            super.x -= MOVEMENT;
                            if (super.x == 64) {
                                direction = Direction.DOWN;
                            }
                            break;
                        case RIGHT:
                            super.x += MOVEMENT;
                            if (super.x == 192) {
                                direction = Direction.UP;
                            }
                            break;
                        case UP:
                            super.y -= MOVEMENT;
                            if (super.y == 64) {
                                direction = Direction.LEFT;
                            }
                            break;
                        case DOWN:
                            super.y += MOVEMENT;
                            if (super.y == 192) {
                                direction = Direction.RIGHT;
                            }
                    }
                    moving = direction;
                } else {
                    counter += 100;
                }
            }
            fireballMoves.update();
        } else if (GameData.currentLevel.getLevelValue() == 2) {
            if (counter == 1000) {
                counter = 0;
                switch (direction) {
                    case LEFT:
                        super.x -= MOVEMENT;
                        if (super.x == 512) {
                                direction = Direction.DOWN;
                        }
                        break;
                    case RIGHT:
                        super.x += MOVEMENT;
                        if (super.x == 928) {
                            direction = Direction.UP;
                        }                      
                        break;
                    case UP:
                        super.y -= MOVEMENT;
                        if (super.y == 224) {
                            direction = Direction.LEFT;
                        }
                        break; 
                    case DOWN: 
                        super.y += MOVEMENT;
                        if (super.y == 352) {
                            direction = Direction.RIGHT;
                        }
                        break; 
                }
            }else {
                counter += 100;
            }
        }else if (GameData.currentLevel.getLevelValue() == 3) {
            if (isSliding()) {
            direction = moving;
            slide(moving);
        } else {
            if (counter == 1000) {
                counter = 0;
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
            } else {
                counter += 100;
            }
        }
        }
    }

    public void turn(Direction d) {
        direction = d;
        moving = d;
    }

    @Override
    public void collide(GameObject O) {
        super.collide(O);
        
        if (O instanceof Block || O instanceof Wall || O instanceof Monster || O instanceof FakeWall) {
            noMove();
            direction = direction.getOppositeDirection();
        }
    }
}
