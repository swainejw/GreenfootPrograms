import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public static StevieLadders stv = new StevieLadders();
    Spider sp = new Spider();
    
    SimpleTimer t = new SimpleTimer();
    SimpleTimer t2 = new SimpleTimer();
    
    public static Counter cScore = new Counter();
    public static Counter2 cTime = new Counter2();
    public static Counter cLives = new Counter();
    
    Ladder trickLadder = new Ladder();
    
    int platformOffset = 110;
    int lowLadderY = 525;
    int count = 0;
    int counterHeight = 15;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1);

        addObject(stv, 30, getHeight() - 40);
        
        addObject(cScore, 80, counterHeight);
        cScore.setValue(0);
        
        addObject(cLives, 20, counterHeight);
        cLives.setValue(3);
        
        addObject(cTime, getWidth()/2, counterHeight);
        cTime.setValue(50);
        
        count = 0;
        
        addObject(sp, getWidth() - 50, 50);
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
        addObject(trickLadder, 360, lowLadderY - 2*platformOffset);
        addObject(new Ladder(), 240, lowLadderY - 3*platformOffset);
    }
    
    public void act()
    {
        if (t.millisElapsed() > 4000)
        {
            addObject(new Barrel(), getWidth() - 50, 40);
            t.mark();
            count++;
            if (count % 2 == 0)
            {
                addObject(trickLadder, 360, lowLadderY - 2*platformOffset);
            }
            else
            {
                removeObject(trickLadder);
            }
            
        }
        
        if (t2.millisElapsed() > 1000)
        {
            cTime.add(-1);
            t2.mark();
        }
    }
}
