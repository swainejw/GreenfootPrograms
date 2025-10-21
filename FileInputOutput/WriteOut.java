import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// The following 3 libraries are needed to show a popup window to the user where
// they can put in their name
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;

public class WriteOut extends Actor
{
    public void act() 
    {
        // if someone clicks on the button
        if (Greenfoot.mouseClicked(this))
        {
            // Create a string called 'strName'.  The value of that is going to be whatever the user types in as input
            // when the popup window comes up.  So if they follow the prompt, it should be their first name.
            String strName = JOptionPane.showInputDialog("First Name: ");
            // a try catch loop means to TRY to execute the code, but if something goes
            // wrong, run the code in the catch section (like error handling)
            try 
            {
                // We create a buffered writer object called 'bw'.  This object is something we use in Java to WRITE
                // information out to a file.  In this example, we are going to open the file called 'names.txt' and 
                // add the value of 'strName' to the file.  The ", true" is needed to indicate that we want to open 
                // the existing file and add content to it.  Without that, the program would just create a brand
                // new file, overwriting any file of the same name that might already exist.
                
                // So we create the BufferedWriter, allowing us to read 'names.txt'
                BufferedWriter bw = new BufferedWriter(new FileWriter("names.txt", true));
                // Now, we tell the computer to add the value of 'strName' and a new line character to the end of the file
                bw.write(strName + "\n");
                // Now, we close the BufferedWriter object (so other programs can access the file again)
                bw.close();
                // Lastly, we issue a message saying that we successfully added the name.
                JOptionPane.showMessageDialog(new JInternalFrame(), strName + " added.");
            }
            // This the "catch" part of the try/catch structure.  If anything goes wrong when
            // trying to execute the code in the 'try' part, the code in the 'catch' part will
            // run. The parameter 'e' contains information about the error that we can display
            // to the user.  The most common error occurs when the program doesn't have permission
            // to create a file on the drive.
            catch (IOException e)
            {
                System.out.println("Something went wrong writing to the file.");
                // This prints the error message from the stack (the complex computer error code)
                
            }
        }
    }    
}
