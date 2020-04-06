import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * <p>
 * Create a cable car in a graphics window
 * </p>
 * 
 * @author YonasAbraha
 */

public class CableCar {

	// Your instance fields go here
	private GWindow window;
	private int x, y;
	private double scale;
	private Rectangle cableCar, window1, window2, window3;
	private Line leftWire, rightWire;
	private int dx = 40;

	/**
	 * Create a cable car at location (x,y) in the GWindow window.
	 * 
	 * @param x the x coordinate of the center of the cable car
	 * @param y the y coordinate of the center of the cable car
	 * @scale the factor that multiplies all default dimensions for this cable car
	 *        (e.g. if the default size is 80, the size of this cable car is scale *
	 *        80)
	 * @window the graphics window this cable car belongs to
	 */
	public CableCar(int x, int y, double scale, GWindow window) {
		// initialize the instance fields
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;
		// The details of the drawing are in a private method
		this.draw();
	}

	/** Draw a cable car at location (x,y) */
	private void draw() {
		this.cableCar = new Rectangle(this.x - (int) (40 * this.scale), this.y + (int) (30 * this.scale),
				(int) (120 * this.scale), (int) (60 * this.scale), Color.BLUE, true);
		this.window.add(cableCar);

		this.window1 = new Rectangle(this.x - (int) (28 * scale), this.y + (int) (40 * scale), (int) (20 * this.scale),
				(int) (20 * this.scale), Color.WHITE, true);
		this.window.add(window1);

		this.window2 = new Rectangle(this.x + (int) (8 * scale), this.y + (int) (40 * scale), (int) (20 * this.scale),
				(int) (20 * this.scale), Color.WHITE, true);
		this.window.add(window2);

		this.window3 = new Rectangle(this.x + (int) (45 * scale), this.y + (int) (40 * scale), (int) (20 * this.scale),
				(int) (20 * this.scale), Color.WHITE, true);
		this.window.add(window3);

		Line carLine = new Line(0, this.y - (int) (scale * 10), this.x + (int) (scale * 430),
				this.y - (int) (scale * 10), Color.BLACK);
		this.window.add(carLine);

		this.leftWire = new Line(this.x + (int) (15 * scale), this.y - (int) (scale * 10), this.x - (int) (scale * 15),
				this.y + (int) (scale * 30), Color.BLACK);
		this.window.add(leftWire);

		this.rightWire = new Line(this.x + (int) (15 * scale), this.y - (int) (scale * 10), this.x + (int) (scale * 45),
				this.y + (int) (scale * 30), Color.BLACK);
		this.window.add(rightWire);

		this.window.doRepaint();

	}

	/**
	 * @dx x-displacement
	 */
	public void move() {
		this.cableCar.moveBy(dx, 0);
		this.window1.moveBy(dx, 0);
		this.window2.moveBy(dx, 0);
		this.window3.moveBy(dx, 0);
		this.leftWire.moveBy(dx, 0);
		this.rightWire.moveBy(dx, 0);
		x += dx;

		if (this.cableCar.getX() >= this.window.getWindowWidth()) {
			dx = -dx;
		}
		if (this.cableCar.getX() <= 0) {
			dx = -dx;
		}
	}

}
