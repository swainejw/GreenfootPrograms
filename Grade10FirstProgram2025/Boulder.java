import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Boulder extends Actor
{
    // ADD A COMMENT HERE TO EXPLAIN THESE VARIABLES
    int xMove, yMove;
    
    // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE (this bit is hard!)
    public Boulder(int a, int b)
    {
        xMove = a*-2;
        yMove = Math.abs(b*2);
    }
    
    public void act()
    {
        setLocation(getX() + xMove, getY() + yMove);
        
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
        
        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        if (getX() < 10 || getX() > getWorld().getWidth() - 10)
        {
            xMove *= -1;
        }
        if (getY() < 10)
        {
            yMove *= -1;
        }
        
        // ADD A COMMENT HERE TO EXPLAIN THIS BIT OF CODE
        if (getY() > getWorld().getHeight() - 10)
        {
            getWorld().removeObject(this);
            return;
        }

    }
}
