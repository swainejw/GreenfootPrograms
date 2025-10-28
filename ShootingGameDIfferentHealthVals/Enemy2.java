import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Enemy2 extends Actor
{
    GreenfootImage lbNormal = new GreenfootImage("ladybug.png");
    GreenfootImage lbGlow = new GreenfootImage("ladybug_glow.png");
    
    public int value = 5;
    public int health = 1;
    public int picID = 1;

    int timeCount = 0;
    
    public Enemy2(int p)
    {
        picID = p;
        setImage(lbNormal);
    }
    
    public void act() 
    {
        timeCount++;
        if (timeCount >= 200)
        {
            setImage(lbGlow);
            picID = 2;
            timeCount = 0;
        }
    }    
}
