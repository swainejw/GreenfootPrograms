import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SmallCircle extends Actor
{
    private int angle;
    private int radius;

    public SmallCircle(int a, int r) 
    {
        angle = a;
        radius = r;
    }

    public void updatePosition(int centerX, int centerY) 
    {
        
        double rad = Math.toRadians(angle);

        int x = centerX + (int)(Math.cos(rad) * radius);
        int y = centerY + (int)(Math.sin(rad) * radius);

        setLocation(x, y);
    }
}
