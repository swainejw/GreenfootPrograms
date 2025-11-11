import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @jswaine
 * @Sept30,2021
 */
public class Hero extends Actor
{
    int mv = 5;
    SimpleTimer shotTimer = new SimpleTimer();
    
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveHorizontally();
        shoot();
    }    
    
    /**
     * This method is responsible for moving the hero left / right
     */
    public void moveHorizontally()
    {
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + mv, getY());
        }
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - mv, getY());
        }
    }
    
    /**
     * This method is responsible for the hero shooting based on the timer
     */
    public void shoot()
    {
        if (Greenfoot.isKeyDown("space") && shotTimer.millisElapsed() > 500)
        {
            getWorld().addObject(new Bullet(), getX(), getY() - 5);
            shotTimer.mark();
        }
    }
    
}
