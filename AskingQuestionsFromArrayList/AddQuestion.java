import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AddQuestion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AddQuestion extends Actor
{
    /**
     * Act - do whatever the AddQuestion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            String que = Greenfoot.ask("What question do you want to add?");
            MyWorld.QBank.add(que);
            String ans = Greenfoot.ask("What is the answer to that question?");
            MyWorld.ABank.add(ans);
        }
    }
}
