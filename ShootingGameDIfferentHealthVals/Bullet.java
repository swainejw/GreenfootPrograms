import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    final int targetScore = 11;
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() - 5);
        
        Enemy e = (Enemy) getOneIntersectingObject(Enemy.class);  
        Enemy2 e2 = (Enemy2) getOneIntersectingObject(Enemy2.class);  
        
        if (e != null)
        {
            e.health--;
            if (e.health == 0)
            {
                getWorld().removeObject(e);
                MyWorld.score.add(e.getValue());
            }
            
            getWorld().removeObject(this);
        }
        else if (e2 != null)
        {
            e2.health--;
            if (e2.health == 0)
            {
                if (e2.picID == 2)
                {
                    getWorld().addObject(new Explosion(), e2.getX(), e2.getY());
                }
                getWorld().removeObject(e2);
                MyWorld.score.add(e2.value);
            }
            
            getWorld().removeObject(this);
        }
        else if (getY() < 5)
        {
            getWorld().removeObject(this);
        }
    }    
}
