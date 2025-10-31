import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Arrow extends Actor
{
    public Arrow()
    {
        //getImage().scale(10,10);
    }
    
    public void act()
    {
        setLocation(getX(), getY() - 5);
        
        SpearGoblin s = (SpearGoblin) getOneIntersectingObject(SpearGoblin.class);
        if (s != null)
        {
            
            
            s.health--;
            if (s.health == 0)
            {
                getWorld().removeObject(s);
            }
            getWorld().removeObject(this);
            return;
        }
        
        MiniPekka mp = (MiniPekka) getOneIntersectingObject(MiniPekka.class);
        if (mp != null)
        {
            mp.health--;
            if (mp.health == 0)
            {
                getWorld().removeObject(mp);
            }
            
            getWorld().removeObject(this);
            return;
        }
        
        
        
        if (getY() < 5)
        {
            getWorld().removeObject(this);
            return;
        }
        
        
    }
}
