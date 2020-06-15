package fishtank;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeaweedTest {

    private Seaweed seaweed;

    @Before
    public void SetUp(){
        seaweed = new Seaweed(7);
    }

    @Test
    public void testSameCoordinates(){
        boolean touch;
        Fish fish = new Fish();
        fish.setLocation(5,10);
        seaweed.setLocation(5,10);
        touch = fish.sameCoordinates(5,10);
        assertFalse(touch);

    }

    @Test
    public void testUpdate(){
        seaweed.leanRight = true;
        seaweed.update();

        assertEquals(seaweed.leanRight= false, seaweed.leanRight);

    }

    @Test
    public void testNewLength(){
        seaweed.setLocation(5,10);
        Fish fish = new Fish();
        fish.setLocation(5,10);
        FishTank.addEntity(5,10,fish);
        seaweed.update();
        assertEquals(7,seaweed.newLength);
    }

}