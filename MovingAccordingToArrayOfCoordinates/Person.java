import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Person extends Actor
{
    int[] xCoords = {575, 525, 475, 425};
    int[] yCoords = {350, 275, 200, 125};
    int val = 1;
    SimpleTimer t = new SimpleTimer();
    
    public void act()
    {
        if (t.millisElapsed() > 400)
        {
            //System.out.println(val + " x:" + xCoords[val] + " y:" + yCoords[val]);
            if (Greenfoot.isKeyDown("up"))
            {
                val++;
                if (val == 4)
                {
                    val = 3;
                }
                t.mark();
            }
            else if (Greenfoot.isKeyDown("down"))
            {
                val--;
                if (val == -1)
                {
                    val = 0;
                }
                t.mark();
            }
            setLocation(xCoords[val], yCoords[val]);
            
        }
    }
}
