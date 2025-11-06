import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ShowAllScores extends Actor
{
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            System.out.print("\f");
            
            try
            {
                BufferedReader br = new BufferedReader(new FileReader("names_scores.txt"));
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
