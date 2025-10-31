import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SpearGoblin extends Actor
{
    int xMove = 5;
    int health = 2;
    SimpleTimer tSpearGoblin = new SimpleTimer();
    int rn = Greenfoot.getRandomNumber(3000);
    
    // public SpearGoblin()
    // {
        // getImage().scale(70,70);
    // }
    
    public void act()
    {
        setLocation(getX() - xMove, getY());
        
        if (getX() < 10 || getX() > 590)
        {
            xMove *= -1;
        }
        
        if (tSpearGoblin.millisElapsed() > rn)
        {
            getWorld().addObject(new Spear(), getX(), getY());
            tSpearGoblin.mark();
            rn = Greenfoot.getRandomNumber(999000);
        }
    }
}
