import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LobsterTrap extends Actor
{
    int speed = 3;
    int value = 10;
    private SimpleTimer t = new SimpleTimer();
    
    public LobsterTrap()
    {
    
    }
    
    // this is how you make lobster traps go at diff't speeds
    public LobsterTrap(int s)
    {
        speed = s;
    }
    
    public void act()
    {
        setLocation(getX(), getY() - speed);
        if (getY() < 35 || getY() > getWorld().getHeight() - 35 )
        {
            speed *= -1;
        }
        
        if (t.millisElapsed() > 250)
        {
            getWorld().addObject(new Net(), getX(), getY());
            t.mark();
        }
    }
}
