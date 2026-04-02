import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LobsterTrap extends Actor
{
    int speed = 3;
    int value = 10;
    
    public void act()
    {
        setLocation(getX(), getY() - speed);
        if (getY() < 35 || getY() > getWorld().getHeight() - 35 )
        {
            speed *= -1;
        }
    }
}
