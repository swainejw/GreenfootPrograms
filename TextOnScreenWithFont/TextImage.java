import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextImage extends Actor
{
    /**
     * Act - do whatever the Test wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TextImage(String text, String font)
    {
        // Create a new image to draw on
        GreenfootImage img = new GreenfootImage(400, 100);

        // Use Greenfoot’s own Font class
        greenfoot.Font f = new greenfoot.Font(font, true, false, 36); 
        // ("FontName", bold?, italic?, size)

        
        img.setFont(f);
        img.setColor(new Color(255, 255, 255));
        img.drawString(text, 10, 50);

        setImage(img);
    }

}

