import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor
{
    int xMove, yMove = 0;
    int speed = 5;
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("W") || Greenfoot.isKeyDown("up"))
        {
            xMove = 0;
            yMove = -speed;
            setLocation(getX() + xMove, getY() + yMove);
        }
        if (Greenfoot.isKeyDown("S") || Greenfoot.isKeyDown("down"))
        {
            xMove = 0;
            yMove = speed;
            setLocation(getX() + xMove, getY() + yMove);
        }
        if (Greenfoot.isKeyDown("A") || Greenfoot.isKeyDown("left"))
        {
            xMove = -speed;
            yMove = 0;
            setLocation(getX() + xMove, getY() + yMove);
        }
        if (Greenfoot.isKeyDown("D") || Greenfoot.isKeyDown("right"))
        {
            xMove = speed;
            yMove = 0;
            setLocation(getX() + xMove, getY() + yMove);
        }
            
            
        
        // So this line says ... if the user hits space AND more than 0.25 sec has elapsed, then 
        // add a bullet to the screen.  Otherwise, it won't allow it.
        if (Greenfoot.isKeyDown("space") && MyWorld.shotTimer.millisElapsed() > 250)
        {
            getWorld().addObject(new Bullet(xMove, yMove), getX(), getY());
            // Reset the timer to 0.
            MyWorld.shotTimer.mark();
            
            Greenfoot.playSound("laser.wav");
        }
        
        
    }    
}
