package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Random;

import javambs.RandomBehavior;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class RandomBehaviorTest
{
    @InjectMocks
    private RandomBehavior underTest;
    
    @Mock
    private Random random;
    
    private int testActionProbability = 30;
    
    @Before
    public void setup() {
        underTest = new RandomBehavior(testActionProbability);
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void shouldAct() {
        
        when(random.nextInt(100)).thenReturn(testActionProbability - 1);
        
        assertTrue(underTest.shouldAct());
    }
    @Test
    public void shouldNotAct(){
        when(random.nextInt(100)).thenReturn(testActionProbability);
        assertFalse(underTest.shouldAct());
    }
}
