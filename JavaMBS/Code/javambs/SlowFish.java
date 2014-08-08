package javambs;

public class SlowFish extends Fish
{
    private Behavior moveBehavior;

    public SlowFish(Environment env, Location loc, Behavior moveBehavior)
    {
        super(env, loc);
        this.moveBehavior = moveBehavior;
    }

    @Override
    protected void move()
    {
        if (moveBehavior.should())
        {
            super.move();
        }
    }
}
