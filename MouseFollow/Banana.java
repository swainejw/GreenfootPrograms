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
        MouseInfo follow = Greenfoot.getMouseInfo(); // assigns a name to the location of the touchable mouse
        if(follow != null) 
        {
            setLocation(follow.getX(), follow.getY()); //sets the location of the actor mouse to that of the touchable mouse
        }
    }    
}
