package javambs;

import java.util.Random;

public class RandomBehavior implements Behavior
{
    private int percentage;
    private Random random = new Random();
    
    public RandomBehavior(int percentage)
    {
        this.percentage = percentage;
    }

    private int chooseRandom()
    {
        return random.nextInt(100);
    }

    public boolean shouldAct()
    {
        return chooseRandom() < percentage;
    }

}
