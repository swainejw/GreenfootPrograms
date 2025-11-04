import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MiniPekka extends Actor
{
    // ADD A COMMENT HERE TO EXPLAIN THESE VARIABLES
    int health = 3;
    int xMove = 2;
    int value = 10;
    int howOften = 9000;
    
    SimpleTimer tPekka = new SimpleTimer();
    int rn = Greenfoot.getRandomNumber(howOften);
    
    public void act()
    {
        setLocation(getX() - xMove, getY());
        
        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        if (getX() < 10 || getX() > getWorld().getHeight()-10)
        {
            xMove *= -1;
        }
        
        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        if (tPekka.millisElapsed() > rn)
        {
            getWorld().addObject(new Pancakes(), getX(), getY());
            tPekka.mark();
            rn = Greenfoot.getRandomNumber(howOften);
        }
    }
}
