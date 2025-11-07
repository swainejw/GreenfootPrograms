import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    BG1942 bg = new BG1942();
    int bgMove = 67;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        addObject(bg, getWidth()/2, -6000);
        addObject(new Rocket(), getWidth()/2, 350);
    }
    
    public void act()
    {
        bg.setLocation(bg.getX(), bg.getY() + bgMove);
        //System.out.println(bg.getY());
    }
}
