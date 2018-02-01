package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.GameData;
import model.GameObject;

public class GamePanel extends JPanel 
{
    public static final int PWIDTH = 1000; 
    public static final int PHEIGHT = 900;

    private Graphics graphics;
    private Image dbImage = null;

    public GamePanel() 
    {
        setBackground(Color.black);
        setPreferredSize(new Dimension(PWIDTH, PHEIGHT));
        setFocusable(true);
        requestFocus();
    }

    public void gameRender() 
    {        
        if (dbImage == null) {
            dbImage = createImage(PWIDTH, PHEIGHT);
            if (dbImage == null) {
                System.out.println("dbImage is null");
                return;
            } else {
                graphics = dbImage.getGraphics();
            }
        }

        graphics.clearRect(0, 0, GamePanel.PWIDTH, GamePanel.PHEIGHT);

        synchronized(GameData.gameObjects) 
        {
            ArrayList<GameObject> remove = new ArrayList<>();
                    
            for(GameObject object : GameData.gameObjects) 
            {
                if(object.isAlive())
                {
                    object.render(graphics);
                }
                else
                {
                    remove.add(object);
                }
                
                object.render(graphics);
            }
            
            GameData.gameObjects.removeAll(remove);
        }
    }      

    public void printScreen() {
        Graphics g;
        try {
            g = this.getGraphics();
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
