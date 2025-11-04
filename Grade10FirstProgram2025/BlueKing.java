import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BlueKing extends Actor
{
    SimpleTimer tBK = new SimpleTimer();
    int health = 10;
    int bkSpeed = 5;

    public void act()
    {
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - bkSpeed, getY());
        }
        if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + bkSpeed, getY());
        }
        
        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        if (Greenfoot.isKeyDown("space") && tBK.millisElapsed() > 100)
        {
            getWorld().addObject(new Arrow(), getX(), getY() - getImage().getWidth()/2);
            tBK.mark();
        }
    }
}
