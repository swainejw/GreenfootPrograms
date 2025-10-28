import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Seaweed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Seaweed extends Actor
{
    /**
     * Act - do whatever the Seaweed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY() + 5);
        
        if (getY() > 390)
        {
            getWorld().removeObject(this);
            return;
        }
        
        Frog f = (Frog) getOneIntersectingObject(Frog.class);
        if (f != null)
        {
            getWorld().removeObject(f);
            getWorld().removeObject(this);
            return;
        }
    }
}
