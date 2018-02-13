/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DungeonCrawl;
import controller.Animator;
import java.awt.Color;
import javax.swing.JFrame;
import model.GameData;
import view.MainWindow;
import view.GamePanel;
import view.InventoryPanel;
/**
 *
 * @author cameron
 */
public class DungeonCrawl {
    public static GameData gameData;
    public static Animator animator;
    public static JFrame mainWindow;
    public static InventoryPanel inventoryPanel;
    public static GamePanel gamePanel;
    public static Thread thread;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        animator = new Animator();
        gameData = new GameData();
        gamePanel = new GamePanel(1000, 900);
        inventoryPanel = new InventoryPanel(350, 900);
        
        mainWindow = new MainWindow();
        mainWindow.setTitle("Level 1!");
        mainWindow.setSize(1500, 1000);
        mainWindow.setLocation(0, 0);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
        
        thread = new Thread(animator);
        
        startGame();
    }
    
    public static void startGame(){
        DungeonCrawl.gameData.resetGameData();
        thread.start();
    }
}
