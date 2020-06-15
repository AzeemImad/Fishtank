package fishtank;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {
    private Bubble bubble;


    @Before
    public void setUp() {
        bubble = new Bubble();
    }

    @Test
    public void testDelete(){
        boolean exist;
        bubble.setLocation(1,1);
        exist = bubble.exists();
        assertTrue(exist);

    }

    @Test
    public void testUp(){
        bubble.setLocation(10,10);
        bubble.floatStraightUp();
        assertEquals(9,bubble.getY());

    }

    @Test
    public void testRightUp(){
        bubble.setLocation(10,10);
        bubble.floatRightUp();
        assertEquals(9,bubble.getY());
        assertEquals(11,bubble.getX());
    }

    @Test
    public void testLeftUp(){
        bubble.setLocation(10,10);
        bubble.floatLeftUp();
        assertEquals(9,bubble.getY());
        assertEquals(9,bubble.getX());
    }

    @Test
    public void testUpdate(){
        boolean updates = false;
        for (int i = 0; i < 200; i++){
            bubble.setLocation(10,10);
            bubble.update();
            if (bubble.getY() == 9){
                updates = true;
                break;
            }
        }
        assertTrue(updates);
    }

}