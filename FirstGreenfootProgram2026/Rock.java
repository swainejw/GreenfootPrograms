import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Rock extends Actor
{
    int speed = 15;
    
    public Rock()
    {
        getImage().scale(85, 15);
    }
    
    public void act()
    {
        setLocation(getX() + speed, getY());
        
        if (getX() > 595)
        {
            getWorld().removeObject(this);
        }
    }
}
