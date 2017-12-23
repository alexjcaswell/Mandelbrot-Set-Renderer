
public class Fractal {

	public static final int WIDTH = 1000, HEIGHT = 1000;
	// public static final double ZOOM_AMOUNT = 1.01;
	static double x, y, xEnd, yEnd, zoom = 2;
	static Display d;

	public static void main(String[] args) {
		d = new Display(WIDTH, HEIGHT);
		d.addMouseListener(new Mouse());
		calculateView(0, 0);
		Calculator.render(x, y, xEnd, yEnd, d);
		d.render();

	}

	public static void click(int mouseX, int mouseY, double zoomAmount) {
		double xx = ((double) mouseX / d.width) * zoom * 2 + x;
		double yy = ((double) mouseY / d.height) * zoom * 2 + y;
		zoom /= zoomAmount;
		calculateView(xx, yy);
		Calculator.render(x, y, xEnd, yEnd, d);
		d.render();
	}

	private static void calculateView(double centerX, double centerY) {
		x = centerX - zoom;
		y = centerY - zoom;
		xEnd = centerX + zoom;
		yEnd = centerY + zoom;
	}
}
