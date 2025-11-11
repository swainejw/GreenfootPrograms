
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    int mv1 = 5;
    int mv2 = 2;
    SimpleTimer enemyShotTimer = new SimpleTimer();
    Random r = new Random();
    public int health = 1;
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (enemyShotTimer.millisElapsed() > (r.nextInt(15000) + 1000) )
        {
            getWorld().addObject(new EnemyBullet(), getX(), getY() - 5);
            enemyShotTimer.mark();
        }
        
        if (getWorld() instanceof Level1)
        {
            setLocation(getX() + mv1, getY());
            if ((getX() > 590) || (getX() < 10))
            {
                mv1 *= -1;
            }
        }
        else if (getWorld() instanceof Level2)
        {
            setLocation(getX(), getY() + mv2);
            if ((getY() > 390) || (getY() < 10))
            {
                mv2 *= -1;
            }
        }
    }    
    
    
}
