import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    String[] messages = new String[5];
    
    public Button()
    {
        messages[0] = "Hello there!";
        messages[1] = "You pressed the button!";
        messages[2] = "Greenfoot is fun!";
        messages[3] = "Random message appears!";
        messages[4] = "Olivia is great";
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            int randomNum = Greenfoot.getRandomNumber(5);
            System.out.println(randomNum);
            MyWorld.l.setValue(messages[randomNum]);
        }
    }
}
