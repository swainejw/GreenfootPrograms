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
    
        addObject(score, 30, 20);
        score.setValue(0);
        addObject(lives, 75, 20); 
        lives.setValue(3);
        
        // Platforms
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
        
        // Place ladders and special bricks that Mario can't go through at 
        // the bottom of each ladder
        addObject(new Ladder(), 446, 418);
        addObject(new BottomLadderBrick(), 446, getHeight() - 20);
        addObject(new Ladder(), 446, 118);
        addObject(new BottomLadderBrick(), 446, getHeight() - 320);
        addObject(new Ladder(), 126, 318);
        addObject(new BottomLadderBrick(), 126, getHeight() - 120);
        addObject(new Ladder(), 226, 218);
        addObject(new BottomLadderBrick(), 226, getHeight() - 220);
        
        // reset Mario
        addObject(mar, getWidth() - 30, 452);  
        mar.brlsJumped = 0;
    }
    
    public void act()
    {
        // spawning barrels
        if (t.millisElapsed() > BARREL_INTERVAL)
        {
            addObject(new Barrel(), 10, 0);
            t.mark();
        }
    }
}
