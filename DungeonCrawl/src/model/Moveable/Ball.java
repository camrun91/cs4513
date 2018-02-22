/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Moveable;

import DungeonCrawl.DungeonCrawl;
import static DungeonCrawl.DungeonCrawl.gameData;
import controller.ImageFinder;
import controller.ObjectAnimator;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.Direction;
import model.GameData;
import model.GameObject;
import model.Immoveable.Tile.Fire;
import model.Immoveable.Tile.Wall;
import model.Immoveable.Tile.Water;

/**
 *
 * @author russe_000
 */
public class Ball extends Monster {

    private ObjectAnimator ballMoves;
    private BufferedImage[] ballSprites;
    private Boolean turnLeft, turnRight, turnUp, turnDown, isBlocked;
    private int counter;
    private int moveTiles = 1; //moveTiles determines the number of tiles that will be moved each frame
    private int movePixels = 32; //movePixels determines the number of pixels that will be moved each frame;
    public float dx;
    public float dy;
    public Direction direction;

    public Ball(float x, float y, Direction D) {
        super(x, y);
        ballMoves = new ObjectAnimator();
        ballSprites = new BufferedImage[1];
        setDirection(D);
        try {
            BufferedImage image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Pink_Ball.png");
            ballSprites[0] = image;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setDirection(Direction D)
    {   direction = D;
        if(D == Direction.DOWN){turnDown = true;
        turnUp = turnLeft = turnRight = false;
        }
        if(D == Direction.UP){turnUp = true;
        turnDown = turnLeft = turnRight = false;}
        if(D == Direction.LEFT){turnLeft = true;
        turnUp = turnDown = turnRight = false;}
        if(D == Direction.RIGHT){turnRight = true;
        turnUp = turnLeft = turnDown = false;}
        
    }

    public void turnAround() {
      direction = direction.getOppositeDirection();
      setDirection(direction);
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(ballMoves.getImage(), (int) super.x, (int) super.y, 32, 32,
                null);
        //Draw Collision Box
        g.setColor(Color.blue);
        g.draw(this.getCollisionBox());
    }

    @Override
    public boolean isAlive() {
        //TODO: code logic to detect death
        return true;
    }

    @Override
    public void update() {
        dx = super.x;
        dy = super.y;
        ballMoves.setFrames(ballSprites);
        if (turnLeft) {
            if (gameData.time > 0) {
                if (counter == 1000) {
                    counter = 0;
                    for (int i = 0; i < moveTiles; i++) {
                        super.x -= movePixels;
                    }
                    if (super.x <= 0) {
                        turnLeft = false;
                        turnRight = true;
                        turnUp = false;
                        turnDown = false;
                    }
                    ballMoves.setFrames(ballSprites);

                } else {
                    counter += 100;
                }
            }
        } else if (turnDown) {
            if (gameData.time > 0) {
                if (counter == 1000) {
                    counter = 0;
                    for (int i = 0; i < moveTiles; i++) {
                        super.y += movePixels;
                    }
                    if (super.y >= 600) {
                        turnDown = false;
                        turnUp = true;
                        turnLeft = false;
                        turnRight = false;
                    }
                    ballMoves.setFrames(ballSprites);

                } else {
                    counter += 100;
                }
            }
        } else if (turnRight) {
            if (gameData.time > 0) {
                if (counter == 1000) {
                    counter = 0;
                    for (int i = 0; i < moveTiles; i++) {
                        super.x += movePixels;
                    }
                    if (super.x >= 1000) {
                        turnLeft = true;
                        turnRight = false;
                        turnUp = false;
                        turnDown = false;
                    }
                    ballMoves.setFrames(ballSprites);

                } else {
                    counter += 100;
                }
            }
        } else if (turnUp) {
            if (gameData.time > 0) {
                if (counter == 1000) {
                    counter = 0;
                    for (int i = 0; i < moveTiles; i++) {
                        super.y -= movePixels;
                    }
                    if (super.y <= 0) {
                        turnLeft = false;
                        turnRight = false;
                        turnUp = false;
                        turnDown = true;
                    }
                    ballMoves.setFrames(ballSprites);

                } else {
                    counter += 100;
                }
            }
        }
        ballMoves.update();
    }

    @Override
    public void collide(GameObject O) {
        if (O instanceof Gamer) {
            DungeonCrawl.bannerPanel.setBannerText("You colided with the Ball on Level  " + GameData.currentLevel.getLevelValue());
            GameData.levelInProgress = false;
        } else if (O instanceof Wall || O instanceof Fire || O instanceof Block || O instanceof Water) {
            this.turnAround();
        }

    }
    
        public void noMove() {
        super.x = dx;
        super.y = dy;
        this.turnAround();
    }

}
