import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static ArrayList QBank = new ArrayList<String>();
    public static ArrayList ABank = new ArrayList<String>();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        QBank.clear();
        
        QBank.add("Who won the Stanley Cup in 2018?");
        QBank.add("Who won the Stanley Cup in 2017?");
        QBank.add("Who won the Stanley Cup in 2016?");
        QBank.add("Who won the Stanley Cup in 2015?");
        QBank.add("Who won the Stanley Cup in 2014?");
        
        
        ABank.add("2018 Champ");
        ABank.add("2017 Champ");
        ABank.add("2016 Champ");
        ABank.add("2015 Champ");
        ABank.add("2014 Champ");
       
        
        addObject(new QuestionButton(), getWidth()/2, getHeight()/2);
        addObject(new AddQuestion(), getWidth()/4, getHeight()/2);
        
    }
}
