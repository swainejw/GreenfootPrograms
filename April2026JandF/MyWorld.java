import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public static StevieLadders stv = new StevieLadders();
    SimpleTimer t = new SimpleTimer();
    public static Counter score = new Counter();
    int platformOffset = 110;
    int lowLadderY = 525;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1);
        setPaintOrder(Steve.class);

        addObject(stv, 40, getHeight() - 50);
        
        addObject(score, 40, 50);
        score.setValue(0);
        
        // Make a row of bricks (like a platform) at y-coord 30 above the bottom)
        // offset = 25, spacing =  50
        for (int x = 0; x < 15; x++)
        {
            addObject(new Brick(), 25 + x*50, getHeight() - 10);
        }
        
        for (int x = 0; x < 8; x++)
        {
            addObject(new Brick(), 25 + x*50, getHeight() - 10 - platformOffset);
        }
        
        for (int x = 4; x < 15; x++)
        {
            addObject(new Brick(), 25 + x*50, getHeight() - 10 - 2*platformOffset);
        }
        
        for (int x = 0; x < 10; x++)
        {
            addObject(new Brick(), 25 + x*50, getHeight() - 10 - 3*platformOffset);
        }
        
        for (int x = 3; x < 15; x++)
        {
            addObject(new Brick(), 25 + x*50, getHeight() - 10 - 4*platformOffset);
        }
        
        addObject(new Ladder(), 360, lowLadderY);
        addObject(new Ladder(), 240, lowLadderY - platformOffset);
        addObject(new Ladder(), 360, lowLadderY - 2*platformOffset);
        addObject(new Ladder(), 240, lowLadderY - 3*platformOffset);
    }
    
    public void act()
    {
        if (t.millisElapsed() > 4000)
        {
            addObject(new Barrel(), getWidth() - 50, 40);
            t.mark();
        }
    }
}
