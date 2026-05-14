import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.io.*;

public class SaveToFile extends Actor 
{
    SimpleTimer t = new SimpleTimer();
    boolean showing = false;
    int score = 100;
    
    public void act()
    {
        try
        {
            if (Greenfoot.mouseClicked(this))
            {
                FileWriter fw = new FileWriter(new File("scores.txt"), true);
                fw.write(score + "\n");
                fw.close();
                
                getWorld().showText("Added", 300, 300);
                t.mark();
                showing = true;
            }
            
            if (showing && t.millisElapsed() > 1000)
            {
                getWorld().showText("", 300, 300);
                showing = true;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
