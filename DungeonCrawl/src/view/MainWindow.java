/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DungeonCrawl.DungeonCrawl;
import controller.KeyController;
import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author russe_000
 */
public class MainWindow extends JFrame {
    public static Container c;
    
    public MainWindow(){
        c = getContentPane();
        
        c.add(DungeonCrawl.gamePanel, "Center");
        c.add(DungeonCrawl.inventoryPanel, "East");
        
        KeyController keyListener = new KeyController();
        DungeonCrawl.gamePanel.addKeyListener(keyListener);
        this.setResizable(false);
    }
}
