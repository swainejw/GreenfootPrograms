import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int x = 0;
    int y = 0;
    int z = 0;
    GreenfootImage background;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        background = getBackground();//Create Image

    }

    public void act()
    {

        x+=5;
        if (x == 255)
        {
            y+=5;
            x = 0;
            if (y == 255)
            {
                 z+=5;
                 y = 0;
                 if (z == 255)
                 {
                    z = 0;
                 }
            }
        }
        
        
        background.setColor(new Color(x,y,z));//Add Background color
        background.fillRect(0,0,getWidth(),getHeight());//Fill image with color
        System.out.println(x + " " + y + " " + z);
                     
    }
}
