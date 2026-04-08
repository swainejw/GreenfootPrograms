import greenfoot.*;  

public class Fish extends Actor
{
    int frame = 1;
    int delay = 0;
    int speed = 2;

    public Fish()
    {
        setImage("fish1.png"); // start with first image
    }

    public void act()
    {
        setLocation(getX() - speed, getY()); // swim left
        
        animate();
        
        // remove when off screen
        if (getX() <= 0)
        {
            getWorld().removeObject(this);
            return;
        }
    }
    
    public void animate()
    {
        delay++;
        
        if (delay >= 3) // control animation speed
        {
            if (frame == 1)
            {
                setImage("fish2.png");
                frame = 2;
            }
            else if (frame == 2)
            {
                setImage("fish3.png");
                frame = 3;
            }
            else
            {
                setImage("fish1.png");
                frame = 1;
            }
            
            delay = 0;
        }
    }
}