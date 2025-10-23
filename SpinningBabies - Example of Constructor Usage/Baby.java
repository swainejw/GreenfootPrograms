import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Baby extends Actor
{
    // instance variables ///////////////////////////////////
    int direction = 0;
    int picID = 0;
    int speed = 0;
    int hSpeed = 0;
    int vSpeed = 0;
    int turnVal = 10;
    
    GreenfootImage b1 = new GreenfootImage("baby1.png");
    GreenfootImage b2 = new GreenfootImage("baby2.png");
    GreenfootImage b3 = new GreenfootImage("baby3.png");
    GreenfootImage b4 = new GreenfootImage("baby4.png");
    
    // Constructor 1 ///////////////////////////////////
    public Baby(int pid, int dir, int spd)
    {
        picID = pid;
        direction = dir;
        speed = spd;
        
        determinePicture();
        determineMotion();
        
        getImage().scale(50, 50);
    }
    
    // Constructor 2 ///////////////////////////////////
    public Baby(int pid, int dir, int spd, int trn)
    {
        picID = pid;
        direction = dir;
        speed = spd;
        turnVal = trn;
        
        determinePicture();
        determineMotion();
        
        getImage().scale(50, 50);
    }
    
    // Constructor 3 ///////////////////////////////////
    public Baby(int pid, int dir)
    {
        picID = pid;
        direction = dir;
        
        determinePicture();
        determineMotion();
        
        getImage().scale(50, 50);
    }
    
    public void act()
    {
        setLocation(getX() + hSpeed, getY() + vSpeed);
        setRotation(getRotation() + turnVal);
        
        if (getX() > getWorld().getWidth() || getX() < 0)
        {
            hSpeed *= -1;
        }
        if (getY() > getWorld().getHeight() || getY() < 0)
        {
            vSpeed *= -1;
        }
    }
    
    // User-created methods ///////////////////////////////////
    
    public void determinePicture()
    {
        if (picID == 1)
        {
            setImage(b1);
        }
        else if (picID == 2)
        {
            setImage(b2);
        }
        else if (picID == 3)
        {
            setImage(b3);
        }
        else if (picID == 4)
        {
            setImage(b4);
        }
    }
    
    public void determineMotion()
    {
        if (direction == 1)
        {
            hSpeed = speed;
            vSpeed = -speed;
        }        
        else if (direction == 2)
        {
            hSpeed = -speed;
            vSpeed = speed;
        }
        else if (direction == 3)
        {
            hSpeed = -speed;
            vSpeed = -speed;
        }
        else if (direction == 4)
        {
            hSpeed = speed;
            vSpeed = speed;
        }
        else if (direction == 0)
        {
            hSpeed = 0;
            vSpeed = 0;
        }
        else
        {
            System.out.println("Direction set to " + direction + ". That's impossible.");
        }
    }
}
