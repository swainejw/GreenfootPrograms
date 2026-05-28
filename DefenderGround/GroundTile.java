
import greenfoot.*;

public class GroundTile extends Actor
{
    private static final int SIZE = 3;
    private static final int SPEED = 2;

    public GroundTile()
    {
        GreenfootImage img = new GreenfootImage(SIZE, SIZE);
        img.setColor(new Color(128, 0, 0)); // maroon
        img.fill();
        setImage(img);
    }

    public void act()
    {
        setLocation(getX() - SPEED, getY());
        if (getX() < 2)
        {
            getWorld().removeObject(this);
        }
    }
}
