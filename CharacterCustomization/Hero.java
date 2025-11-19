import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Hero extends Actor
{
    GreenfootImage i1 = new GreenfootImage("mario-removebg-preview.png");
    GreenfootImage i2 = new GreenfootImage("luigi-removebg-preview.png");
    GreenfootImage i3 = new GreenfootImage("peach-removebg-preview.png");
    GreenfootImage i4 = new GreenfootImage("toad-removebg-preview.png");
    
    public Hero()
    {
        setImage(i1);
    }
    
    public void act() 
    {
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 5, getY());
        }
        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + 5);
        }
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 5, getY());
        }
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - 5);
        }
    }    
    
    public void changeImage(int x)
    {
        if (x == 1)
        {
            setImage(i1);
        }
        else if (x == 2)
        {
            setImage(i2);
        }
        else if (x == 3)
        {
            setImage(i3);
        }
        else if (x == 4)
        {
            setImage(i4);
        }
    }
    
}
