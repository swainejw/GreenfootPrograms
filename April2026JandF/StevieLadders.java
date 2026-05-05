import greenfoot.*;

public class StevieLadders extends Actor
{
    int vSpeed = 0;
    boolean onGround = false;
    boolean onLadder = false;

    public void act()
    {
        checkLadder();
        moveLR();
        moveUD();
        checkJump();
        checkBarrel();
    }

    public void checkLadder()
    {
        Ladder l = (Ladder) getOneIntersectingObject(Ladder.class);
        onLadder = (l != null);
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
        // If on ladder → manual movement, NO gravity
        if (onLadder)
        {
            vSpeed = 0; // cancel falling

            if (Greenfoot.isKeyDown("up"))
            {
                setLocation(getX(), getY() - 4);
            }
            else if (Greenfoot.isKeyDown("down"))
            {
                setLocation(getX(), getY() + 4);
            }

            onGround = false; // important so jump doesn't trigger weirdly
            return; // skip gravity
        }

        // NORMAL GRAVITY (your original code)
        vSpeed += 1;
        setLocation(getX(), getY() + vSpeed);

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
            vSpeed = -18;
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

        Barrel b1 = (Barrel) getOneIntersectingObject(Barrel.class);
        if (b1 != null)
        {
            getWorld().removeObject(this);
            setLocation(40, getWorld().getHeight() - 50);
        }

    }
}
