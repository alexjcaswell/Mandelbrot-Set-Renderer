
public class ComplexNumber {

	double real, imaginary;

	public ComplexNumber(double r, double i) {
		real = r;
		imaginary = i;
	}

	public ComplexNumber multiply(ComplexNumber o) {
		return new ComplexNumber(real * o.real - imaginary * o.imaginary, real
				* o.imaginary + imaginary * o.real);
	}

	public ComplexNumber add(ComplexNumber o) {
		return new ComplexNumber(real + o.real, imaginary + o.imaginary);
	}

	public double getSize() {
		return real * real + imaginary * imaginary;
	}
	
	public ComplexNumber reciprocal(){
		return new ComplexNumber(real/(real*real + imaginary*imaginary),-imaginary/(real*real + imaginary*imaginary));
	}
}
