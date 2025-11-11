import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Objects from this class will simply appear on the screen,
 * scroll through a bunch of images, and then disappear, making
 * a "boom" sound in the process.  This version of the code
 * uses arrays - more complicated, but more elegant and much 
 * shorter.
 * 
 * @author  mrjswaine
 * @date    Nov 11 2025
 */
public class Explosion extends Actor
{
    // Used to cycle through the imgs
    SimpleTimer t = new SimpleTimer();
    
    // The sound of an explosion
    GreenfootSound s1 = new GreenfootSound("explosion.mp3");
    
    // All of the images that make up an "explosion" effect
    // held in an array
    GreenfootImage[] imgs = new GreenfootImage[15];
    
    // Every timeMultiple milliseconds, the image changes
    int timeMultiple = 100;
    
    // x allows for cycling through the images
    int count = 0;
    
    /**
     * The constructor plays the sound, loads the array, sets the first image to image one, and
     * starts the timer.
     */
    public Explosion()
    {
        s1.play();
        t.mark();
        
        for (int x = 0; x < 15; x++)
        {
            imgs[x] = new GreenfootImage("ex" + (x+1) + ".png");
        }
        
        setImage(imgs[0]);
    }   
    
    /**
     * Scrolls through the images
     */
    public void act() 
    {
        // Every 'timeMultiple' millis, the image will switch
        if ((t.millisElapsed() > count*timeMultiple) && (t.millisElapsed() < (count+1)*timeMultiple))
        {
            setImage(imgs[count]);
            count++;
        }
        
        // After the last image, the explosion object disappears
        if (t.millisElapsed() > (imgs.length-1)*timeMultiple) 
        {
            getWorld().removeObject(this);
        }
    }    
}
