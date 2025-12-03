import greenfoot.*;

public class Mario extends Actor
{
    int vSpeed = 0;                // vertical speed
    int brlsJumped = 0;
    final int GRAVITY = 1;         // gravity per frame
    final int JUMP_STRENGTH = -15; // how high to jump
    final int HORZ_MOVE_SPEED = 5; // how fast to move sideways
    final int ANIMATION_DELAY = 75; // how long to wait before switching pics
    
    // animation images
    GreenfootImage w1L = new GreenfootImage("walk-small1L.png");
    GreenfootImage w2L = new GreenfootImage("walk-small2L.png");
    GreenfootImage w3L = new GreenfootImage("walk-small3L.png");
    GreenfootImage w1R = new GreenfootImage("walk-small1R.png");
    GreenfootImage w2R = new GreenfootImage("walk-small2R.png");
    GreenfootImage w3R = new GreenfootImage("walk-small3R.png");
    GreenfootImage mJumpL = new GreenfootImage("mariojumpL.png");
    GreenfootImage mJumpR = new GreenfootImage("mariojumpR.png");
    GreenfootImage mStandL = new GreenfootImage("mariostandL.png");
    GreenfootImage mStandR = new GreenfootImage("mariostandR.png");
    
    // to hold the last image before jumping
    GreenfootImage lastImage;
   
    // for animation (switching pics)
    SimpleTimer tAni = new SimpleTimer();
    
    // to keep track of types of movement
    boolean firstMoveL = true;
    boolean firstMoveR = true;
    boolean jump = true;
    char lastDirMoved = 'l';
    
    public Mario()
    {
        setImage(mStandL);
        // no barrels jumped yet!
        brlsJumped = 0;
        // allow left or right movement animation to occur
        firstMoveL = true;
        firstMoveR = true;
    }

    public void act()
    {
        applyGravityAndSnap();   // move vertically, snap out of blocks
        handleHorizontal();      // left/right with basic collision
        handleJumpInput();       // check jump AFTER snapping so onGround() is reliable
        isJumpOverBarrel();      // did he jump a barrel?
        checkTouchBarrel();      // did he touch a barrel (bad)
    }

    // ----------------------
    // Movement & physics
    // ----------------------
    public void applyGravityAndSnap()
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
        
            // if he's overlapping the bottom, he's obviously not jumping
            jump = false;
            firstMoveL = true;
            firstMoveR = true;
        }
        else if (isOverlappingTop())
        {
            vSpeed = 0;
            // Move up until the actor is no longer overlapping the block
            while (isOverlappingTop())
            {
                setLocation(getX(), getY() + 1);
            }
        }
        else
        {
            // Not overlapping: apply gravity
            vSpeed += GRAVITY;
        }
    }

    public void handleHorizontal()
    {
        // Move right or left, but not if you are going to run into something
        if (Greenfoot.isKeyDown("right"))
        {
            startMoveRight();
            if (!touchingSolidHoriz(HORZ_MOVE_SPEED))
            {
                setLocation(getX() + HORZ_MOVE_SPEED, getY());
                // allow teleportation on the lower platforms only
                if (getX() > getWorld().getWidth() && getY() > 180)
                {
                    setLocation(0, getY());
                }
                // if he gets to the edge of the world while on the upper platforms,
                // don't allow further movement
                else if (getX() > getWorld().getWidth() )
                {
                    setLocation(getX() - HORZ_MOVE_SPEED, getY());
                }
                
                if (!jump)
                {
                    animateRunRight();
                }
            }
        }
        else if (Greenfoot.isKeyDown("left"))
        {
            startMoveLeft();
            if (!touchingSolidHoriz(-HORZ_MOVE_SPEED))
            {
                setLocation(getX() - HORZ_MOVE_SPEED, getY());
                // allow teleportation on the lower platforms only
                if (getX() < 0 && getY() > 200)
                {
                    setLocation(getWorld().getWidth(), getY());
                }
                // if he gets to the edge of the world while on the upper platforms,
                // don't allow further movement
                else if (getX() < 0)
                {
                    setLocation(getX() + HORZ_MOVE_SPEED, getY());
                }
                
                if (!jump)
                {
                    animateRunLeft();
                }
            }
        }
        else if (!jump)
        {
            // set the proper stand image
            if (lastDirMoved == 'l')
            {
                setImage(mStandL);
            }
            else if (lastDirMoved == 'r')
            {
                setImage(mStandR);  
            }
            
            firstMoveR = true;
            firstMoveL = true;
        }
    }

    public void handleJumpInput()
    {
        // onGround() is TRUE if we are 1 pixel above the brick (i.e. standing on a block)
        if (Greenfoot.isKeyDown("space") && onGround())
        {
            jump = true;
            Greenfoot.playSound("mariojump.mp3");
            
            lastImage = getImage();
            vSpeed = JUMP_STRENGTH;
            
            if (lastDirMoved == 'l')
            {
                setImage(mJumpL);
            }
            else if (lastDirMoved == 'r')
            {
                setImage(mJumpR);
            }
        }
    }

    public boolean isJumpOverBarrel()
    {
        // checks to see if Mario islock)
        if (!onGround())
        {
            for (int y = 0; y < 150; y+=5)
            {
                Barrel ba = (Barrel) getOneObjectAtOffset(0, y, Barrel.class);
                Brick br = (Brick) getOneObjectAtOffset(0, y, Brick.class);
                if (br != null)
                {
                    return false;
                }
                if (ba != null && ba.isJumped == false)
                {
                    brlsJumped++;
                    MyWorld.score.setValue(brlsJumped);
                    ba.isJumped = true;
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean checkTouchBarrel()
    {
        Barrel ba = (Barrel) getOneIntersectingObject(Barrel.class);
        if (ba != null)
        {
            MyWorld.lives.add(-1);
            if (MyWorld.lives.getValue() == 0)
            {
                Greenfoot.setWorld(new LoseWorld());
            }
            getWorld().addObject(new PuffSmoke(), getX(), getY());
            setLocation(getWorld().getWidth() - 30, 452);
            getWorld().removeObject(ba);
            return true;
        }
        return false;
        
    }
    // ----------------------
    // Collision helpers
    // ----------------------

    // True if the pixel one below the bottom edge is a brick (i.e. standing on a block)
    public boolean onGround()
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
    public boolean isOverlappingBottom()
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

    public boolean isOverlappingTop()
    {
        int topEdge = -getImage().getHeight() / 2;
        Brick b = (Brick) getOneObjectAtOffset(0, topEdge, Brick.class);
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
    public boolean touchingSolidHoriz(int dx)
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

    public void animateRunLeft()
    {
        if (getImage() == w1L && tAni.millisElapsed() > ANIMATION_DELAY)
        {
            setImage(w2L);
            tAni.mark();
        }
        else if (getImage() == w2L && tAni.millisElapsed() > ANIMATION_DELAY)
        {
            setImage(w3L);
            tAni.mark();
        }
        else if (getImage() == w3L && tAni.millisElapsed() > ANIMATION_DELAY)
        {
            setImage(w1L);
            tAni.mark();
        }
    }
    
    public void animateRunRight()
    {
        if (getImage() == w1R && tAni.millisElapsed() > ANIMATION_DELAY)
        {
            setImage(w2R);
            tAni.mark();
        }
        else if (getImage() == w2R && tAni.millisElapsed() > ANIMATION_DELAY)
        {
            setImage(w3R);
            tAni.mark();
        }
        else if (getImage() == w3R && tAni.millisElapsed() > ANIMATION_DELAY)
        {
            setImage(w1R);
            tAni.mark();
        }
    }
    
    public void startMoveRight()
    {
        lastDirMoved = 'r';
        if (firstMoveR == true)
        {
            firstMoveR = false;
            firstMoveL = true;
            setImage(w1R);
        }
    }
    
    public void startMoveLeft()
    {
        lastDirMoved = 'l';
        if (firstMoveL == true)
        {
            firstMoveR = true;
            firstMoveL = false;
            setImage(w1L);
        }
    }
}
