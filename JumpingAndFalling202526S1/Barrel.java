import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Barrel extends Actor
{
    int vSpeed = 0;
    int hSpeed = 2;
    boolean isJumped = false;
    private final int T_SPEED = 3;
    private final int B_SIZE = 19;
    private final int GRAVITY = 1;
    
    public Barrel()
    {
        getImage().scale(B_SIZE, B_SIZE);
    }
    
    public void act()
    {
        turn(T_SPEED);
        applyGravityAndSnap();   // move vertically, snap out of blocks
        horizMove();
    }
    
    // ----------------------
    // Movement & physics
    // ----------------------
    private void applyGravityAndSnap()
    {
        // Apply vertical motion
        setLocation(getX(), getY() + vSpeed);

        // If overlapping a block (inside the block), snap up until not overlapping
        if (isOverlappingBottom())
        {
            vSpeed = 0;
            // Move up until the actor is no longer overlapping the block
            while (isOverlappingBottom())
            {
                setLocation(getX(), getY() - 1);
            }
            // After this loop, Mario should be sitting directly on top of the block (onGround() should be true)
        }
        
        else
        {
            // Not overlapping: apply gravity
            vSpeed += GRAVITY;
        }
    }
    
    private void horizMove()
    {
        setLocation(getX() + hSpeed, getY());
        if (getX() > getWorld().getWidth() - 5 || getX() < 5)
        {
            hSpeed *= -1;
        }
        
        if (getX() > getWorld().getWidth() - 5  && getY() == 447)
        {
            getWorld().removeObject(this);
        }
    }
    // True if the pixel one below the bottom edge is a brick (i.e. standing on a block)
    private boolean onGround()
    {
        int bottomEdge = getImage().getHeight() / 2;
        Brick b = (Brick) getOneObjectAtOffset(0, bottomEdge + 1, Brick.class);
        if (b != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // True if any pixel at the bottom edge is inside a block (i.e. overlapping)
    // We check bottomEdge to see whether the actor's bottom pixel is colliding
    private boolean isOverlappingBottom()
    {
        int bottomEdge = getImage().getHeight() / 2;
        Brick b = (Brick) getOneObjectAtOffset(0, bottomEdge, Brick.class);
        if (b != null)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
}
