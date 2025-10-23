import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Leaf extends Actor
{
    public void act()
    {
        setLocation(getX() + 5, getY());
        
        if (getX() > 590)
        {
            getWorld().removeObject(this);
        }
    }
}
