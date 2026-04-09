import greenfoot.*;

public class Barrier extends Actor
{
    int height = 300;

    public Barrier()
    {
        getImage().scale(40, height);
    }

    public void act()
    {
        Net n = (Net) getOneIntersectingObject(Net.class);
        if (n != null)
        {
            height -= 50;
            getWorld().removeObject(n);

            if (height > 0)
            {
                GreenfootImage g = getImage();
                g.scale(40, height);
                setImage(g);
            }
            else
            {
                getWorld().removeObject(this);
            }
        }
    }
}
