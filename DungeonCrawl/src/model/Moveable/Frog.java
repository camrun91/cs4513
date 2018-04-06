/*
* Methods ChangeNodeContents, GetNodeContents and ShortestPath are adapted from 
* Mazesolver example: https://www.codeproject.com/Articles/9040/Maze-Solver-shortest-path-finder
* on 3/17/2018.
*/

package model.Moveable;

import controller.ImageFinder;
import controller.ObjectAnimator;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import model.Direction;
import model.GameData;
import model.GameObject;
import model.Immoveable.Tile.Bomb;
import model.Immoveable.Tile.Button;

public class Frog extends Monster {

    public BufferedImage[] frogSprites;
    private ObjectAnimator frogMoves;
    private double previousTime;
    private int[][] grid;
    final static int PATH = 5;
    final static int TRIED = 4;
    final static int ROWS = 28;
    final static int COLS = 31;

    public Frog(float x, float y) {
        super(x, y);

        frogMoves = new ObjectAnimator();
        previousTime = GameData.time;
        this.direction = Direction.UP;
        loadImages();
    }

    public void loadImages() {
        frogSprites = new BufferedImage[4];
        try {
            frogSprites[0] = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Frog_N.png");
            frogSprites[1] = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Frog_S.png");
            frogSprites[2] = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Frog_E.png");
            frogSprites[3] = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Frog_W.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(Graphics2D g) {
        loadImages();
        g.drawImage(frogMoves.getImage(), (int) super.x, (int) super.y, (int) Monster.WIDTH, (int) Monster.HEIGHT,
                null);
    }

    @Override
    public void update() {
        super.update();

        if (this.direction != null) {
            switch (this.direction) {
                case UP:
                    this.frogMoves.setFrames(new BufferedImage[]{frogSprites[0]});
                    break;
                case DOWN:
                    this.frogMoves.setFrames(new BufferedImage[]{frogSprites[1]});
                    break;
                case LEFT:
                    this.frogMoves.setFrames(new BufferedImage[]{frogSprites[2]});
                    break;
                case RIGHT:
                    this.frogMoves.setFrames(new BufferedImage[]{frogSprites[3]});
                    break;
                default:
                    break;
            }
        }

        if (GameData.time < previousTime) {
            grid = new int[28][31];

            //Frog
            Point frog = new Point((int) this.x / OFFSET, (int) this.y / OFFSET);
            Point gamer = new Point((int) GameData.gamer.x / OFFSET, (int) GameData.gamer.y / OFFSET);

            //Check to see if the gamer is in a surrounding block before trying to find the shortest path
            //North
            if (frog.x == gamer.x && frog.y - 1 == gamer.y) {
                this.y = (int) gamer.y / OFFSET;
                this.collide(GameData.gamer);
            } //South
            else if (frog.x == gamer.x && frog.y + 1 == gamer.y) {
                this.y = (int) gamer.y / OFFSET;
                this.collide(GameData.gamer);
            } //East
            else if (frog.x + 1 == gamer.x && frog.y == gamer.y) {
                this.x = (int) gamer.x / OFFSET;
                this.collide(GameData.gamer);
            } //West
            else if (frog.x - 1 == gamer.x && frog.y == gamer.y) {
                this.x = (int) gamer.x / OFFSET;
                this.collide(GameData.gamer);
            } else {
                // Identify all gameobjects on grid and assign 1
                // Frog, Gamer, Button and Bomb are kept as 0 so they can be part of the frogs path 
                for (GameObject O : GameData.gameObjects) {
                    if (O != this && !(O instanceof Gamer) && !(O instanceof Bomb) && !(O instanceof Button)) {
                        int xCord = (int) (O.getCollisionBox().x / OFFSET);
                        int yCord = (int) (O.getCollisionBox().y / OFFSET);
                        grid[yCord][xCord] = 1;
                    }
                }

                // Identify frog on grid and assign 0
                grid[frog.y][frog.x] = 0;
                // Identify gamer on grid and assign 0
                grid[gamer.y][gamer.x] = 0;

                // Find shortest path using BFS
                Point pathFound = this.ShortestPath(frog, gamer);
                if (pathFound != null) {
                    if (pathFound.x != 0 && pathFound.y != 0) {
                        //North
                        if (pathFound.x == (int) this.y / OFFSET - 1) {
                            this.direction = Direction.UP;
                        } //South
                        else if (pathFound.x == (int) this.y / OFFSET + 1) {
                            this.direction = Direction.DOWN;
                        } //East
                        else if (pathFound.y == (int) this.x / OFFSET + 1) {
                            this.direction = Direction.LEFT;
                        } //West 
                        else if (pathFound.y == (int) this.x / OFFSET - 1) {
                            this.direction = Direction.RIGHT;
                        }

                        this.x = pathFound.y * OFFSET;
                        this.y = pathFound.x * OFFSET;
                    }
                }
            }
        }

        previousTime = GameData.time;
    }

    @Override
    public void collide(GameObject O) {
        super.collide(O);

        if (O instanceof Monster) {
            this.noMove();
        }
    }

    private void ChangeNodeContents(int[][] iMaze, int iNodeNo, int iNewValue) {
        if (iNodeNo < 0) {
            iMaze[(int) this.y / OFFSET][(int) this.x / OFFSET] = iNewValue;
        } else {
            iMaze[iNodeNo / COLS][iNodeNo - iNodeNo / COLS * COLS] = iNewValue;
        }
    }

    private int GetNodeContents(int[][] iMaze, int iNodeNo) {
        if (iNodeNo < 0) {
            return iMaze[(int) this.y / OFFSET][(int) this.x / OFFSET];
        } else {
            return iMaze[iNodeNo / COLS][iNodeNo - (iNodeNo / COLS) * COLS];
        }
    }

    private Point ShortestPath(Point from, Point to) {
        int start = (from.y * COLS) + from.x;
        int stop = (to.y * COLS) + to.x;

        // Point representing the frogs next jump if path is found
        Point nextJump = new Point();

        int max = ROWS * COLS;
        int[] Queue = new int[max];
        int[] Origin = new int[max];
        int front = 0, rear = 0;

        //check if starting and ending points are valid (open)
        if (GetNodeContents(grid, start) != 0 || GetNodeContents(grid, stop) != 0) {
            return null;
        }
        //create dummy array for storing status
        int[][] iMazeStatus = new int[ROWS][COLS];

        //add starting node to Q
        Queue[rear] = start;
        Origin[rear] = -1;
        rear++;
        int current, left, right, top, down;
        while (front != rear) // while Q not empty	
        {
            if (Queue[front] == stop) // maze is solved
            {
                break;
            }

            current = Queue[front];

            left = current - 1;
            if (left != 0 && left / COLS == current / COLS) //if left node exists
            {
                if (GetNodeContents(grid, left) == 0) //if left node is open(a path exists)
                {
                    if (GetNodeContents(iMazeStatus, left) == 0) //if left node is ready
                    {
                        Queue[rear] = left; //add to Q
                        Origin[rear] = current;
                        ChangeNodeContents(iMazeStatus, left, 2); //change status to waiting
                        rear++;
                    }
                }
            }

            right = current + 1;
            if (right < max && right / COLS == current / COLS) //if right node exists
            {
                if (GetNodeContents(grid, right) == 0) //if right node is open(a path exists)
                {
                    if (GetNodeContents(iMazeStatus, right) == 0) //if right node is ready
                    {
                        Queue[rear] = right; //add to Q
                        Origin[rear] = current;
                        ChangeNodeContents(iMazeStatus, right, 2); //change status to waiting
                        rear++;
                    }
                }
            }

            top = current - COLS;
            if (top != 1) //if top node exists
            {
                if (GetNodeContents(grid, top) == 0) //if top node is open(a path exists)
                {
                    if (GetNodeContents(iMazeStatus, top) == 0) //if top node is ready
                    {
                        Queue[rear] = top; //add to Q
                        Origin[rear] = current;
                        ChangeNodeContents(iMazeStatus, top, 2); //change status to waiting
                        rear++;
                    }
                }
            }

            down = current + COLS;
            if (down < max) //if bottom node exists
            {
                if (GetNodeContents(grid, down) == 0) //if bottom node is open(a path exists)
                {
                    if (GetNodeContents(iMazeStatus, down) == 0) //if bottom node is ready
                    {
                        Queue[rear] = down; //add to Q
                        Origin[rear] = current;
                        ChangeNodeContents(iMazeStatus, down, 2); //change status to waiting
                        rear++;
                    }
                }
            }

            //change status of current node to processed
            ChangeNodeContents(iMazeStatus, current, (int) 3);
            front++;

        }

        //create an array(maze) for solution
        int[][] iMazeSolved = new int[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            System.arraycopy(grid[i], 0, iMazeSolved[i], 0, COLS);
        }

        //make a path in the Solved Maze        
        current = stop;
        ChangeNodeContents(iMazeSolved, current, PATH);
        for (int i = front; i >= 0; i--) {
            if (Queue[i] == current) {
                current = Origin[i];
                if (current == -1) // maze is solved
                {
                    if (front == 2) {
                        nextJump = new Point(Queue[2] / COLS, Queue[2] - Queue[2] / COLS * COLS);
                    }
                    return nextJump;
                    //return (iMazeSolved);
                }
                ChangeNodeContents(iMazeSolved, current, PATH);

                if (start != current) {
                    nextJump = new Point(current / COLS, current - current / COLS * COLS);
                }
            }
        }
        //no path exists
        return null;
    }
}
