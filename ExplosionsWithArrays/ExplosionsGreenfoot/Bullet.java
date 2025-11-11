import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    public Bullet()
    {
        getImage().scale(15,15);
    }
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() - 10);
        
        Bomb b = (Bomb) getOneIntersectingObject(Bomb.class);
        EnemyBullet eb = (EnemyBullet) getOneIntersectingObject(EnemyBullet.class);
        if (b != null)
        {
            b.health--;
            if (b.health == 0)
            {
                // increase the counter value by 10
                Globals.score.add(10);
                //System.out.println(getWorld().getObjects(Bomb.class).size());
                
                
                getWorld().addObject(new Explosion(), b.getX(), b.getY());
                getWorld().removeObject(b);
                
                if (getWorld().getObjects(Bomb.class).size() == 0)
                {
                    Greenfoot.setWorld(new Level2());
                }
                
            }
            getWorld().removeObject(this);
        }
        else if (eb != null)
        {
            getWorld().removeObject(eb);
            getWorld().removeObject(this);
        }
        else if (getY() < 5)
        {
            getWorld().removeObject(this);
        }
    }    
    
    
}
