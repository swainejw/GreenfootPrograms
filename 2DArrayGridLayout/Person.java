import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Person extends Actor
{
    int edge = 130;
    int speed = 5;
    int dy = 0;
    
    public void act()
    {
        setLocation(getX(), getY() - dy);
        
        if (Greenfoot.isKeyDown("right"))
        {
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
            else if (MyWorld.bg[99][0].getX() > 975)
            {
                Brick bHR = (Brick) getOneObjectAtOffset(getImage().getWidth()/2 + speed, 0, Brick.class);
                if (bHR == null) 
                {
                    MyWorld.moveBGHoriz(-speed);
                }
            }
        }
        
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
        
        if (Greenfoot.isKeyDown("space") && onGround())
        {
            dy = 23;
            setLocation(getX(), getY() - 1);
        }
        
        if (dy <= 0)
        {
            while (isTouching(Grass.class) || isTouching(Brick.class))
            {
                setLocation(getX(), getY() - 1);
            }
        }
        
        if (!onGround())
        {
            dy--;
        }
        else 
        {
            dy = 0;
        }
        
    }
    
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
