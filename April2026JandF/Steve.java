import greenfoot.*;

public class Steve extends Actor
{
    int vSpeed = 0;
    boolean onGround = false;

    public void act()
    {
        // Apply gravity
        vSpeed += 1;
        setLocation(getX(), getY() + vSpeed);

        // Check if standing on brick
        Brick b = (Brick) getOneIntersectingObject(Brick.class);
        if (b != null)
        {
            // Snap to top of brick
            setLocation(getX(), b.getY() - b.getImage().getHeight()/2 - getImage().getHeight()/2);
            vSpeed = 0;
            onGround = true;
        }
        else
        {
            onGround = false;
        }

        if (Greenfoot.isKeyDown("space") && onGround)
        {
            vSpeed = -20;
            onGround = false;
        }
        
    }
}
