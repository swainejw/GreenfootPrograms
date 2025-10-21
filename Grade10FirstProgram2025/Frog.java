import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Frog extends Actor
{
    public void act()
    {
        if (Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY() + 5);
        }
        if (Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY() - 5);
        }
        if (Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - 5, getY());
        }
        if (Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + 5, getY());
        }
        if (Greenfoot.isKeyDown("space"))
        {
            getWorld().addObject(new Leaf(), getX(), getY());
        }
    }
}
