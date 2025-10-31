import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
/**
 * Write a description of class QuestionButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuestionButton extends Actor
{
    /**
     * Act - do whatever the QuestionButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            int rn = Greenfoot.getRandomNumber(10);
            
            String ans = JOptionPane.showInputDialog(new JInternalFrame(), MyWorld.QBank.get(rn),"Question", JOptionPane.INFORMATION_MESSAGE);
            if (ans.equals(MyWorld.ABank.get(rn)))
            {
                JOptionPane.showMessageDialog(new JInternalFrame(), "Correct!");
            
            }
            else
            {
                JOptionPane.showMessageDialog(new JInternalFrame(), "Incorrect!");
            
            }
            
        }
    }    
}
