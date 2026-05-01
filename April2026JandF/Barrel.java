import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barrel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrel extends Actor
{
    int vSpeed = 0;
    int hSpeed = -3;
    int value = 200;
    boolean isJumped = false;
    
    public Barrel()
    {
        getImage().scale(30,30);
    }
    
    public void act()
    {
        turn(-2);
        horizMovement();
        vertMovement();
        
        if (getX() < 5 && getY() > 330)
        {
            getWorld().removeObject(this);
        }
    }
    
    public void horizMovement()
    {
        setLocation(getX() + hSpeed, getY());
        if (getX() < 5 || getX() > getWorld().getWidth() - 5)
        {
            hSpeed *= -1;
        }
    }
    
    public void vertMovement()
    {
        // Apply gravity
        vSpeed += 1;
        setLocation(getX(), getY() + vSpeed);

        // Check if standing on brick
        Brick b = (Brick) getOneIntersectingObject(Brick.class);
        if (b != null)
        {
            // Snap to top of brick
            // the middle of the brick - half the height of the brick - half the height of steve
            setLocation(getX(), b.getY() - b.getImage().getHeight()/2 - getImage().getHeight()/2);
            vSpeed = 0;
        }
    }
}
