package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import javambs.Behavior;
import javambs.BoundedEnv;
import javambs.Environment;
import javambs.Fish;
import javambs.Location;
import javambs.SlowFish;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SlowFishTest
{
    
    private Environment env;
    private Location originalLocation;
    private Fish underTest;

    @Before
    public void setup() {
        env = new BoundedEnv(5, 5);
        originalLocation = new Location(3, 3);
    }

    private void createSlowFish(Behavior behavior)
    {
        underTest = new SlowFish(env, originalLocation, behavior);
    }
    
    @Test
    public void shouldMove() {
         
        Behavior behavior = new Behavior() {
            @Override
          public boolean should() {
              return true;
          }
        };
        
        createSlowFish(behavior);
        underTest.act();
        
        Location newLocation = underTest.location();
        
        assertFalse(originalLocation.equals(newLocation));
    }
    
    @Test
    public void shouldNotMove() {
        
        createSlowFish(new Behavior()
        {
            @Override
            public boolean should()
            {
                return false;
            }
        });
        
        underTest.act();
        
        Location newLocation = underTest.location();
        
        assertTrue(originalLocation.equals(newLocation));
   }
}
