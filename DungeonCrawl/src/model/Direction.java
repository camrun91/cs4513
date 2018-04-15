package model;

public enum Direction {
    LEFT, RIGHT, UP, DOWN,
    NE, NW, SE, SW, NONE;
    
    public Direction getOppositeDirection(){
        switch(this){
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            case UP:
                return DOWN;
            case DOWN:
                return UP;            
        }
        return null;
    }
    public Direction turnCW(){
        switch(this){
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
        }
        return null;
    }
    public Direction turnCCW(){
        switch(this){
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
        }
        return null;
    }
    public Direction walkerMovement() {
        switch(this){
            case LEFT:
                return RIGHT;
            case RIGHT:
                return DOWN;
            case UP:
                return LEFT;
            case DOWN:
                return UP;
        }
        return null;
    }
}
