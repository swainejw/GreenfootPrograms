import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Net extends Actor
{
    int speed = 7;
    
    public void act()
    {
        setLocation(getX() - speed, getY());
        
        if (getX() < 20)
        {
            getWorld().removeObject(this);
            return;
        }
    }
}
