
public class Calculator {

	static final int ESCAPE_SQUARED = 40;
	static final int MAX_ITERATIONS = 300;

	private static int calculatePoint(double x, double y) {
		ComplexNumber c = new ComplexNumber(x, y);
		ComplexNumber z = new ComplexNumber(0, 0);
		int count = 0;
		while (z.getSize() < ESCAPE_SQUARED && count < MAX_ITERATIONS) {
			count++;
			z = z.multiply(z).add(c);
		//	z = z.reciprocal().add(c);
		}
		return count;
		//Z(0) = 1 + i
		//Z (i+1) = Z(i) + C
	}

	public static void render(double x, double y, double xMax, double yMax,
			Display d) {
		double xStep = (xMax - x) / d.width;
		double yStep = (yMax - y) / d.height;
		double yStart = y;
		for (int xPixel = 0; xPixel < d.width; xPixel++) {
			y = yStart;
			for (int yPixel = 0; yPixel < d.height; yPixel++) {
				// System.out.println(yPixel);
				int v = calculatePoint(x,y);
				d.set(xPixel, yPixel, v,v*v,v*v*v);
				y += yStep;
			}
			x += xStep;
		}
	}
}
