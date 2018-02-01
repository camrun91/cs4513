package view;

import controller.ImageFinder;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.GameData;

public class InventoryPanel extends JPanel
{
    private final JPanel lifePanel, ammoPanel, keyPanel;
    private final JLabel ammoImage, amountOfAmmo, amountOfKeys;
    
    public InventoryPanel()
    {
        this.setLayout(new GridLayout(1, 4));
        
        lifePanel = new JPanel();
        
        ammoPanel = new JPanel();
        ammoPanel.add(new JLabel("Ammo: "));
        ammoImage = new JLabel();
        ammoPanel.add(ammoImage);
        amountOfAmmo = new JLabel();
        ammoPanel.add(amountOfAmmo);
        
        keyPanel = new JPanel();
        keyPanel.add(new JLabel("Keys: "));
        amountOfKeys = new JLabel();
        keyPanel.add(amountOfKeys);
            
        this.add(lifePanel);
        this.add(ammoPanel);
        this.add(keyPanel);
    }
    
    public void updateHeartsAndArrows()
    {
        this.repaint();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D)g;
        
        lifePanel.removeAll();
        lifePanel.add(new JLabel("LIFE: "));
        
        this.paintComponents(graphics);
    }
}
