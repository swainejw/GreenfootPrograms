import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class DefenderWorld extends World
{

private int baseHeight;

    public DefenderWorld()
    {    
        super(800, 400, 1);
        baseHeight = 300;

        // Initial ground line
        for (int x = 0; x < getWidth(); x += 3)
        {
            addObject(new GroundTile(), x, baseHeight);
        }
    }

    public void act()
    {
        spawnNewTiles();
    }

    private void spawnNewTiles()
    {
        List<GroundTile> tiles = getObjects(GroundTile.class);

        int rightMostX = 0;
        int rightMostY = baseHeight;

        for (GroundTile oneTile : tiles)
        {
            if (oneTile.getX() > rightMostX)
            {
                rightMostX = oneTile.getX();
                rightMostY = oneTile.getY();
            }
        }

        // If there's space on right, spawn new tile
        if (rightMostX < getWidth() - 3)
        {
            int newY = rightMostY + Greenfoot.getRandomNumber(3) - 1; // -1, 0, +1
            
            // Optional: clamp height so it doesn't go crazy
            newY = Math.max(200, Math.min(getHeight(), newY));

            addObject(new GroundTile(), rightMostX + 3, newY);
        }
    }

}
