import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Net extends Actor
{
    int speed = 7;
    
    public void act()
    {
        setLocation(getX() - speed, getY());
        
        if (getX() < 20)
        {
            getWorld().removeObject(this);
            return;
        }
        
        Lobster l = (Lobster) getOneIntersectingObject(Lobster.class);
        if (l != null)
        {
            MyWorld.livesC.add(-1);
            if (MyWorld.livesC.getValue() == 0)
            {
                Greenfoot.setWorld(new LoseWorld());
            }
            getWorld().removeObject(this);
            return;
        }
    }
}
