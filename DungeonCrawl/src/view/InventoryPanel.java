package view;

import controller.ImageFinder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import model.GameData;
import static model.GameData.gamerInventory;
import model.GameObject;
import model.Immoveable.Collectible.Boot;
import model.Immoveable.Collectible.Key;

public class InventoryPanel extends JPanel
{
    private JTextField txtChipsLeft, txtLevel, txtTime;
    private JPanel bootPanel, keyPanel;
    private JLabel lblChipsLeft, lblLevel, lblTime;
    private JLabel lblBoots, lblSuctionBoot, lblIceBoot, lblFireBoot, lblFlipperBoot;
    private JLabel lblKeys, lblBlueKey, lblRedKey, lblYellowKey, lblGreenKey;
    
    public static int pwidth, pheight;
    
    public InventoryPanel(int pwidth, int pheight)
    {
        InventoryPanel.pwidth = pwidth;
        InventoryPanel.pheight = pheight;
        
        initComponents();
    }
    
    public void updateInventoryPanel()
    {
        this.txtTime.setText(String.valueOf(GameData.time));
        this.txtLevel.setText(String.valueOf(GameData.currentLevel.getLevelValue()));
        this.txtChipsLeft.setText(String.valueOf(GameData.chipsLeft));
        
        int bKey = 0, gKey = 0, rKey = 0, yKey = 0,
            fireBoot = 0, forceBoot = 0, iceBoot = 0, waterBoot = 0;
        
        for(GameObject object : gamerInventory){
            if(object.getClass() == Key.class){
                switch(((Key)object).type){
                    case BLUE:
                        bKey++;
                        break;
                    case GREEN:
                        gKey++;
                        break;
                    case RED:
                        rKey++;
                        break;
                    case YELLOW:
                        yKey++;
                        break;
                }
            }
            else if(object.getClass() == Boot.class){
                switch(((Boot)object).type){
                    case FIRE:
                        fireBoot++;
                        break;
                    case FORCE:
                        forceBoot++;
                        break;
                    case ICE:
                        iceBoot++;
                        break;
                    case WATER:
                        waterBoot++;
                        break;
                }
            }
        }
        setBlueKey(bKey > 0);
        setGreenKey(gKey > 0);
        setRedKey(rKey > 0);
        setYellowKey(yKey > 0);
        setFireBoot(fireBoot > 0);
        setSuctionBoot(forceBoot > 0);
        setIceBoot(iceBoot > 0);
        setFlipperBoot(waterBoot > 0);
    }
    
    private void initComponents(){
        setPreferredSize(new Dimension(InventoryPanel.pwidth, InventoryPanel.pheight));
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 20));
        
        // Level label and text field
        lblLevel = new JLabel("LEVEL");
        lblLevel.setFont(new Font("Tahoma", 0, 36)); // NOI18N
        lblLevel.setForeground(new Color(255, 0, 0));
        
        txtLevel = new JTextField(String.valueOf(GameData.currentLevel.getLevelValue()));
        txtLevel.setFont(new Font("Tahoma", 0, 36));
        txtLevel.setHorizontalAlignment(JTextField.CENTER);
        txtLevel.setEditable(false);
        txtLevel.setFocusable(false);
        
        // Time label and text field
        lblTime = new JLabel("TIME (s)");
        lblTime.setFont(new Font("Tahoma", 0, 36)); // NOI18N
        lblTime.setForeground(new Color(255, 0, 0));
        lblTime.setText("TIME (s)");
        
        txtTime = new JTextField(String.valueOf(GameData.currentLevel.getLevelTime()));
        txtTime.setFont(new Font("Tahoma", 0, 36));
        txtTime.setHorizontalAlignment(JTextField.CENTER);
        txtTime.setEditable(false);
        txtTime.setFocusable(false);
        
        lblChipsLeft = new JLabel("CHIPS LEFT");
        lblChipsLeft.setFont(new Font("Tahoma", 0, 36)); // NOI18N
        lblChipsLeft.setForeground(new Color(255, 0, 0));
        
        txtChipsLeft = new JTextField(String.valueOf(GameData.chipsLeft));
        txtChipsLeft.setText(String.valueOf(GameData.chipsLeft));
        txtChipsLeft.setFont(new Font("Tahoma", 0, 36));
        txtChipsLeft.setHorizontalAlignment(JTextField.CENTER);
        txtChipsLeft.setEditable(false);
        txtChipsLeft.setFocusable(false);

        // Boots label
        lblBoots = new JLabel("BOOTS");
        lblBoots.setFont(new Font("Tahoma", 0, 36));
        lblBoots.setForeground(new Color(255, 0, 0));
        
        //Boot panel
        bootPanel = new JPanel(new GridLayout(1, 4));
        
        lblIceBoot = new JLabel();
        lblIceBoot.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        lblFireBoot = new JLabel();
        lblFireBoot.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        lblSuctionBoot = new JLabel();
        lblSuctionBoot.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        lblFlipperBoot = new JLabel();
        lblFlipperBoot.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        bootPanel.add(lblIceBoot);
        bootPanel.add(lblFireBoot);
        bootPanel.add(lblSuctionBoot);
        bootPanel.add(lblFlipperBoot);
        
        // Keys label
        lblKeys = new JLabel("KEYS");
        lblKeys.setFont(new Font("Tahoma", 0, 36));
        lblKeys.setForeground(new Color(255, 0, 0));
        
        //Key panel
        keyPanel = new JPanel(new GridLayout(1, 4));
        
        lblBlueKey = new JLabel(new ImageIcon());
        lblBlueKey.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        lblRedKey = new JLabel(new ImageIcon());
        lblRedKey.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        lblYellowKey = new JLabel(new ImageIcon());
        lblYellowKey.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        lblGreenKey = new JLabel(new ImageIcon());
        lblGreenKey.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        keyPanel.add(lblBlueKey);
        keyPanel.add(lblRedKey);
        keyPanel.add(lblYellowKey);
        keyPanel.add(lblGreenKey);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblTime, GroupLayout.Alignment.LEADING)
                            .addComponent(txtTime, GroupLayout.Alignment.LEADING)
                            .addComponent(lblLevel, GroupLayout.Alignment.LEADING)
                            .addComponent(txtLevel, GroupLayout.Alignment.LEADING)
                            .addComponent(lblChipsLeft, GroupLayout.Alignment.LEADING)
                            .addComponent(txtChipsLeft, GroupLayout.Alignment.LEADING)
                            .addComponent(lblBoots, GroupLayout.Alignment.LEADING)
                            .addComponent(bootPanel)
                            .addComponent(lblKeys, GroupLayout.Alignment.LEADING)
                            .addComponent(keyPanel))))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblLevel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLevel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTime)
                .addComponent(txtTime, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblChipsLeft)
                .addComponent(txtChipsLeft, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblBoots)
                .addComponent(bootPanel)
                .addComponent(lblKeys)
                .addComponent(keyPanel)
                .addContainerGap(166, Short.MAX_VALUE))
        );
    }
    
    public void setIceBoot(boolean enabled){
        if(enabled){
            lblIceBoot.setIcon(new ImageIcon(ImageFinder.getImage("ImagesFolder", "Ice_Skates.png")));
        }
        else{
            lblIceBoot.setIcon(null);
        }
    }
    
    public void setFireBoot(boolean enabled){
        if(enabled){
            lblFireBoot.setIcon(new ImageIcon(ImageFinder.getImage("ImagesFolder", "Fire_Boots.png")));
        }
        else{
            lblFireBoot.setIcon(null);
        }
    }
    
    public void setSuctionBoot(boolean enabled){
        if(enabled){
            lblSuctionBoot.setIcon(new ImageIcon(ImageFinder.getImage("ImagesFolder", "Suction_Boots.png")));
        }
        else{
            lblSuctionBoot.setIcon(null);
        }
    }
    
    public void setFlipperBoot(boolean enabled){
        if(enabled){
            lblFlipperBoot.setIcon(new ImageIcon(ImageFinder.getImage("ImagesFolder", "Flippers.png")));
        }
        else{
            lblFlipperBoot.setIcon(null);
        }
    }
    
    public void setBlueKey(boolean enabled){
        if(enabled){
            lblBlueKey.setIcon(new ImageIcon(ImageFinder.getImage("ImagesFolder", "Blue_Key.png")));
        }
        else{
            lblBlueKey.setIcon(null);
        }
    }
    
    public void setRedKey(boolean enabled){
        if(enabled){
            lblRedKey.setIcon(new ImageIcon(ImageFinder.getImage("ImagesFolder", "Red_Key.png")));
        }
        else{
            lblRedKey.setIcon(null);
        }
    }
    
    public void setYellowKey(boolean enabled){
        if(enabled){
            lblYellowKey.setIcon(new ImageIcon(ImageFinder.getImage("ImagesFolder", "Yellow_Key.png")));
        }
        else{
            lblYellowKey.setIcon(null);
        }
    }
    
    public void setGreenKey(boolean enabled){
        if(enabled){
            lblGreenKey.setIcon(new ImageIcon(ImageFinder.getImage("ImagesFolder", "Green_Key.png")));
        }
        else{
            lblGreenKey.setIcon(null);
        }
    }
}