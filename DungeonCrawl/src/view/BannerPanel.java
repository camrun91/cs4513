package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.GameData;

public class BannerPanel extends JPanel {

    private JTextField txtLevel;
    private JLabel lblSubMessage, lblSkipCode;

    public static int pwidth, pheight;

    private String bannerText, skipText;

    public BannerPanel(int pwidth, int pheight) {
        BannerPanel.pwidth = pwidth;
        BannerPanel.pheight = pheight;
        
        initComponents();
    }

    private void initComponents() {
        setPreferredSize(new Dimension(BannerPanel.pwidth, BannerPanel.pheight));
        setBorder(BorderFactory.createLineBorder(Color.gray, 20));
        // Could be moved to class where level attributes are tracked
        bannerText = "Welcome to Level " + String.valueOf(GameData.currentLevel.getLevelValue());
        skipText = "Skip code is sklv" + String.valueOf(GameData.currentLevel.getLevelValue());
        JPanel MessagePanel = new JPanel(new BorderLayout());
        txtLevel = new JTextField(bannerText);
        txtLevel.setFont(new Font("Tahoma", 0, 36));
        txtLevel.setHorizontalAlignment(JTextField.CENTER);
        txtLevel.setEditable(false);
        txtLevel.setFocusable(false);

        lblSubMessage = new JLabel("Press spacebar to continue", JLabel.CENTER);
        lblSkipCode = new JLabel(skipText, JLabel.CENTER);
        MessagePanel.add(txtLevel,BorderLayout.CENTER);
        MessagePanel.add(lblSkipCode, BorderLayout.SOUTH);
        this.setLayout(new BorderLayout());
        this.add(MessagePanel, BorderLayout.CENTER);
        //this.add(lblSkipCode, BorderLayout.NORTH);
        this.add(lblSubMessage, BorderLayout.SOUTH);
        this.setFocusable(false);
    }

    public void setBannerText(String newBannerText) {
        this.bannerText = newBannerText;
        txtLevel.setText(this.bannerText);
    }
}
