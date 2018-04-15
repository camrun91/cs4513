package DungeonCrawl;
import controller.Animator;
import javax.swing.JFrame;
import model.GameData;
import view.MainWindow;
import view.GamePanel;
import view.InventoryPanel;
import view.BannerPanel;
import view.MenuPanel;
import view.Menu;

public class DungeonCrawl {
    public static GameData gameData;
    public static Animator animator;
    public static JFrame mainWindow;
    public static InventoryPanel inventoryPanel;
    public static GamePanel gamePanel;
    public static BannerPanel bannerPanel;
    public static Thread thread;
    public static Menu menuPanel;

    public static void main(String[] args) {
        animator = new Animator();
        gameData = new GameData();
        gamePanel = new GamePanel(1000, 900);
        inventoryPanel = new InventoryPanel(350, 900);
        bannerPanel =  new BannerPanel(650, 300);
        menuPanel = new Menu();
        menuPanel.setVisible(false);
        
        mainWindow = new MainWindow();
        mainWindow.setTitle("Dungeon Crawl!");
        mainWindow.setSize(1500, 1000);
        mainWindow.setLocation(0, 0);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
        
       thread = new Thread(animator);
    }
    
    public static void startGame(){         
        GameData.resetGameData();
        thread.start();
    }
}
