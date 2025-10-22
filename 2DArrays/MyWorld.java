import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    // Creates a 2-D array called myBananas which
    // will hold Banana objects -- it will be 4x10
    Banana[][] myBananas = new Banana[10][4];    
    int iHVal = 5;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        loadBananaArray();
        
    }
    
    public void act()
    {
        moveBananas();
        if (checkForWall() == true)
        {
            iHVal = iHVal *= -1;
            //moveEnemiesDown();
        }
    }
    
    public void loadBananaArray()
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 4; y++)
            {
                myBananas[x][y] = new Banana();
                addObject(myBananas[x][y], 100 + 50*x, 50 + 50*y);
            }
        }
    
    }
    
    public void moveBananas()
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 4; y++)
            {
                int xLoc = myBananas[x][y].getX();
                int yLoc = myBananas[x][y].getY();
                myBananas[x][y].setLocation(xLoc + iHVal, yLoc);
            }
        }
    
    }
    
    public boolean checkForWall()
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 4; y++)
            {
                int xLoc = myBananas[x][y].getX();
                if (xLoc > getWidth() - 10)
                {
                    return true;
                }
                if (xLoc < 10)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    
}
