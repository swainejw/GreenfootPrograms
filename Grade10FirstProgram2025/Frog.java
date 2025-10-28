import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Frog extends Actor
{
    SimpleTimer t = new SimpleTimer();

    public void act()
    {
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 5, getY());
        }
        if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 5, getY());
        }
        if (Greenfoot.isKeyDown("space") && t.millisElapsed() > 1000)
        {
            getWorld().addObject(new Leaf(), getX(), getY());
            t.mark();
        }
    }
}
