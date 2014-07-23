/**
 * 
 */
package FT;

/**
 * @author b1012213
 *
 */
class Fourier
{
	int num;
	double [] data;
	double [] real;
	double [] imaginary;
	
	public Fourier(int num) {
		this.num = num;
		real = new double[num];
		imaginary = new double[num];
		data = new double[num];
		createSampleData();
	}
	
	private void createSampleData() {
		for(int i=0; i<num; i++) {
			data[i] = Math.random();
//			System.out.println(data[i]);
		}
		dftCalc();
	}
	
	private void dftCalc() {
		for (int n = 0; n < num; n++) {
			double ReF = 0.0, ImF = 0.0;
//			real[n] = imaginary[n] = 0.0;
			for (int k = 0; k < num; k++) {
				ReF += data[k] * Math.cos(2 * Math.PI * k * n / (num + 1));
				ImF += -data[k] * Math.sin(2 * Math.PI * k * n / (num + 1));
			}
//			fw.write(n + " " + ReF + " " + ImF + "\n");
			real[n] = ReF;
			imaginary[n] = ImF;
 			System.out.println(n + " " + real[n] + " " + imaginary[n] + "\n");
		}		
	}
	
	public double [] getReal() {
		return real;
	}
	
	public double [] getImaginary() {
		return imaginary;
	}
	
	public void show() {
		for(int i=0; i<num; i++) {
			System.out.println("real = [" + real[i] + "], imaginary = [" + imaginary[i] + "]");
		}
	}
	
	public static void main(String arg[])
	{
		Fourier f = new Fourier(100);
	}
}
