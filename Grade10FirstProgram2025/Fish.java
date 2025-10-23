import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Fish extends Actor
{
    int yMove = 5;
    
    public void act()
    {
        setLocation(getX(), getY() - yMove);
        
        if (getY() < 10 || getY() > 390)
        {
            yMove *= -1;
        }
    }
}
