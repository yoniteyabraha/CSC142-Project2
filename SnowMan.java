import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * <p>
 * Create a snow man in a graphics window
 * </p>
 * 
 * @author YonasAbraha
 */

public class SnowMan {

	// Your instance fields go here
	private GWindow window;
	private int x, y;
	private double scale;

	private Rectangle hat, hatBase;
	private Line leftHand, rightHand, leftFinger, rightFinger;
	private int dy = 7;
	private int angle = 10;

	/**
	 * Create a snow man in at location (x,y) in the GWindow window.
	 * 
	 * @param x the x coordinate of the center of the head of the snow man
	 * @param y the y coordinate of the center of the head of the snow man
	 * @scale the factor that multiplies all default dimensions for this snow man
	 *        (e.g. if the default head radius is 20, the head radius of this snow
	 *        man is scale * 20)
	 * @window the graphics window this snow man belongs to
	 */
	public SnowMan(int x, int y, double scale, GWindow window) {
		// initialize the instance fields
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;
		// Put the details of the drawing in a private method
		this.draw();
	}

	/** Draw in the graphics window a snow man at location (x,y) */
	private void draw() {
		Oval head = new Oval(this.x, this.y, (int) (30 * this.scale), (int) (30 * this.scale), Color.WHITE, true);
		this.window.add(head);

		Oval leftEye = new Oval(this.x + (int) (5 * this.scale), this.y + (int) (9 * this.scale),
				(int) (5.0 * this.scale), (int) (5.0 * this.scale), Color.BLACK, true);
		this.window.add(leftEye);

		Oval rightEye = new Oval(this.x + (int) (20 * this.scale), this.y + (int) (9 * this.scale),
				(int) (5.0 * this.scale), (int) (5.0 * this.scale), Color.BLACK, true);
		this.window.add(rightEye);

		Triangle nose = new Triangle(this.x + (int) (20 * this.scale), this.y + (int) (20 * this.scale),
				this.x + (int) (10 * this.scale), this.y + (int) (20 * this.scale), this.x + (int) (15 * this.scale),
				this.y + (int) (15 * this.scale), Color.ORANGE, true);
		this.window.add(nose);

		Rectangle mouth = new Rectangle(this.x + (int) (8 * this.scale), this.y + (int) (23 * this.scale),
				(int) (15 * this.scale), (int) (3 * this.scale), Color.BLACK, true);
		this.window.add(mouth);

		this.hat = new Rectangle(this.x + (int) (8 * this.scale), this.y - (int) (33 * this.scale),
				(int) (15 * this.scale), (int) (30 * this.scale), Color.RED, true);
		this.window.add(hat);

		this.hatBase = new Rectangle(this.x + (int) (0.9 * this.scale), this.y - (int) (4 * this.scale),
				(int) (30 * this.scale), (int) (5 * this.scale), Color.YELLOW, true);
		this.window.add(hatBase);

		Oval body = new Oval(this.x - (int) (scale * 10), this.y + (int) (scale * 26), (int) (50 * this.scale),
				(int) (50 * this.scale), Color.WHITE, true);
		this.window.add(body);

		Oval button1 = new Oval(this.x + (int) (scale * 12), this.y + (int) (scale * 35), (int) (5.0 * this.scale),
				(int) (5.0 * this.scale), Color.BLACK, true);
		this.window.add(button1);

		Oval button2 = new Oval(this.x + (int) (scale * 12), this.y + (int) (scale * 50), (int) (5.0 * this.scale),
				(int) (5.0 * this.scale), Color.BLACK, true);
		this.window.add(button2);

		Oval button3 = new Oval(this.x + (int) (scale * 12), this.y + (int) (scale * 65), (int) (5.0 * this.scale),
				(int) (5.0 * this.scale), Color.BLACK, true);
		this.window.add(button3);

		this.leftHand = new Line(this.x + (int) (scale * 7), this.y + (int) (scale * 35), this.x - (int) (scale * 25),
				this.y + (int) (scale * 35), Color.BLACK);
		this.window.add(leftHand);

		this.rightHand = new Line(this.x + (int) (scale * 10) + (int) (scale * 12), this.y + (int) (scale * 35),
				this.x + (int) (scale * 53), this.y + (int) (scale * 35), Color.BLACK);
		this.window.add(rightHand);

		this.leftFinger = new Line(this.x - (int) (scale * 20), this.y + (int) (scale * 35),
				this.x - (int) (scale * 25), this.y + (int) (scale * 30), Color.BLACK);
		this.window.add(leftFinger);

		this.rightFinger = new Line(this.x + (int) (scale * 47), this.y + (int) (scale * 35),
				this.x + (int) (scale * 54), this.y + (int) (scale * 30), Color.BLACK);
		this.window.add(rightFinger);

	}

	public void moveArmsAndHat() {
		this.hat.moveBy(0, dy);
		this.hatBase.moveBy(0, dy);
		this.leftHand.rotateAround(this.x + (int) (scale * 22), this.y + (int) (scale * 35), angle);
		this.leftFinger.rotateAround(this.x + (int) (scale * 22), this.y + (int) (scale * 35), angle);
		this.rightFinger.rotateAround(this.x + (int) (scale * 22), this.y + (int) (scale * 35), angle);
		this.rightHand.rotateAround(this.x + (int) (scale * 22), this.y + (int) (scale * 35), angle);
		angle = -angle;

		if (this.hat.getY() >= 1) {
			dy = -dy;
		}
		if (this.hat.getY() <= 1) {
			dy = -dy;
		}

	}
}
