import greenfoot.*;

public class Mario extends Actor
{
    private int vSpeed = 0;                // vertical speed
    private final int GRAVITY = 1;         // gravity per frame
    private final int JUMP_STRENGTH = -15; // how high to jump
    private final int HORZ_MOVE_SPEED = 5; // how fast to move sideways

    public Mario()
    {
        getImage().scale(22, 36);
    }

    public void act()
    {
        applyGravityAndSnap();   // move vertically, snap out of blocks
        handleHorizontal();      // left/right with basic collision
        handleJumpInput();       // check jump AFTER snapping so onGround() is reliable
    }

    // ----------------------
    // Movement & physics
    // ----------------------
    private void applyGravityAndSnap()
    {
        // Apply vertical motion
        setLocation(getX(), getY() + vSpeed);

        // If overlapping a block (inside the block), snap up until not overlapping
        if (isOverlapping())
        {
            vSpeed = 0;
            // Move up until the actor is no longer overlapping the block
            while (isOverlapping())
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

    
    
    private void handleHorizontal()
    {
        // Move right or left, but not if you are going to run into something
        if (Greenfoot.isKeyDown("right"))
        {
            if (!touchingSolidHoriz(HORZ_MOVE_SPEED))
            {
                setLocation(getX() + HORZ_MOVE_SPEED, getY());
            }
        }
        if (Greenfoot.isKeyDown("left"))
        {
            if (!touchingSolidHoriz(-HORZ_MOVE_SPEED))
            {
                setLocation(getX() - HORZ_MOVE_SPEED, getY());
            }
        }
    }

    private void handleJumpInput()
    {
        // onGround() is TRUE if we are 1 pixel above the brick (i.e. standing on a block)
        if (Greenfoot.isKeyDown("space") && onGround())
        {
            vSpeed = JUMP_STRENGTH;
        }
    }

    // ----------------------
    // Collision helpers
    // ----------------------

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
    private boolean isOverlapping()
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

    // Horizontal collision check (single-point)
    private boolean touchingSolidHoriz(int dx)
    {
        // check the left edge OR the right edge, depending on direction
        int offset = 0;
        if (dx < 0)
        {
            offset = -getImage().getWidth()/2;
        }
        else
        {
            offset = getImage().getWidth()/2;
        }
        
        // if we find a brick, return TRUE
        Brick b = (Brick) getOneObjectAtOffset(offset + dx, 0, Brick.class);
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
