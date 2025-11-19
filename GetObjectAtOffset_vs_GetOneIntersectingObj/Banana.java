import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Banana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Banana extends Actor
{
    /**
     * Act - do whatever the Banana wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 5, getY());
        }
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 5, getY());
        }
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - 5);
        }
        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + 5);
        }
        
        Elephant e = (Elephant) getOneIntersectingObject(Elephant.class);
        if (e != null)
        {
            getWorld().addObject(new FoundIt(), 200, 350);
        }
        
        Dolphin d = (Dolphin) getOneObjectAtOffset(0, 50, Dolphin.class);
        if (d != null)
        {
            getWorld().addObject(new FoundIt(), 400, 350);
        }
    }
}
