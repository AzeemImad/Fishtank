package fishtank;
import java.awt.*;

/**
 * A fish.
 */
public class HungryFish extends FishTankEntity {

    /** How this fish appears on the screen. */
    public String appearance;

    /** Indicates whether this fish is moving right. */
    boolean goingRight;

    /** This fish's first coordinate. */
    int r;
    /** This fish's second coordinate. */
    int c;
    /** The colour of this fish. */
    private Color colour;


    /**
     * Constructs a new hungry fish.
     */
    public HungryFish() {
        colour = Color.cyan.darker().darker().darker();
        appearance = "><MEHUNGRY>";
        goingRight = true;
    }


    /**
     * Set this item's location.
     * @param a the first coordinate.
     * @param b  the second coordinate.
     */
    public void setLocation(int a, int b) {
        r = a;
        c = b;
    }

    int getX() {
        return r;
    }

    int getY() {
        return c;
    }


    /**
     * Causes this fish to blow a bubble.
     */
    protected void blowBubble() {
        Bubble b = new Bubble();
        b.setLocation(r, c);
        System.out.println(r + " " + c);

        FishTank.addEntity(r, c, b);
    }



    /**
     * Build and initialize this fish's forward and backward
     * appearances.
     */
    private String reverseAppearance() {
        System.out.println("Turning around" + this.appearance);
        String reverse = "";
        for (int i=appearance.length()-1; i>=0; i--) {
            switch (appearance.charAt(i)) {
                case ')': reverse += '('; break;
                case '(': reverse += ')'; break;
                case '>': reverse += '<'; break;
                case '<': reverse += '>'; break;
                case '}': reverse += '{'; break;
                case '{': reverse += '}'; break;
                case '[': reverse += ']'; break;
                case ']': reverse += '['; break;
                default: reverse += appearance.charAt(i); break;
            }
        }
        System.out.println("Turned around" + this.appearance);
        appearance = reverse;
        return reverse;
    }


    /**
     * Turns this fish around, causing it to reverse direction.
     */
    protected void turnAround() {
        goingRight = !goingRight;
        if (goingRight) {
            appearance = reverseAppearance();
        } else {
            appearance = reverseAppearance();
        }
    }

    public void setGoingRight(boolean goingRight) {
        this.goingRight = goingRight;
    }

    /** The font used to draw instances of this class. */
    static Font FONT = new Font("Monospaced", Font.PLAIN, 10);


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
     * Draws this fish tank item.
     *
     * @param  g  the graphics context in which to draw this item.
     */
    void draw(Graphics g) {
        drawString(g, appearance, r, c);
    }

    public void update() {

        // turn around if same coordinates
        if(sameCoordinates(r,c)){ turnAround();}

        // Move one spot to the right or left.
        if (goingRight) {
            if (FishTank.getEntity(r, c+1) == null){
                if (c < 46){ c += 1; }
            }
            else if (FishTank.getEntity(r, c-1)== null){
                turnAround();
                if (c > 1){ c -= 1; }
            }
        } else {
            if (FishTank.getEntity(r, c-1)== null){
                if (c > 1){ c -= 1; }
            }
            else if (FishTank.getEntity(r, c+1) == null){
                turnAround();
                if (c < 46){ c += 1; }
            }
        }

        // Figure out whether I blow a bubble.
        double d = Math.random();
        if (d < 0.1) { blowBubble(); }

        // Figure out whether I turn around.
        d = Math.random();
        if (d < 0.1) { turnAround(); }

        // Figure out whether to move up or down, or neither.
        d = Math.random();
        if (d < 0.1) {
            if (FishTank.getEntity(r+1, c)== null){
                if (r < 103){ r += 1; }
            }
            else if (FishTank.getEntity(r-1, c)==null){
                turnAround();
                if (r > 4){ r -= 1; }
            }

        } else if (d < 0.2) {
            if (FishTank.getEntity(r-1, c)==null){
                if (r > 4){ r -= 1; }
            }
            else if (FishTank.getEntity(r+1, c)== null){
                if (r < 103){ r += 1;}
            }

        }
    }
}
