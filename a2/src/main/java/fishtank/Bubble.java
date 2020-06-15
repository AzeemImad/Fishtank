package fishtank;
import java.awt.*;

/**
 * A bubble.
 */
public class Bubble extends FishTankEntity {

    /** How this bubble appears on the screen. */
    private String appearance;

    /** The font used to draw instances of this class. */
    static Font FONT = new Font("Monospaced", Font.PLAIN, 10);

    /** My colour. Ah, the vagaries of British vs. US spelling. */
    Color colour;

    /** Use for random movement left and right.  */
    public double d;

    /** This bubble's first coordinate. */
    int x;
    /** This bubble's second coordinate. */
    protected int y;

    /**
     * Constructs a new bubble at the specified cursor location (x, y).
     */
    public Bubble() {
        // Get a nice-looking grey for the bubble
         colour = Color.gray.darker().darker().darker();
         // start off with . as the appearance
        appearance = ".";
    }

    /**
     * Set this item's location.
     * @param a the first coordinate.
     * @param b  the second coordinate.
     */
    public void setLocation(int a, int b) {
        // set x to a
      x = a;
        // set y to b
      y = b;
    }

    @Override
    int getX() {
        return x;
    }

    @Override
    int getY() {
        return y;
    }

    /**
     * Draws the given string in the given graphics context at
     * at the given cursor location.
     *
     * @param  g  the graphics context in which to draw the string.
     * @param  s  the string to draw.
     * @param  x  the x-coordinate of the string's cursor location.
     * @param  y  the y-coordinate of the string's cursor location.
     */
    void drawString(Graphics g, String s, int x, int y) {
        g.setColor(colour);
        g.setFont(FONT);
        FontMetrics fm = g.getFontMetrics(FONT);
        g.drawString(s, y*fm.charWidth('W'), x*fm.getAscent());
    }


    /**
     * Draws this fish tank item.
     *
     * @param  g  the graphics context in which to draw this item.
     */
    void draw(Graphics g) {
        drawString(g, appearance, y, x);
    }

    public boolean sameCoordinates(int x, int y){
        boolean same = false;
        FishTankEntity e = FishTank.getEntity(x,y);
        if (e != null){
            if (e.getY() == this.getY() && e.getX() == e.getX())
                same = true;
        }
        return same;
    }



    /**
     * Causes this item to take its turn in the fish-tank simulation, moving straight up.
     */
    public void floatStraightUp() {

        // Move upwards.
        y--;
        x = x;// no change left or right
        if (y <= 4){
            appearance = " ";
            delete();
        }
        else{
            if (x >= 2){
                // check the right limit
                if (x >= 103 ){
                    if (sameCoordinates(x,y)){
                        this.floatLeftUp();
                    }
                    else{
                        x -= 1 ;
                    }
                }
            }
            else{
                if (sameCoordinates(x,y)){
                    this.floatLeftUp();
                }
                else{
                    x +=1;
                }

            }
            // Figure out whether to grow, if at all.
            d = Math.random();
            // Occasionally change a . to a o or a o to a O
            if (d < 0.05) {
                // If the appearance is a ., change it to an o
                if (appearance.equals("."))appearance="o";
                    // If the appearance is an o, change it to a O
                else if (appearance.equals("o"))appearance="O";
            }
        }
    }    /**
     * Causes this item to take its turn in the fish-tank simulation, moving up and left.
     */
    public void floatLeftUp() {

        // Move upwards.
        y--;
        x -= 1;// left
        if (y <= 4){
            appearance = " ";
            delete();
        }

        else{
            if (x >= 2){
                // check the right limit
                if (x >= 103 ){
                    if (sameCoordinates(x,y)){
                        this.floatRightUp();
                    }
                    else{
                        x -= 1 ;
                    }
                }
            }
            else{
                if (sameCoordinates(x,y)){
                    this.floatRightUp();
                }
                else{
                    x +=1;
                }

            }
            // Figure out whether to grow, if at all.
            d = Math.random();
            // Occasionally change a . to a o or a o to a O
            if (d < 0.05) {
                // If the appearance is a ., change it to an o
                if (appearance.equals("."))appearance="o";
                    // If the appearance is an o, change it to a O
                else if (appearance.equals("o"))appearance="O";
            }
        }
    }
    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    public void floatRightUp() {

        // Move upwards.
        y--;
        x += 1;// right
        if (y <= 2){
            appearance = " ";
            delete();
        }
        else{
            if (x >= 2){
                // check the right limit
                if (x >= 103 ){
                    if (sameCoordinates(x,y)){
                        this.floatLeftUp();
                    }
                    else{
                        x -= 1 ;
                    }
                }
            }
            else{
                if (sameCoordinates(x,y)){
                    this.floatLeftUp();
                }
                else{
                    x +=1;
                }

            }
            // Figure out whether to grow, if at all.
            d = Math.random();
            // Occasionally change a . to a o or a o to a O
            if (d < 0.05) {
                // If the appearance is a ., change it to an o
                if (appearance.equals("."))appearance="o";
                    // If the appearance is an o, change it to a O
                else if (appearance.equals("o"))appearance="O";
            }
        }

    }

    public void update() {
        d = Math.random();
        if (d < 0.33) {
            floatStraightUp();
        } else if (d < 0.66) {
            floatRightUp();
        } else /* fish.d >= 0.66 */ {
            floatLeftUp();
        }
    }
}
