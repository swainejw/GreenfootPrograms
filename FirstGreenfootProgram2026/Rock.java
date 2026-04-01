import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Rock extends Actor
{
    int speed = 15;
    
    public Rock()
    {
        getImage().scale(15, 15);
    }
    
    public void act()
    {
        setLocation(getX() + speed, getY());
        
        LobsterTrap lt = (LobsterTrap) getOneIntersectingObject(LobsterTrap.class);
        if (lt != null)
        {
            getWorld().removeObject(lt);
            getWorld().removeObject(this);
            return;
        }
        
        if (getX() > 595)
        {
            getWorld().removeObject(this);
            return;
        }
    }
}
