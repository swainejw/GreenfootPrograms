import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Leaf extends Actor
{
    public Leaf()
    {
        getImage().scale(10,10);
    }
    
    public void act()
    {
        setLocation(getX(), getY() - 5);
        
        Fish f = (Fish) getOneIntersectingObject(Fish.class);
        if (f != null)
        {
            // add 1 to the counter
            MyWorld.score.add(1);
            if (MyWorld.score.getValue() == 5)
            {
                Greenfoot.setWorld(new WinWorld());
            }
            getWorld().removeObject(f);
            getWorld().removeObject(this);
            return;
        }
        
        if (getX() > 590)
        {
            getWorld().removeObject(this);
            return;
        }
        
        
    }
}
