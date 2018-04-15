
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.GameData;

public class MenuPanel extends JPanel{
    private JTextField txtLevel;
    private JLabel lblSubMessage;
    private JButton skipButton;
    private JTextField txtHeader;
    
    public static int pwidth, pheight;
    
    private String menuText;
    private String restartText;
    private String headerText;

 public MenuPanel(int pwidth, int pheight)
    {
        MenuPanel.pwidth = pwidth;
        MenuPanel.pheight = pheight;
        
        initComponents();
    }
 
 private void initComponents(){
        setPreferredSize(new Dimension(MenuPanel.pwidth, MenuPanel.pheight));
        setBorder(BorderFactory.createLineBorder(Color.gray, 20));
        // Could be moved to class where level attributes are tracked
        /*
        menuText = "Main menu Options coming soon" ;
        txtLevel = new JTextField(menuText);
        txtLevel.setFont(new Font("Tahoma", 0, 36));
        txtLevel.setHorizontalAlignment(JTextField.CENTER);
        txtLevel.setEditable(false);
        txtLevel.setFocusable(false);
        */
        skipButton = new JButton("Skip Level");
        headerText = "The game is Paused you may restart or skip a level";
        
        txtHeader = new JTextField(headerText);
        txtHeader.setHorizontalAlignment(JTextField.CENTER);
        
        restartText = "Press \"R\" to restart game";
        txtLevel = new JTextField(restartText);
        txtLevel.setFont(new Font("Tahoma", 0, 36));
        txtLevel.setHorizontalAlignment(JTextField.CENTER);
        txtLevel.setEditable(false);
        txtLevel.setFocusable(false);
        
        lblSubMessage = new JLabel("Press spacebar to continue", JLabel.CENTER);
        
        this.setLayout(new BorderLayout());
        this.add(txtHeader, BorderLayout.NORTH);
        this.add(txtLevel, BorderLayout.CENTER); 
        this.add(skipButton, BorderLayout.LINE_START);
        this.add(lblSubMessage, BorderLayout.SOUTH);
        this.setFocusable(false);
    }
 
 public void setMenuText(String newmenuText){
        this.restartText = newmenuText;
        txtLevel.setText(this.restartText);
    }
}