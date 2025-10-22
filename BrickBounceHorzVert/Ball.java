import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    int xMove = 3;
    int yMove = 3;
    static int numBricks = 0;
    
    public Ball()
    {
        getImage().scale(10,10);
        numBricks = 0;
    }
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // HORIZONTAL MOVEMENT
        setLocation(getX() + xMove, getY());
        if (getX() < 10 || getX() > getWorld().getWidth() - 10)
        {
            xMove *= -1;
        }
        
        Brick bHorz = (Brick) getOneIntersectingObject(Brick.class);
        if (bHorz != null)
        {
            xMove *= -1;
            setLocation(getX() + xMove, getY());
            numBricks++;
        }
        /////////////////////////////////////////
        
        // VERTICAL MOVEMENT
        setLocation(getX(), getY() + yMove);
        if (getY() < 10 || getY() > getWorld().getHeight() - 10)
        {
            yMove *= -1;
        }
        
        Brick bVert = (Brick) getOneIntersectingObject(Brick.class);
        if (bVert != null)
        {
            yMove *= -1;
            setLocation(getX(), getY() + yMove);
            if (xMove > 0)
            {
                xMove = 2 + Greenfoot.getRandomNumber(2);
            }
            else
            {
                xMove = -2 - Greenfoot.getRandomNumber(2);
            }
            numBricks++;
        }
        /////////////////////////////
        
        MyWorld.numBricks.setValue(numBricks);
    }
    
    public int getNumBricks()
    {
        return numBricks;
    }
}
