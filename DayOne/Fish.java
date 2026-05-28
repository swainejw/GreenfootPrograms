import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Fish extends Actor
{
    public void act()
    {
        setLocation(getX() + 15, getY());
        
        Camel c = (Camel) getOneIntersectingObject(Camel.class);
        if (c != null)
        {
            getWorld().removeObject(c);
        }
    }
}
