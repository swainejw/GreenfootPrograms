import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Write a description of class KillScores here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KillScores extends Actor
{
    /**
     * Act - do whatever the KillScores wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            String confirm = Greenfoot.ask("You sure? Y for yes, anything else for no.");
            if (confirm.matches("y"))
            {
               try 
                {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("names_scores.txt"));
                    bw.close(); 
                }
                catch (IOException e)
                {
                    System.out.println("Something went wrong writing to the file.");
                } 
            }
            
            MyWorld.c.setValue(0);
        }
    }
}
