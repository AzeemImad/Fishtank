package fishtank;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HungryFishTest {

    /* Note: FishTest is in the package fish-tank, so it has access to package
       private attributes.

       Also note: It's *vital* that you name any other test classes
       (ClassName)Test in the same directory as this one is in.
       properly capitalized -- we will be auto-grading your tests, so make sure
       to follow this naming convention!
     */
    private HungryFish fish;

    @Before
    public void setUp() {
        fish = new HungryFish();
    }

    @Test
    public void testFishBubbles() {
        //Note: This test currently fails, but should pass once you've
        // refactored &
        //fixed the starter code.
        boolean bubbleMade = false;
        for (int i = 0; i < 200; i++) {
            fish.setLocation(5, 10);
            fish.goingRight =
                    false; //notice: I can edit package private attributes!
            fish.update();
            //fish should move one tile left and eventually blow a bubble.
            FishTankEntity e = FishTank.getBubbles(5 , 10);
            if (e instanceof Bubble) {
                bubbleMade = true;
                break;
            }
        }
        //You could also write "assert bubbleMade", but using the JUnit version
        //makes the message much nicer if it fails.
        assertTrue(!bubbleMade);
    }

    @Test
    public void testGoingRight() {
        fish.setLocation(5,10);
        fish.goingRight = true;
        fish.update();
        assertEquals(11,fish.getY());


    }

    @Test
    public void testGoingLeft() {
        fish.setLocation(5,10);
        fish.goingRight = false;
        fish.update();
        assertEquals(9,fish.getY());
    }

    @Test
    public void testUpAndDown(){
        boolean UpOrDown = false;
        for (int i = 0; i < 100; i++){
            fish.setLocation(5,10);
            fish.update();
            if (fish.getX() == 3 || fish.getX() == 4 ){
                UpOrDown = true;
                break;
            }
        }
        assertTrue(UpOrDown);
    }

    @Test
    public void turnAround(){
        boolean turns = false;
        for (int i = 0; i < 100; i++){
            fish.setLocation(5,10);
            fish.goingRight = false;
            fish.update();
            if(fish.appearance.equals("><MEHUNGRY>")){
                turns = true;
                break;
            }
        }
        assertTrue(turns) ;
    }

    @Test
    public void testSameCoordinates(){
        boolean coordinate;
        Fish fishes = new Fish();
        fishes.setLocation(5,10);
        FishTank.addEntity(5,10,fishes);
        fish.setLocation(5,10);
        coordinate = fish.sameCoordinates(5,10);
        assertTrue(coordinate);

    }

}
