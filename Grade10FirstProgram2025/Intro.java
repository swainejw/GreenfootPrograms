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
        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        addObject(new CRBanner(), getWidth()/2, getHeight()/2);
    }
    
    public void act()
    {
        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        if (Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
