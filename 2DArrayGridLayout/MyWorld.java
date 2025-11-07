import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int[][] grid = new int[100][10];
    public static Actor[][] bg = new Actor[100][10];
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        for (int x = 0; x < 100; x++)
        {
            for (int y = 0; y < 7; y++)
            {
                grid[x][y] = 0;
            }
            for (int y = 7; y < 9; y++)
            {
                grid[x][y] = 1;
            }
            for (int y = 9; y < 10; y++)
            {
                grid[x][y] = 2;
            }
        }
        
        int st = 4;
        int towerH = 1 + Greenfoot.getRandomNumber(6);
        int towerW = 1 + Greenfoot.getRandomNumber(3);
        while ( (st + towerW) < 100)
        {
            for (int w = st; w < (st+towerW); w++)
            {
                for (int y = towerH; y < 7; y++)
                {
                    grid[w][y] = 3;
                }
            }
            
            st += 1 + Greenfoot.getRandomNumber(4) + towerW;
            towerW = 1 + Greenfoot.getRandomNumber(3);
            towerH = 1 + Greenfoot.getRandomNumber(6);
        }
            
        for (int x = 0; x < 100; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                int xLoc = x*Globals.width + Globals.width/2;
                int yLoc = y*Globals.height + Globals.height/2;
                if (grid[x][y] == 0)
                {
                    bg[x][y] = new Sky();
                }
                else if (grid[x][y] == 1)
                {
                    bg[x][y] = new Grass();
                }
                else if (grid[x][y] == 2)
                {
                    bg[x][y] = new Sand();
                }
                else if (grid[x][y] == 3)
                {
                    bg[x][y] = new Brick();
                }
                addObject(bg[x][y], xLoc, yLoc);
            }
        }
            
        addObject(new Person(), 120, 253);
    }
    
    public static void moveBGHoriz(int m)
    {
        for (int x = 0; x < 100; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                bg[x][y].setLocation(bg[x][y].getX() + m, bg[x][y].getY());
            }
        }
        
    }
}
