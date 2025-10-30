import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static Counter c = new Counter();
    public static HBar hb = new HBar();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(hb, 70, 30);
        addObject(c, 550, 30);
        c.setValue(3);
        hb.getImage().scale(100, 20);
        addObject(new Portal(), 300, 300);
        addObject(new Hero(), 100, 300);
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            GreenfootImage img = hb.getImage();
            int oldWidth = img.getWidth();
            int newWidth = oldWidth - 10; // example shrink

            int x = hb.getX();
            int leftEdge = x - oldWidth / 2; // find left edge before scaling

            img.scale(newWidth, img.getHeight());
            hb.setImage(img);

            int newX = leftEdge + newWidth / 2; // move actor so left edge stays fixed
            hb.setLocation(newX, hb.getY());
        }

    }
}
