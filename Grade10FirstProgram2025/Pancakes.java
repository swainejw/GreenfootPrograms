import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pancakes extends Actor
{
    public void act()
    {
        setLocation(getX(), getY() + 5);
        
        if (getY() > getWorld().getHeight() - 10)
        {
            getWorld().removeObject(this);
            return;
        }
        
        BlueKing f = (BlueKing) getOneIntersectingObject(BlueKing.class);
        if (f != null)
        {
            Greenfoot.setWorld(new LoseWorld());
        }
    }
}
