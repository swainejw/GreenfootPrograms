import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public static Counter c = new Counter();
    public static Label l = new Label("", 24);
            
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new SaveScore(), getWidth()/2 - 50, 175);
        addObject(new Label("Save Score", 24), getWidth()/2 + 80, 175);
        
        addObject(new ShowHS(), getWidth()/2 - 50, 250);
        addObject(new Label("Show High Score", 24), getWidth()/2 + 80, 250);
        
        addObject(new PressMe(), getWidth()/2 - 50, 100);
        addObject(new Label("Increase Score", 24), getWidth()/2 + 80, 100);
        
        addObject(new ShowXScores(), getWidth()/2 - 50, 325);
        addObject(new Label("Top X Scores", 24), getWidth()/2 + 80, 325);
        
        addObject(new KillScores(), getWidth() - 60, 40);
        addObject(new Label("Delete All Scores", 14), getWidth() - 60, 20);
        
        addObject(new ShowAllScores(), 60, 355);
        addObject(new Label("Show All Scores", 14), 60, 320);
        
        addObject(c, 50, 20);
        addObject(l, 80, 175);
        c.setValue(0);
    }
}
