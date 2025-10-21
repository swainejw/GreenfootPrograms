import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Car extends Actor
{
    Color c = new Color(87, 135, 225);
    
    public void act()
    {
        if (Greenfoot.isKeyDown("right"))
            turn(2);
        if (Greenfoot.isKeyDown("left"))
            turn(-2);
        if (Greenfoot.isKeyDown("up"))
            move(3);
            
        //System.out.println(getWorld().getBackground().getColorAt(getX(), getY()));
        Color currColour = getWorld().getBackground().getColorAt(getX(), getY());
        if (currColour.getRed() == c.getRed() && currColour.getBlue() == c.getBlue() && currColour.getGreen() == c.getGreen())
        {
            move(-3);
        }
    }
}
