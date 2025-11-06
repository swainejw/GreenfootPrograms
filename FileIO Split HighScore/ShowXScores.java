import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ShowXScores extends Actor
{
    ArrayList<String> allNames = new ArrayList<String>();
    ArrayList<Integer> allScores = new ArrayList<Integer>();

    ArrayList<String> highNames = new ArrayList<String>();
    ArrayList<Integer> highScores = new ArrayList<Integer>();
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            allNames.clear();
            allScores.clear();
            highNames.clear();
            highScores.clear();
            
            String strNum = Greenfoot.ask("How many of the top scores do you want to see?");
            int numScores = Integer.parseInt(strNum);
            System.out.print("\f");
            
            try
            {
                BufferedReader br = new BufferedReader(new FileReader("names_scores.txt"));
                String line = br.readLine();
                while (line != null)
                {
                    String[] info = line.split("-");
                    allNames.add(info[0]);
                    allScores.add(Integer.parseInt(info[1]));
                    line = br.readLine();
                }
                br.close();

                if (numScores <= allNames.size())
                {
                    for (int x = 0; x < numScores; x++)
                    {
                        int highVal = 0;
                        String highName = "";
                        int highIndex = 0;
                        for (int y = 0; y < allNames.size(); y++)
                        {
                            if (allScores.get(y) > highVal)
                            {
                                highVal = allScores.get(y);
                                highName = allNames.get(y);
                                highIndex = y;
                            }
                        }

                        highNames.add(highName);
                        highScores.add(highVal);
                        allNames.remove(highIndex);
                        allScores.remove(highIndex);
                    }

                    for (int x = 0; x < highNames.size(); x++)
                    {
                        System.out.println(highNames.get(x) + " - " + highScores.get(x));
                    }
                }
                else
                {
                    System.out.println("There aren't that many scores!");
                }
            }
            catch (IOException e)
            {
                System.out.println("There was an error!");
            }
        }
    }
}
