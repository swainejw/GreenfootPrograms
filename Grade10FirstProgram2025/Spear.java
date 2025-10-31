import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Seaweed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spear extends Actor
{
    public Spear()
    {
        setRotation(45);
    }
    
    public void act()
    {
        setLocation(getX(), getY() + 5);
        
        if (getY() > 390)
        {
            getWorld().removeObject(this);
            return;
        }
        
        BlueKing f = (BlueKing) getOneIntersectingObject(BlueKing.class);
        if (f != null)
        {
            Greenfoot.setWorld(new LoseWorld());
        }
    }
}
