import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Person extends Actor
{
    int edge = 130;
    int speed = 5;
    int dy = 0;
    
    public void act()
    {
        // move down always by dy - that value controls "gravity"
        setLocation(getX(), getY() - dy);
        
        if (Greenfoot.isKeyDown("right"))
        {
            // only have the player move if not yet at what we define as the "edge"
            // at that point, it's the background that moves!
            if (getX() < getWorld().getWidth() - edge)
            {
                setLocation(getX() + speed, getY());
                // check to see if hit brick wall
                Brick bHR = (Brick) getOneObjectAtOffset(getImage().getWidth()/2 + speed, 0, Brick.class);
                if (bHR != null) 
                {
                    setLocation(getX() - speed, getY());
                }
            }
            // if the last horizontal object (the 99th in the array)has an x value above
            // 975, we continue looking to see if we need to move the background
            else if (MyWorld.bg[99][0].getX() > 975)
            {
                Brick bHR = (Brick) getOneObjectAtOffset(getImage().getWidth()/2 + speed, 0, Brick.class);
                // if we have NOT hit a brick, move the bg objects
                if (bHR == null) 
                {
                    MyWorld.moveBGHoriz(-speed);
                }
            }
        }
        
        // see comments for right movement
        if (Greenfoot.isKeyDown("left"))
        {
            if (getX() > edge)
            {
                setLocation(getX() - speed, getY());
                Brick bHL = (Brick) getOneObjectAtOffset(-getImage().getWidth()/2 - speed, 0, Brick.class);
                if (bHL != null) 
                {
                    setLocation(getX() + speed, getY());
                }
            }
            else if (MyWorld.bg[0][0].getX() < 25)
            {
                Brick bHL = (Brick) getOneObjectAtOffset(-getImage().getWidth()/2 - speed, 0, Brick.class);
                if (bHL == null) 
                {
                    MyWorld.moveBGHoriz(speed);
                }
            }
        }
        
        // if on the ground and space bar, we "jump" by changing dy
        if (Greenfoot.isKeyDown("space") && onGround())
        {
            dy = 23;
            setLocation(getX(), getY() - 1);
        }
        
        // if dy is below , we're moving down
        if (dy <= 0)
        {
            // lift the player out of the grass or brick one pixel at a time
            while (isTouching(Grass.class) || isTouching(Brick.class))
            {
                setLocation(getX(), getY() - 1);
            }
        }
        
        // if not on the ground, fall.  otherwise, don't.
        if (!onGround())
        {
            dy--;
        }
        else 
        {
            dy = 0;
        }
        
    }
    
    // definition of onGround is 1 pixel above the brick or grass
    // returns true (on ground) or false (not on ground)
    public boolean onGround()
    {
        for (int x = -getImage().getWidth()/2; x < getImage().getWidth()/2; x++)
        {
            Brick b = (Brick) getOneObjectAtOffset(x, getImage().getHeight()/2 + 1, Brick.class);
            Grass g = (Grass) getOneObjectAtOffset(x, getImage().getHeight()/2 + 1, Grass.class);
            if (b != null)
                return true;
            if (g != null)
                return true;
        }
        return false;
    }
}
