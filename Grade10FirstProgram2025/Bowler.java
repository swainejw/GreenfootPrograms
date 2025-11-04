import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bowler extends Actor
{
    // ADD A COMMENT HERE TO EXPLAIN THESE VARIABLES
    int hMove = 2;
    int vMove = -2;
    int health = 5;
    int value = 20;
    int howOften = 3000;
    SimpleTimer tBoulder = new SimpleTimer();
    
    public void act()
    {
        setLocation(getX() + hMove, getY() + vMove);
        
        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        if (getX() < 10 || getX() > getWorld().getWidth() - 10)
        {
            hMove *= -1;
        }
        if (getY() < 10 || getY() > getWorld().getHeight() - 10)
        {
            vMove *= -1;
        }
        
        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        if (tBoulder.millisElapsed() > howOften)
        {
            getWorld().addObject(new Boulder(hMove, vMove), getX(), getY());
            tBoulder.mark();
        }
    }
}
