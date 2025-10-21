import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// The following 3 libraries are needed to show a popup window to the user where
// they can put in their name
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;

public class ReadIn extends Actor
{
    public void act() 
    {
        // if someone clicks on the button
        if (Greenfoot.mouseClicked(this))
        {
            // Create a blank String called 'names'
            String names = "";
            // a try catch loop means to TRY to execute the code, but if something goes
            // wrong, run the code in the catch section (like error handling)
            try
            {
                // We attempt to create a buffered reader, that we will use to read
                // information from the file 'names.txt'.  Note that 'names.txt' is a 
                // text file that must already exist in the main Greenfoot project folder
                BufferedReader br = new BufferedReader(new FileReader("names.txt"));
                // We read a line from the text file and store it as a String called 'currLine'
                String currLine = br.readLine();
                // As long as 'currLine' is not NULL, let's keep reading lines and add them
                // to the String called "names", with a new line character in between
                while (currLine != null)
                {
                    // Add the value of currLine to the names String and add a new line character
                    names += currLine + "\n";
                    // Read the next line and overwrite the value of currLine
                    currLine = br.readLine();
                }
                
                // Once we reach this point, we must be done reading the file, because we read
                // a NULL character (indicating there are no more lines to read)
                br.close();
                // Show a popup window that shows all of the names that were read from the file
                // proving that we were able to read it properly
                System.out.println(names);
            }
            // This the "catch" part of the try/catch structure.  If anything goes wrong when
            // trying to execute the code in the 'try' part, the code in the 'catch' part will
            // run. The parameter 'e' contains information about the error that we can display
            // to the user.  The most common error occurs when there is no file to read, or
            // the file is already in use.
            catch (IOException e)
            {
                 JOptionPane.showMessageDialog(new JInternalFrame(), "No file by that name.");
            }
        }
    }    
}
