import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Fish extends Actor
{
    int xMove = 5;
    SimpleTimer tFish = new SimpleTimer();
    int rn = Greenfoot.getRandomNumber(3000);
    
    public void act()
    {
        setLocation(getX() - xMove, getY());
        
        if (getX() < 10 || getX() > 590)
        {
            xMove *= -1;
        }
        
        if (tFish.millisElapsed() > rn)
        {
            getWorld().addObject(new Seaweed(), getX(), getY());
            tFish.mark();
            rn = Greenfoot.getRandomNumber(3000);
        }
    }
}
