import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lobster extends Actor
{
    int speed = 7;
    private SimpleTimer t = new SimpleTimer();
    
    public void act()
    {
        if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY() + speed);
        }
        if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY() - speed);
        }
        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - speed, getY());
        }
        if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + speed, getY());
        }

        if (Greenfoot.isKeyDown("space") && t.millisElapsed() > 250)
        {
            getWorld().addObject(new Rock(), getX(), getY());
            t.mark();
        }
    }
}
