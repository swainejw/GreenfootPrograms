import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Leaf extends Actor
{
    public Leaf()
    {
        getImage().scale(10,10);
    }
    
    public void act()
    {
        setLocation(getX() + 5, getY());
        
        Fish f = (Fish) getOneIntersectingObject(Fish.class);
        if (f != null)
        {
            getWorld().removeObject(f);
            getWorld().removeObject(this);
            return;
        }
        
        if (getX() > 590)
        {
            getWorld().removeObject(this);
            return;
        }
    }
}
