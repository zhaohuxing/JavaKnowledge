public class ComplexByFactory {
	private final double re;
	private final double im;

	private ComplexByFactory(double re, double im) {
		this.re = re;
		this.im = im;
	}	

	public static ComplexByFactory valueOf(double re, double im) {
		return new ComplexByFactory(re, im);
	}

	public static ComplexByFactory valueOfAdd(double cRe, double cIm) {
		return new ComplexByFactory(re + cRE, im + cIm );
	}

	public static ComplexByFactory valueOfSub(double cRe, double cIm) {
		return new ComplexByFactory(re - cRe, im - cIm);
	}

	public static ComplexByFactory valueOfMul(double cRe, double cIm) {
		return new ComplexByFactory(re * cRe - im * cIm, re * cIm + im * cRe);
	}

	public static ComplexByFactory valueOfDiv(double cRe, double cIm) {
		double tmp = cRe * cRe + cIm * cIm;
		return new ComplexByFactory((re*cRe + im*cIm)/tmp, (im*cRe - re*cIm)/tmp);
	}

	//什么时候需要重写equals方法,像在这种方法中用不用重写？
	}
}
