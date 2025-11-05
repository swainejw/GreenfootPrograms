import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

public class SaveScore extends Actor
{
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            String strName = Greenfoot.ask("First Name: ");
            try 
            {
                BufferedWriter bw = new BufferedWriter(new FileWriter("names_scores.txt", true));
                bw.write(strName + "-" + MyWorld.c.getValue() + "\n");
                bw.close(); 
            }
            catch (IOException e)
            {
                System.out.println("Something went wrong writing to the file.");
            }
            
            MyWorld.c.setValue(0);
        }
    }    
}
