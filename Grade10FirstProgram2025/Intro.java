import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Intro extends World
{
    /**
     * Constructor for objects of class Intro.
     * 
     */
    public Intro()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        // puts the banner in the middle
        addObject(new CRBanner(), getWidth()/2, getHeight()/2);
    }
    
    public void act()
    {
        // if click or press space, game starts
        if (Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
