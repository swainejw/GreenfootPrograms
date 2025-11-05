import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PressMe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PressMe extends Actor
{
    /**
     * Act - do whatever the PressMe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            MyWorld.c.add(1);
        }
    }
}
