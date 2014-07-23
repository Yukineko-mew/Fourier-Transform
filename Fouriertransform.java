/**
 * 
 */
package FT;

/**
 * @author b1012213
 *
 */

/**
 * 離散フーリエ変換を行うプログラム
 * 
 * 
 */

public class Fouriertransform {
	
	private final int MAX_DATA;	
	
	private double [] real;
	private double [] imaginary;
	
	public Fouriertransform(int maxData) {
		MAX_DATA = maxData;
		real = new double[MAX_DATA];
		imaginary = new double[MAX_DATA];
	}
	
	public void testFft() {
//		double [] testData = new double[MAX_DATA];
//		double [] empty = new double[MAX_DATA];
		for(int i=0; i<MAX_DATA; i++) {
			imaginary[i] = 0.0;
			real[i] = Math.random();
		}
		fftCalc(real, imaginary);
	}
	
	private void fftCalc(double [] theReal, double [] theImaginary) {
		int num = MAX_DATA;
		double theta = -2*Math.PI/num;
		fft(num, theta, theReal, theImaginary);
	}
	
	private void fft(int num, double theta, double [] theReal, double [] theImaginary) {
		if( num <= 1 ) return ;
		
		int halfNum = num/2;
		double [] realOdd = new double[halfNum];
		double [] imaginaryOdd = new double[halfNum];
		double [] realEven = new double[halfNum];
		double [] imaginaryEven = new double[halfNum];
		
		for( int m=0; m<halfNum; m++) {
			realEven[m] = theReal[m] + theReal[halfNum+m];
			imaginaryEven[m] =  theImaginary[m] + theImaginary[halfNum+m];
			double Rm = theReal[m] - theReal[halfNum+m];
			double Im = theImaginary[m] - theImaginary[halfNum+m];
			double cos = Math.cos(m*theta);
			double sin = Math.sin(m*theta);
			
			realOdd[m] = Rm*cos - Im*sin;
			imaginaryOdd[m] = Rm*sin + Im*cos;
		}
		
		fft(halfNum, 2*theta, realEven, imaginaryEven);
		fft(halfNum, 2*theta, realOdd, imaginaryOdd);
		
		
		
		for(int i=0; i<halfNum; i++) {
			theReal[2*i] = realEven[i];
			theReal[2*i+1] = realOdd[i];
			theImaginary[2*i] = imaginaryEven[i];
			theImaginary[2*i+1] = imaginaryOdd[i];
		}
	}
	
	public void show() {
		for(int i=0; i<MAX_DATA; i++) {
			System.out.println("real = [" + real[i] + "], imaginary = [" + imaginary[i] + "]");
		}
	}
	
	public double [] getReal() {
		return real;
	}
	
	public double [] getImaginary() {
		return imaginary;
	}
}