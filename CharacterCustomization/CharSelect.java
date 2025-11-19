import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CharSelect extends World
{
    public static Hero h = new Hero();
    
    public CharSelect()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Label("Press 1 to be Mario", 24), 300, 25);
        addObject(new Label("Press 2 to be Luigi", 24), 300, 65);
        addObject(new Label("Press 3 to be Peach", 24), 300, 105);
        addObject(new Label("Press 4 to be Toad", 24), 300, 145);
        addObject(h, 300, 255);
        addObject(new Label("Press space to move to Level 1", 24), 300, 375);
    }
    
    public void act()
    { 
        if (Greenfoot.isKeyDown("1"))
        {
            h.changeImage(1);
        }
        else if (Greenfoot.isKeyDown("2"))
        {
            h.changeImage(2);
        }
        else if (Greenfoot.isKeyDown("3"))
        {
            h.changeImage(3);
        }
        else if (Greenfoot.isKeyDown("4"))
        {
            h.changeImage(4);
        }
        else if (Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new Level1());
        }
    }
    
}
