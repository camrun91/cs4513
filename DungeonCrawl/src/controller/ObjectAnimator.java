package controller;
import java.awt.image.*; 

public class ObjectAnimator {
    private BufferedImage[] frames;
    private int currentFrame;
    
    private long Timer = 0;
    private int delay;
    
    public ObjectAnimator(){}
    
    public void setFrames(BufferedImage[] images)
    {
        frames = images;
        if(currentFrame >= frames.length) currentFrame = 0;
    }
    
    public void setDelay(int d){
        delay = d;
    }
    
    public void update(){
        
        long elapsed = (System.currentTimeMillis() - Timer);
        if(elapsed > delay)
        {
            currentFrame++;
            Timer = System.currentTimeMillis();
        }
        
        if(currentFrame == frames.length)
        {
            currentFrame = 0;
        }
    }
    
    
    public BufferedImage getImage()
    {
        return frames[currentFrame];
    }
    
    public int getFrame()
    {
        return currentFrame;
    }
}