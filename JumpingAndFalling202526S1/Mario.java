import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Mario extends Actor
{
    int vAcc = 0;
    
    public Mario()
    {
        getImage().scale(30, 45);
    }
    
    public void act()
    {
        setLocation(getX(), getY() + vAcc);
        
        if (Greenfoot.isKeyDown("space"))
        {
            vAcc = -15;
        }
        
        vAcc++;
    }
    
    
}
