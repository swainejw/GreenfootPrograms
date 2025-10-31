import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor
{
    GreenfootImage u1 = new GreenfootImage("up1.png");
    GreenfootImage u2 = new GreenfootImage("up2.png");
    GreenfootImage d1 = new GreenfootImage("down1.png");
    GreenfootImage d2 = new GreenfootImage("down2.png");

    SimpleTimer t = new SimpleTimer();
    int animationDelay = 50;
    int vMove = 3;
    
    public Hero()
    {
        setImage(d1);
        t.mark();
    }

    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // GreenfootImage u1 = new GreenfootImage("up1.png");
    // GreenfootImage u2 = new GreenfootImage("up2.png");
    // GreenfootImage d1 = new GreenfootImage("down1.png");
    // GreenfootImage d2 = new GreenfootImage("down2.png");
    public void act() 
    {
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - vMove);
            if (getImage() != u2)
            {
                setImage(u2);
            }
            else if (getImage() != u1)
            {
                setImage(u1);
            }
        }

        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + vMove);
            if (getImage() != d1)
            {
                setImage(d1);
            }
            else if (getImage() != d2)
            {
                setImage(d2);
            }
        }
        
        
        
        
        
        
        
        
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - vMove);
            if (t.millisElapsed() > animationDelay && getImage() != u2)
            {
                setImage(u2);
                t.mark();
            }
            else if (t.millisElapsed() > animationDelay && getImage() != u1)
            {
                setImage(u1);
                t.mark();
            }
        }

        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + vMove);
            if (t.millisElapsed() > animationDelay && getImage() != d1)
            {
                setImage(d1);
                t.mark();
            }
            else if (t.millisElapsed() > animationDelay && getImage() != d2)
            {
                setImage(d2);
                t.mark();
            }
        }
    }
} 

