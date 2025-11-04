import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SpearGoblin extends Actor
{
    int xMove = 5;
    int health = 2;
    SimpleTimer tSpearGoblin = new SimpleTimer();
    int howOften = 8000;
    int rn = Greenfoot.getRandomNumber(howOften);
    int value = 5;

    public void act()
    {
        setLocation(getX() - xMove, getY());

        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        if (getX() < 10 || getX() > getWorld().getHeight()-10)
        {
            xMove *= -1;
        }

        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        if (tSpearGoblin.millisElapsed() > rn)
        {
            getWorld().addObject(new Spear(), getX(), getY());
            tSpearGoblin.mark();
            rn = Greenfoot.getRandomNumber(howOften);
        }
    }
}
