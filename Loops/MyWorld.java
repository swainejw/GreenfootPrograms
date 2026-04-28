import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int counter = 0;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        counter = 0;
    }
    
    public void act() {
        counter++;
        
        if (counter % 100 < 50) {
            showText("HELLO!", 200, 150);
        } else {
            showText("", 200, 150); // clears it
        }
    }
}
