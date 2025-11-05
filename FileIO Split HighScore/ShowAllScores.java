import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Write a description of class ShowAllScores here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShowAllScores extends Actor
{
    /**
     * Act - do whatever the ShowAllScores wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            try
            {
                BufferedReader br = new BufferedReader(new FileReader("names_scores.txt"));
                // We read a line from the text file and store it as name
                String line = br.readLine();
                while (line != null)
                {
                    System.out.println(line);
                    line = br.readLine();
                }
                br.close();
            }
            catch (IOException e)
            {
                 System.out.println("There was an error!");
            }
        }
    }
}
