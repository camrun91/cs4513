package view;

import controller.ImageFinder;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import model.GameData;
import model.GameObject;

public final class GamePanel extends JPanel 
{
    public static int pwidth, pheight;

    private Graphics2D graphics;
    private Image dbImage = null;

    public GamePanel(Image dbImage) {
        dbImage = ImageFinder.getImage("ImagesFolder", "Floor25pxT.png");
        this.paintComponent(graphics);
        System.out.println("I Ran!");
    }
    
    public GamePanel(int pwidth, int pheight) 
    {
        GamePanel.pwidth = pwidth;
        GamePanel.pheight = pheight;
        
        setPreferredSize(new Dimension(GamePanel.pwidth, GamePanel.pheight));
        setFocusable(true);
    }    

    public void gameRender() 
    {        
        if (dbImage == null) {
            dbImage = createImage(pwidth, pheight);
            if (dbImage == null) {
                System.out.println("dbImage is null");
                return;
            } else {
                graphics = (Graphics2D)dbImage.getGraphics();
            }
        }
        
        

        graphics.clearRect(0, 0, GamePanel.pwidth, GamePanel.pheight);
        graphics.drawImage(ImageFinder.getImage("ImagesFolder", "map.png"), 0, 0, this);

        synchronized(GameData.gameObjects) 
        {                    
            for(GameObject object : GameData.gameObjects) 
            {
                    object.render(graphics);
            }
        }        
    }      

    public void printScreen() {
        Graphics2D g;
        try {
            g = (Graphics2D)this.getGraphics();
            if ((g != null) && (dbImage != null)) {
                g.drawImage(dbImage, 0, 0, null);
            }
            Toolkit.getDefaultToolkit().sync();
            if (g != null) {
                g.dispose();
            }
        } catch (Exception e) {
            System.out.println("Graphics error: " + e);
        }
    }
}
