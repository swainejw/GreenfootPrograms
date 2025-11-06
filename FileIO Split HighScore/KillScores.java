import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class KillScores extends Actor
{
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
