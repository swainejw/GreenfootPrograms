import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class MyWorld extends World
{
    int numSpearGoblin = 5;
    public static Counter score = new Counter();
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        addObject(score, 70, getHeight()-17);
        score.setValue(0);
        addObject(new BlueKing(), 300, getHeight()-45);
        
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
    
    }
}
