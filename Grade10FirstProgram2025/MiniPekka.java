import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MiniPekka here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiniPekka extends Actor
{
    int health = 3;
    int xMove = 2;
    SimpleTimer tPekka = new SimpleTimer();
    int rn = Greenfoot.getRandomNumber(9000);
    public void act()
    {
        setLocation(getX() - xMove, getY());
        
        if (getX() < 10 || getX() > getWorld().getHeight()-10)
        {
            xMove *= -1;
        }
        
        if (tPekka.millisElapsed() > rn)
        {
            getWorld().addObject(new Pancakes(), getX(), getY());
            tPekka.mark();
            rn = Greenfoot.getRandomNumber(9000);
        }
    }
}
