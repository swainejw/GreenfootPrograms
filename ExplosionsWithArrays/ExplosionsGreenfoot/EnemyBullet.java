import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyBullet extends Actor
{
    /**
     * Act - do whatever the EnemyBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() + 2);
        
        Hero h = (Hero) getOneIntersectingObject(Hero.class);
        if (h != null)
        {
            getWorld().removeObject(h);
            getWorld().removeObject(this);
            Greenfoot.setWorld(new LoseWorld());
        }
        else if (getY() > 390)
        {
            getWorld().removeObject(this);
            
        }
    }    

    public EnemyBullet()
    {
        getImage().scale(15, 15);
    }

}
