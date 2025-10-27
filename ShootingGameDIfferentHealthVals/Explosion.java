import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Objects from this class will simply appear on the screen,
 * scroll through a bunch of images, and then disappear, making
 * a "boom" sound in the process.
 * 
 * @author  mrjswaine
 * @date    October 4, 2019
 */
public class Explosion extends Actor
{
    SimpleTimer t = new SimpleTimer();
    
    // The sound of an explosion
    //GreenfootSound s1 = new GreenfootSound("explosion.mp3");
    
    // All of the images that make up an "explosion" effect
    // Note that all images must be in the "images" folder in
    // the files of the Greenfoot project
    GreenfootImage ex1 = new GreenfootImage("ex1.png");
    GreenfootImage ex2 = new GreenfootImage("ex2.png");
    GreenfootImage ex3 = new GreenfootImage("ex3.png");
    GreenfootImage ex4 = new GreenfootImage("ex4.png");
    GreenfootImage ex5 = new GreenfootImage("ex5.png");
    GreenfootImage ex6 = new GreenfootImage("ex6.png");
    GreenfootImage ex7 = new GreenfootImage("ex7.png");
    GreenfootImage ex8 = new GreenfootImage("ex8.png");
    GreenfootImage ex9 = new GreenfootImage("ex9.png");
    GreenfootImage ex10 = new GreenfootImage("ex10.png");
    GreenfootImage ex11 = new GreenfootImage("ex11.png");
    GreenfootImage ex12 = new GreenfootImage("ex12.png");
    GreenfootImage ex13 = new GreenfootImage("ex13.png");
    GreenfootImage ex14 = new GreenfootImage("ex14.png");
    GreenfootImage ex15 = new GreenfootImage("ex15.png");
    
    // Every x milliseconds, the image changes
    int timeMultiple = 25;
    
    /**
     * The constructor plays the sound, sets the first image to image one, and
     * starts the timer.
     */
    public Explosion()
    {
        //s1.play();
        setImage(ex1);
        t.mark();
    }   
    
    /**
     * Scrolls through the images
     */
    public void act() 
    {
        // Just a giant "if" statement that checks the time elapsed and sets the
        // images based on that
        if ((t.millisElapsed() > 0) && (t.millisElapsed() < 1*timeMultiple))
        {
            setImage(ex1);
        }
        else if ((t.millisElapsed() > 1*timeMultiple) && (t.millisElapsed() < 2*timeMultiple))
        {
            setImage(ex2);
        }
        else if ((t.millisElapsed() > 2*timeMultiple) && (t.millisElapsed() < 3*timeMultiple))
        {
            setImage(ex3);
        }
        else if ((t.millisElapsed() > 3*timeMultiple) && (t.millisElapsed() < 4*timeMultiple))
        {
            setImage(ex4);
        }
        else if ((t.millisElapsed() > 4*timeMultiple) && (t.millisElapsed() < 5*timeMultiple))
        {
            setImage(ex5);
        }
        else if ((t.millisElapsed() > 5*timeMultiple) && (t.millisElapsed() < 6*timeMultiple))
        {
            setImage(ex6);
        }
        else if ((t.millisElapsed() > 6*timeMultiple) && (t.millisElapsed() < 7*timeMultiple))
        {
            setImage(ex7);
        }
        else if ((t.millisElapsed() > 7*timeMultiple) && (t.millisElapsed() < 8*timeMultiple))
        {
            setImage(ex8);
        }
        else if ((t.millisElapsed() > 8*timeMultiple) && (t.millisElapsed() < 9*timeMultiple))
        {
            setImage(ex9);
        }
        else if ((t.millisElapsed() > 9*timeMultiple) && (t.millisElapsed() < 10*timeMultiple))
        {
            setImage(ex10);
        }
        else if ((t.millisElapsed() > 10*timeMultiple) && (t.millisElapsed() < 11*timeMultiple))
        {
            setImage(ex11);
        }
        else if ((t.millisElapsed() > 11*timeMultiple) && (t.millisElapsed() < 12*timeMultiple))
        {
            setImage(ex12);
        }
        else if ((t.millisElapsed() > 12*timeMultiple) && (t.millisElapsed() < 13*timeMultiple))
        {
            setImage(ex13);
        }
        else if ((t.millisElapsed() > 13*timeMultiple) && (t.millisElapsed() < 14*timeMultiple))
        {
            setImage(ex14);
        }
        else if ((t.millisElapsed() > 14*timeMultiple) && (t.millisElapsed() < 15*timeMultiple))
        {
            setImage(ex15);
        }
        else if (t.millisElapsed() > 15*timeMultiple) 
        {
            getWorld().removeObject(this);
        }
       
    }    
    
     
}
