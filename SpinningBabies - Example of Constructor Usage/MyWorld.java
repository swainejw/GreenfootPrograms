import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    // Instance Variables //////////////////////////
    SimpleTimer t = new SimpleTimer();
    Label labelOnScreen = new Label("NORMAL MODE", 20);
    int edgeBuffer = 50;
    int r, g, b, counter = 0;
    int step = 20;
    int sMax = 200;
    int colourMax = 255;
    
    // Constructor //////////////////////////
    public MyWorld()
    {    
        super(600, 400, 1, false); 
        addObject(new Baby(2, 1, 5, 2), getRnd(getWidth()), getRnd(getHeight()));
        addObject(new Baby(1, 1), getRnd(getWidth()), getRnd(getHeight()));
        addObject(new Baby(3, 2, 5, 80), getRnd(getWidth()), getRnd(getHeight()));
        addObject(new Baby(4, 2, 5), getRnd(getWidth()), getRnd(getHeight()));
        addObject(labelOnScreen, getWidth()/2, 10);
    }
    
    // Act method (loop)
    public void act()
    {
        if (Greenfoot.isKeyDown("s") && t.millisElapsed() > sMax)
        {
            counter++;       
            t.mark();
        }
        
        if (counter % 2 == 1)
        {
            colourStepping();
        
            GreenfootImage bg = getBackground();
            bg.setColor(new Color(r, g, b));
            bg.fill();
            
            labelOnScreen.setValue("MIND-BLOWING MODE");
        }
        else
        {
            GreenfootImage bg = getBackground();
            bg.setColor(new Color(0, 0, 0));
            bg.fill();
            
            labelOnScreen.setValue("NORMAL MODE");
        }
    }
    
    // User-created methods //////////////////////////
    public int getRnd(int r)
    {
        return edgeBuffer + Greenfoot.getRandomNumber(r - edgeBuffer*2);
    }
    
    public void colourStepping()
    {
        r += step;
        if (r > colourMax) 
        {
            r = 0;
            g += step;
        }
        if (g > colourMax) 
        {
            g = 0;
            b += step;
        }
        if (b > 255) 
        {
            b = 0;
        }
    }
}
