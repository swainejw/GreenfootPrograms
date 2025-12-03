import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PuffSmoke extends Actor
{
    SimpleTimer t = new SimpleTimer();
    final int ANI_TIMER = 150;
    
    GreenfootImage s1 = new GreenfootImage("smoke1nobg.png");
    GreenfootImage s2 = new GreenfootImage("smoke2nobg.png");
    GreenfootImage s3 = new GreenfootImage("smoke3nobg.png");
    GreenfootImage s4 = new GreenfootImage("smoke4nobg.png");
    GreenfootImage s5 = new GreenfootImage("smoke5nobg.png");
    GreenfootImage s6 = new GreenfootImage("smoke6nobg.png");
    
    public void act()
    {
        if (t.millisElapsed() > 0 && t.millisElapsed() < ANI_TIMER)
        {
            setImage(s1);
        }
        else if (t.millisElapsed() > ANI_TIMER && t.millisElapsed() < 2*ANI_TIMER)
        {
            setImage(s2);
        }
        else if (t.millisElapsed() > 2*ANI_TIMER && t.millisElapsed() < 3*ANI_TIMER)
        {
            setImage(s3);
        }
        else if (t.millisElapsed() > 3*ANI_TIMER && t.millisElapsed() < 4*ANI_TIMER)
        {
            setImage(s4);
        }
        else if (t.millisElapsed() > 4*ANI_TIMER && t.millisElapsed() < 5*ANI_TIMER)
        {
            setImage(s5);
        }
        else if (t.millisElapsed() > 5*ANI_TIMER && t.millisElapsed() < 6*ANI_TIMER)
        {
            setImage(s6);
        }
        else
        {
            getWorld().removeObject(this);
            return;
        }
    }
}
