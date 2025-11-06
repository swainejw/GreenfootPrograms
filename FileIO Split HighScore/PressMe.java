import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PressMe extends Actor
{
    int x = 1;
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            MyWorld.c.add(x++);
        }
    }
}
