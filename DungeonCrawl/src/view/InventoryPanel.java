package view;

import controller.ImageFinder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import model.GameData;

public class InventoryPanel extends JPanel
{
//    private final JPanel lifePanel, ammoPanel, keyPanel;
//    private final JLabel ammoImage, amountOfAmmo, amountOfKeys;
    private JLabel lblChipsLeft;
    private JLabel lblLevel;
    private JLabel lblTime;
    private JTextField txtChipsLeft;
    private JTextField txtLevel;
    private JTextField txtTime;
    
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
        this.txtLevel.setText(GameData.level);
        this.txtChipsLeft.setText(GameData.chipsLeft);
    }
    
    private void initComponents(){
        lblLevel = new JLabel();
        lblTime = new JLabel();
        lblChipsLeft = new JLabel();
        txtTime = new JTextField();
        txtChipsLeft = new JTextField();
        txtLevel = new JTextField();
        
        setPreferredSize(new Dimension(InventoryPanel.pwidth, InventoryPanel.pheight));
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 20));

        lblLevel.setFont(new Font("Tahoma", 0, 36)); // NOI18N
        lblLevel.setForeground(new Color(255, 0, 0));
        lblLevel.setText("LEVEL");

        lblTime.setFont(new Font("Tahoma", 0, 36)); // NOI18N
        lblTime.setForeground(new Color(255, 0, 0));
        lblTime.setText("TIME");

        lblChipsLeft.setFont(new Font("Tahoma", 0, 36)); // NOI18N
        lblChipsLeft.setForeground(new Color(255, 0, 0));
        lblChipsLeft.setText("CHIPS LEFT");

        txtTime.setText(GameData.level);
        txtTime.setFont(new Font("Tahoma", 0, 36));
        txtTime.setHorizontalAlignment(JTextField.CENTER);
        txtTime.setEditable(false);

        txtChipsLeft.setText(GameData.chipsLeft);
        txtChipsLeft.setFont(new Font("Tahoma", 0, 36));
        txtChipsLeft.setHorizontalAlignment(JTextField.CENTER);
        txtChipsLeft.setEditable(false);

        txtLevel.setText(String.valueOf(GameData.time));
        txtLevel.setFont(new Font("Tahoma", 0, 36));
        txtLevel.setHorizontalAlignment(JTextField.CENTER);
        txtLevel.setEditable(false);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTime, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(txtLevel, GroupLayout.Alignment.LEADING)
                            .addComponent(lblLevel, GroupLayout.Alignment.LEADING)
                            .addComponent(lblTime, GroupLayout.Alignment.LEADING)
                            .addComponent(txtChipsLeft, GroupLayout.Alignment.LEADING)
                            .addComponent(lblChipsLeft, GroupLayout.Alignment.LEADING))))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblLevel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLevel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTime)
                .addGap(10, 10, 10)
                .addComponent(txtTime, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblChipsLeft)
                .addGap(13, 13, 13)
                .addComponent(txtChipsLeft, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );
    }
    
//    @Override
//    public void paintComponent(Graphics g)
//    {
//        super.paintComponent(g);
//        Graphics2D graphics = (Graphics2D)g;
//        
//        this.paintComponents(graphics);
//        this.repaint();
//    }
}
