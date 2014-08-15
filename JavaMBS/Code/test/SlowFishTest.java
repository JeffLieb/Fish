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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SlowFishTest
{
    
    private Environment env;
    private Location originalLocation;
    
    @InjectMocks
    private Fish underTest;

    @Mock
    private Behavior behavior;
    
    @Before
    public void setup() {
        env = new BoundedEnv(5, 5);
        originalLocation = new Location(3, 3);
        underTest = new SlowFish(env, originalLocation);
        MockitoAnnotations.initMocks(this);
    }

    private void behaviorShouldReturn(boolean shouldAct)
    {
        Mockito.when(behavior.shouldAct()).thenReturn(shouldAct);
    }
    
    @Test
    public void shouldMove() {
         
        behaviorShouldReturn(true);

        underTest.act();
        
        Location newLocation = underTest.location();
        
        assertFalse(originalLocation.equals(newLocation));
    }
    
    @Test
    public void shouldNotMove() {
        
        behaviorShouldReturn(false);
        
        underTest.act();
        
        Location newLocation = underTest.location();
        
        assertTrue(originalLocation.equals(newLocation));
   }
}
