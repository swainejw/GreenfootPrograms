import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Spear extends Actor
{
    int sSpeed = 5;
    // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
    public Spear()
    {
        setRotation(45);
    }
    
    public void act()
    {
        setLocation(getX(), getY() + sSpeed);
        
        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
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
