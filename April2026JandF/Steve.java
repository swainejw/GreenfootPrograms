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
            // Snap to top of brick
            // the middle of the brick - half the height of the brick - half the height of steve
            setLocation(getX(), b.getY() - b.getImage().getHeight()/2 - getImage().getHeight()/2);
            vSpeed = 0;
            onGround = true;
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
            vSpeed = -20;
            onGround = false;
        }
    }
}
