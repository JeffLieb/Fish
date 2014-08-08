package javambs;

public class RandomBehavior implements Behavior
{
    private int percentage;

    public RandomBehavior(int percentage)
    {
        this.percentage = percentage;
        // TODO Auto-generated constructor stub
    }

    protected int chooseRandom()
    {
        return 0;
    }

    @Override
    public boolean should()
    {
        // TODO Auto-generated method stub
        return false;
    }

}
