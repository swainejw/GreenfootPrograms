import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld2 extends World
{
    public static Steve2 stv = new Steve2();
    SimpleTimer t = new SimpleTimer();
    public static Counter score = new Counter();
    
    public MyWorld2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        addObject(stv, 40, getHeight() - 50);
        addObject(score, 40, 50);
        score.setValue(0);
        // Make a row of bricks (like a platform) at y-coord 30 above the bottom)
        // offset = 25, spacing =  50
        for (int x = 0; x < 15; x++)
        {
            addObject(new Brick(), 25 + x*50, getHeight() - 10);
        }
      
    }
    
    public void act()
    {
        if (t.millisElapsed() > 4000)
        {
            addObject(new Barrel(), getWidth() - 50, 340);
            t.mark();
        }
    }
}
