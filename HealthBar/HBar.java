import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HBar extends Actor
{
       
    
    public HBar()
    {
        GreenfootImage img = getImage();
        img.scale(100,20);
        img.setColor(new Color(255,0,255));
        img.fill();
        setImage(img);
    }
}
