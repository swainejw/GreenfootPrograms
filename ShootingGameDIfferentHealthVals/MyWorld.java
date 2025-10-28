import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends greenfoot.World
{
    // This line creates the counter and names it "score"
    public static Counter score = new Counter();
    // This line creates a new timer - only in memory - and names it shotTimer
    // Notice that I don't have to put it on the screen (using addObject) because it's not
    // something that needs to be seen on the screen.  It just ticks in the background.
    
    public static SimpleTimer shotTimer = new SimpleTimer();
    //public static GreenfootSound s = new GreenfootSound("filename.mp3");
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        final int numEnemies = 10;
        
        addObject(new Hero(), getWidth()/2, getHeight() - 50);
        
        for (int x = 0; x < numEnemies/2; x++)
        {
            if (Greenfoot.getRandomNumber(2) == 0)
            {
                addObject(new Enemy(), 40, Greenfoot.getRandomNumber(400));
            }
            else
            {
                addObject(new Enemy2(1), 40, Greenfoot.getRandomNumber(400));
            }
        }
        
        for (int x = 0; x < numEnemies/2; x++)
        {
            if (Greenfoot.getRandomNumber(2) == 0)
            {
                addObject(new Enemy(), 560, Greenfoot.getRandomNumber(400));
            }
            else
            {
                addObject(new Enemy2(1), 560, Greenfoot.getRandomNumber(400));
            }
        }
        
        // puts the counter on the screen
        addObject(score, 50, 380);
        // score resets
        score.setValue(0);
        // resets the timer (it will count in milliseconds)
        shotTimer.mark();
        
    }
    
    
}
