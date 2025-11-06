import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// The following input/output library is needed to work with files
import java.io.*;

public class ShowHS extends Actor
{
    String name  = "";
    int highScore = 0;
    String highName = "";
    
    public void act() 
    {
        // if someone clicks on the button
        if (Greenfoot.mouseClicked(this))
        {
            try
            {
                MyWorld.l.setValue("");
                BufferedReader br = new BufferedReader(new FileReader("names_scores.txt"));
                
                String line = br.readLine();
                while (line != null)
                {
                    String[] info = line.split("-");
                    String name = info[0];
                    int number = Integer.parseInt(info[1]);
                    if (number > highScore)
                    {
                        highScore = number;
                        highName = name;
                    }
                    line = br.readLine();
                }
                br.close();
                
                String sentence = highScore + ": " + highName;
                MyWorld.l.setValue(sentence);
                
                MyWorld.c.setValue(0);
            }
            catch (IOException e)
            {
                 System.out.println("There was an error!");
            }
        }
    }    
}
