import greenfoot.*;

public class Notes extends Actor
{
    // Create sound objects
    private GreenfootSound beep = new GreenfootSound("beep.wav");
    private GreenfootSound music = new GreenfootSound("background.mp3");

    public void act()
    {
        // Play a one-time sound
        if (Greenfoot.isKeyDown("1"))
        {
            beep.play();
            Greenfoot.delay(5); // prevents rapid repeats
        }

        // Start looping background music
        if (Greenfoot.isKeyDown("2"))
        {
            music.playLoop();
            Greenfoot.delay(10);
        }

        // Stop the looping music
        if (Greenfoot.isKeyDown("3"))
        {
            music.stop();
            Greenfoot.delay(10);
        }

        // Volume up
        if (Greenfoot.isKeyDown("up"))
        {
            adjustVolume(music, +5);
            adjustVolume(beep, +5);
            Greenfoot.delay(5);
        }

        // Volume down
        if (Greenfoot.isKeyDown("down"))
        {
            adjustVolume(music, -5);
            adjustVolume(beep, -5);
            Greenfoot.delay(5);
        }
    }

    /** Safely adjust volume (0–100) */
    private void adjustVolume(GreenfootSound sound, int amount)
    {
        int newVol = sound.getVolume() + amount;

        if (newVol > 100) 
        {
            newVol = 100;
        }
        if (newVol < 0) 
        {
           newVol = 0; 
        }

        sound.setVolume(newVol);
        //System.out.println(sound + " volume: " + newVol);
    }
}
