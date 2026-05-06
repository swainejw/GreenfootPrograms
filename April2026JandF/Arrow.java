import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Actor
{
    int speed;
    
    public Arrow(int d)
    {
        speed = d;
        if (d == -10)
        {
            getImage().rotate(180);
        }
    }
    
    public void act()
    {
        setLocation(getX() + speed, getY());
        if (getX() > getWorld().getWidth()-10 || getX() < 5)
        {
            getWorld().removeObject(this);
            return;
        }
        
        Spider sp = (Spider) getOneIntersectingObject(Spider.class);
        if (sp != null && getY() < 100)
        {
            sp.health--;
            if (sp.health == 0)
            {
                Greenfoot.setWorld(new WinWorld());
            }
            getWorld().removeObject(this);
            return;
        }
        
    }
}
