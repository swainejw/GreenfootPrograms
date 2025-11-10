import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Plane extends Actor
{
    // Circle movement variables
    private int centerX;        // X coordinate of circle center
    private int centerY;        // Y coordinate of circle center
    private int radius;         // Radius of the circle
    private double angle;       // Current angle in radians
    private double speed;       // How fast the plane moves around the circle (radians per act)
    
    public Plane(int centerX, int centerY, int radius, double speed)
    {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.speed = speed;
        this.angle = 0;       // Start at angle 0
        
        getImage().scale(35, 35);
    }
    
    public void act()
    {
        // Calculate new position
        int newX = centerX + (int)(radius * Math.cos(angle));
        int newY = centerY + (int)(radius * Math.sin(angle));
        
        // Move the plane
        setLocation(newX, newY);
        
        // Increment the angle
        angle += speed;
    }
    

}

