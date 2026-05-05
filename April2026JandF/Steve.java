import greenfoot.*;

public class Steve extends Actor
{
    int vSpeed = 0;
    boolean onGround = false;

    public void act()
    {
        moveLR();
        moveUD();
        checkJump();
        checkBarrel();
    }
    
    public void moveLR()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 5, getY());
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 5, getY());
        }
    }
    
    public void moveUD()
    {
        // Apply gravity
        vSpeed += 1;
        setLocation(getX(), getY() + vSpeed);

        // Check if standing on brick
        Brick b = (Brick) getOneIntersectingObject(Brick.class);
        if (b != null)
        {
            if (vSpeed < 0)
            {
                setLocation(getX(), b.getY() + b.getImage().getHeight()/2 + getImage().getHeight()/2);
                onGround = false;
            }
            else 
            {
                setLocation(getX(), b.getY() - b.getImage().getHeight()/2 - getImage().getHeight()/2);
                onGround = true;
            }
            vSpeed = 0;
        }
        else
        {
            onGround = false;
        }
    }
    
    public void checkJump()
    {
        if (Greenfoot.isKeyDown("space") && onGround)
        {
            vSpeed = -13;
            onGround = false;
        }
    }
    
    public void checkBarrel()
    {
        for (int x = -3; x < 3; x++)
        {
            for (int y = 5; y < 150; y++)
            {
                Barrel b = (Barrel) getOneObjectAtOffset(x, y, Barrel.class);
                if (b != null && b.isJumped == false)
                {
                    MyWorld.score.setValue(MyWorld.score.getValue() + b.value);
                    b.isJumped = true;
                }
            }
        }
    
    }
}
