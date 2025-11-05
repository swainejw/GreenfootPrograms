import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class MyWorld extends World
{
    // ADD A COMMENT HERE TO EXPLAIN THESE VARIABLES
    int numSpearGoblin = 5;
    public static Counter score = new Counter();
    public static Counter lives = new Counter();
    SimpleTimer tBowler = new SimpleTimer();
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        
        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        addObject(score, 70, getHeight()-17);
        score.setValue(0);
        addObject(lives, 530, getHeight()-17);
        lives.setValue(10);
        addObject(new BlueKing(), 300, getHeight()-45);
        
        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        for (int x = 0; x < numSpearGoblin; x++)
        {
            // 67 is init value, 120 is spacing
            addObject(new SpearGoblin(), 67 + x*120, 115);
        }
        
        for (int x = 0; x < numSpearGoblin; x++)
        {
            // 67 is init value, 120 is spacing
            addObject(new MiniPekka(), 67 + x*120, 45);
        }
        
    }
    
    public void act()
    {
        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        if (tBowler.millisElapsed() > 2000)
        {
            addObject(new Bowler(), 15, getWidth()/2);
            tBowler.mark();
        }
        
        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        List allSpearGoblins = getObjects(SpearGoblin.class);
        List allMiniPekkas = getObjects(MiniPekka.class);
        if (allSpearGoblins.size() + allMiniPekkas.size() == 0)
        {
            Greenfoot.setWorld(new WinWorld());
        }
    }
}
