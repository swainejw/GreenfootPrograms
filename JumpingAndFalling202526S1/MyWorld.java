import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public static Mario mar = new Mario();
    public static Counter score = new Counter();
    public static Counter2 lives = new Counter2();
    final int BARREL_INTERVAL = 4000;
    int brickWidth = 60;
    SimpleTimer t = new SimpleTimer();
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1, false);
        
        addObject(mar, getWidth() - 30, 452);  
        mar.brlsJumped = 0;
        addObject(score, 30, 20);
        score.setValue(0);
        addObject(lives, 75, 20); 
        lives.setValue(3);
        
        for (int x = 0; x < 11; x++)
        {
            addObject(new Brick(), x*brickWidth, getHeight() - 20);
        }
        
        for (int x = 0; x < 4; x++)
        {
            addObject(new Brick(), x*brickWidth, getHeight() - 120);
        }
        for (int x = 7; x < 11; x++)
        {
            addObject(new Brick(), x*brickWidth, getHeight() - 120);
        }
    
        for (int x = 0; x < 9; x++)
        {
            addObject(new Brick(), x*brickWidth, getHeight() - 220);
        }
        
        for (int x = 3; x < 11; x++)
        {
            addObject(new Brick(), x*brickWidth, getHeight() - 320);
        }
    
        for (int x = 0; x < 9; x++)
        {
            addObject(new Brick(), x*brickWidth, getHeight() - 420);
        }
    }
    
    public void act()
    {
        if (t.millisElapsed() > BARREL_INTERVAL)
        {
            addObject(new Barrel(), 10, 0);
            t.mark();
        }
    }
}
