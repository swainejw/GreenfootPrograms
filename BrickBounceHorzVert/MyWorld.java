import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static Counter numBricks = new Counter("Bricks:");
    SimpleTimer t = new SimpleTimer();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Ball(), 300, 350);
        
        addObject(new Brick(), 300, 50);
        addObject(new Brick(), 400, 250);
        addObject(new Brick(), 200, 200);
        addObject(new Brick(), 50, 50);
        addObject(new Brick(), 230, 150);
        addObject(new Brick(), 530, 40);
        addObject(new Ball(), 100, 350);
        addObject(new Brick(), 140, 50);
        addObject(new Brick(), 450, 250);
        addObject(new Brick(), 60, 200);
        addObject(new Brick(), 490, 380);
        addObject(new Brick(), 230, 300);
        addObject(new Brick(), 530, 250);
        addObject(numBricks, 50, 380);
        numBricks.setValue(0);
    }
    
    public void act()
    {
        if (t.millisElapsed() > 8000)
        {
            addObject(new Ball(), 286, 350);
            t.mark();
        }
    }
    
}
