import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor
{
    
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("W") || Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - 5);
        }
        if (Greenfoot.isKeyDown("S") || Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + 5);
        }
        if (Greenfoot.isKeyDown("A") || Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 5, getY());
        }
        if (Greenfoot.isKeyDown("D") || Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 5, getY());
        }
        // So this line says ... if the user hits space AND more than 0.25 sec has elapsed, then 
        // add a bullet to the screen.  Otherwise, it won't allow it.
        if (Greenfoot.isKeyDown("space") && MyWorld.shotTimer.millisElapsed() > 250)
        {
            getWorld().addObject(new Bullet(), getX(), getY());
            // Reset the timer to 0.
            MyWorld.shotTimer.mark();
            
            Greenfoot.playSound("laser.wav");
        }
        
        
    }    
}
