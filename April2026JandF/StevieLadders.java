import greenfoot.*;

public class StevieLadders extends Actor
{
    int vSpeed = 0;
    boolean onGround = false;
    boolean onLadder = false;
    int dir = 10;
    SimpleTimer t = new SimpleTimer();

    public StevieLadders()
    {
        getImage().scale(20,40);
    }
    
    public void act()
    {
        checkLadder();
        checkLadderBelow();
        moveLR();
        moveUD();
        checkJump();
        checkBarrel();
        checkSpider();
        checkShoot();
    }

    public void checkLadder()
    {
        Ladder l = (Ladder) getOneIntersectingObject(Ladder.class);
        onLadder = (l != null);
    }
    
    public boolean checkLadderBelow()
    {
        Ladder lbelow = (Ladder) getOneObjectAtOffset(0, getImage().getHeight()/2 + 10, Ladder.class);
        System.out.println(getX());
        if (lbelow != null)
        {
            //System.out.println("l below");
            return true;
        }
        //System.out.println("no l below");
        return false;
    }

    public void moveLR()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 5, getY());
            dir = -10;
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 5, getY());
            dir = 10;
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
        if (Greenfoot.isKeyDown("up") && onGround)
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
                    MyWorld.cScore.setValue(MyWorld.cScore.getValue() + b.value);
                    b.isJumped = true;
                }
            }
        }

        Barrel b1 = (Barrel) getOneIntersectingObject(Barrel.class);
        if (b1 != null)
        {
            MyWorld.cLives.add(-1);
            if (MyWorld.cLives.getValue() == 0)
            {
                Greenfoot.setWorld(new LoseWorld());
            }
            setLocation(40, getWorld().getHeight() - 50);
            getWorld().removeObject(b1);
        }

    }

    public void checkSpider()
    {
        Spider s = (Spider) getOneIntersectingObject(Spider.class);
        if (s != null)
        {
            MyWorld.cLives.add(-1);
            if (MyWorld.cLives.getValue() == 0)
            {
                Greenfoot.setWorld(new LoseWorld());
            }
            setLocation(40, getWorld().getHeight() - 50);
        }
    }
    
    public void checkShoot()
    {
        if (Greenfoot.isKeyDown("space") && t.millisElapsed() > 300)
        {
            t.mark();
            getWorld().addObject(new Arrow(dir), getX(), getY());
        }
    }
}
