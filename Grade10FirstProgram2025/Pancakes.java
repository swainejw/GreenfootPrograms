import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pancakes extends Actor
{
    int pSpeed = 5;
    public void act()
    {
        setLocation(getX(), getY() + pSpeed);
        
        if (getY() > getWorld().getHeight() - 10)
        {
            getWorld().removeObject(this);
            return;
        }
        
        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        BlueKing f = (BlueKing) getOneIntersectingObject(BlueKing.class);
        if (f != null)
        {
            f.health--;
            MyWorld.lives.setValue(f.health);
            if (f.health == 0)
            {
                Greenfoot.setWorld(new LoseWorld());
            } 
            getWorld().removeObject(this);
            return;
        }
    }
}
