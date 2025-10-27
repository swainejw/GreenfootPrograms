import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Fish extends Actor
{
    int yMove = 5;
    SimpleTimer tFish = new SimpleTimer();
    int rn = Greenfoot.getRandomNumber(3000);
    
    public void act()
    {
        setLocation(getX(), getY() - yMove);
        
        if (getY() < 10 || getY() > 390)
        {
            yMove *= -1;
        }
        
        if (tFish.millisElapsed() > rn)
        {
            getWorld().addObject(new Seaweed(), getX(), getY());
            tFish.mark();
            rn = Greenfoot.getRandomNumber(3000);
        }
    }
}
