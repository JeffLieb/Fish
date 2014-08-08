package test;

import javambs.RandomBehavior;

import org.junit.Assert;
import org.junit.Test;

public class RandomBehaviorTest
{
    private RandomBehavior underTest;
    
    @Test
    public void shouldFoo() {
        underTest = new RandomBehavior(30) 
        {
            @Override
            protected int chooseRandom() {
                return 30;
            }
        };
        
        Assert.assertTrue(underTest.should());
    }
}
