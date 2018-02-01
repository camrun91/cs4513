package controller;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ImageFinder 
{
    static String imagePath = System.getProperty("user.dir");
    static String separator = System.getProperty("file.separator");
    
    public static Image getImage(String folderName, String imageFileName) 
    {
        String fileName = imagePath + separator + folderName + separator + 
            imageFileName;
        Image image = null;
        
        try 
        {
            image = ImageIO.read(new File(fileName));
        } 
        catch (IOException ioe) 
        {
            System.out.println("Error: Cannot open image:" + fileName);
            JOptionPane.showMessageDialog(null, "Error: Cannot open image:" + 
                fileName);
        }
        
        return image;
    }
}
