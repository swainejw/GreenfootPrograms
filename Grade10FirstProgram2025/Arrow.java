import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Arrow extends Actor
{  
    int aSpeed = -5;
    
    public void act()
    {
        setLocation(getX(), getY() + aSpeed);
        
        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        SpearGoblin s = (SpearGoblin) getOneIntersectingObject(SpearGoblin.class);
        if (s != null)
        {
            s.health--;
            if (s.health == 0)
            {
                getWorld().removeObject(s);
                MyWorld.score.add(s.value);
            }
            getWorld().removeObject(this);
            return;
        }
        
        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        MiniPekka mp = (MiniPekka) getOneIntersectingObject(MiniPekka.class);
        if (mp != null)
        {
            mp.health--;
            if (mp.health == 0)
            {
                getWorld().removeObject(mp);
                MyWorld.score.add(mp.value);
            }
            
            getWorld().removeObject(this);
            return;
        }
        
        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        Bowler bw = (Bowler) getOneIntersectingObject(Bowler.class);
        if (bw != null)
        {
            bw.health--;
            if (bw.health == 0)
            {
                getWorld().removeObject(bw);
                MyWorld.score.add(bw.value);
            }
            
            getWorld().removeObject(this);
            return;
        }
        
        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        if (getY() < 5)
        {
            getWorld().removeObject(this);
            return;
        }
        
    }
}
