import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public class LargeCircle extends Actor
{
    SmallCircle[] smalls = new SmallCircle[8];
    int radius = 50;  // distance from center
    int speed = 3;

    public void addedToWorld(World world) 
    {
        // angles for 8 positions (every 45°)
        int[] angles = {0, 45, 90, 135, 180, 225, 270, 315};

        for (int a = 0; a < angles.length; a++)
        {
            smalls[a] = new SmallCircle(angles[a], radius);
            world.addObject(smalls[a], getX(), getY());
        }
    }

    public void act() 
    {
        setLocation(getX(), getY() - speed);  // or whatever movement your LargeCircle has

        // update children positions after moving
        updateSmallCirclePositions();
    }

    private void updateSmallCirclePositions() 
    {
        for (int x = 0; x < smalls.length; x++)
        {
            smalls[x].updatePosition(getX(), getY());
        }
    }
}
