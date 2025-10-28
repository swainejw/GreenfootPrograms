import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class MyWorld extends World
{
    int numFish = 5;
    public static Counter score = new Counter();
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(score, 70, 383);
        score.setValue(0);
        addObject(new Frog(), 300, 365);
        
        for (int x = 0; x < numFish; x++)
        {
            // 67 is init value, 120 is spacing
            addObject(new Fish(), 67 + x*120, 35);
        }
        
    }
}
