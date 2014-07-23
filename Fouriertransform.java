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
	private int [] coef = {0, 1, 2, 8, 16};	
	private double [] dataset;
	
	private double [] real;
	private double [] imaginary;
	
	public Fouriertransform(int maxData) {
		MAX_DATA = maxData;
		dataset = new double[MAX_DATA];
		real = new double[MAX_DATA];
		imaginary = new double[MAX_DATA];
		makeDataset();
		dftCalc();
	}
	
	private void makeDataset() {
//		for(int i=0; i<coef.length; i++) {
//			for(int j=0; j<MAX_DATA; j++) {
//				dataset[i] = Math.cos( coef[i]*(2*Math.PI)*(j/(double)MAX_DATA) );
//			}
//		}
		for(int i=0; i<MAX_DATA; i++) {
			dataset[i] = Math.random();
		}
	}
	
	private void dftCalc() {
		if( MAX_DATA <= 1 ) return ;
		for(int i=0; i<MAX_DATA; ++i) {
			double realSum = 0;
			double imaginarySum = 0;
			for(int j=0; j<MAX_DATA; ++j ) {
				double theta = 2*Math.PI/(double)MAX_DATA*i*j;
				realSum = dataset[j]*Math.cos(theta);
				imaginarySum = dataset[j]*Math.sin(theta);
			}
			real[i] = realSum;
//			System.out.println(realSum);
			imaginary[i] = imaginarySum;
		}
	}
	
	public void show() {
		for(int i=0; i<MAX_DATA; i++) {
//			System.out.println("dataset = [" + dataset[i] +"], real = [" + real[i] + "], imaginary = [" + imaginary[i] + "]");
		}
	}
	
	public double [] getDatset() {
		return dataset;
	}
	
	public double [] getReal() {
		return real;
	}
	
	public double [] getImaginary() {
		return imaginary;
	}
	
	public static void main(String [] args) {
		Fouriertransform ft = new Fouriertransform(32);
		ft.makeDataset();
		ft.dftCalc();
		ft.show();
	}
}