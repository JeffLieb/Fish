package javambs;

public class SlowFish extends Fish
{
    private Behavior moveBehavior;

    public SlowFish(Environment env, Location loc)
    {
        super(env, loc);
        this.moveBehavior = new RandomBehavior(30);
    }

    @Override
    protected void move()
    {
        if (moveBehavior.shouldAct())
        {
            super.move();
        }
    }
}
