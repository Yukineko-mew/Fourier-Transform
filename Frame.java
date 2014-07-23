/**
 * 
 */
package FT;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;

/**
 * @author b1012213
 *
 */
public class Frame extends JFrame{
	DefaultCategoryDataset data;
	
	private void createDataset(int num) {
		data = new DefaultCategoryDataset();
		Fouriertransform ft = new Fouriertransform(num);
		double [] theReal = ft.getReal();
		double [] theImaginary = ft.getImaginary();
		for(int i=0; i<num; i++) {
//			data.addValue((double)i, "Real", String.valueOf(theReal[i]));
			data.addValue(theReal[i], "Real", String.valueOf(i));
//			data.addValue((double)i, "Imaginary", String.valueOf(theImaginary[i]));
			data.addValue(theImaginary[i], "Imaginary", String.valueOf(i));			
			System.out.println("real = [" + theReal[i] + "], imaginary = [" + theImaginary[i] + "]");
		}
		ft.show();
	}
	
	public Frame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		createDataset(36);
	    JFreeChart chart = ChartFactory.createLineChart("Fourier Transform", 
	                                                    "Fre",
	                                                    "Arrivals",
	                                                    data,
	                                                    PlotOrientation.VERTICAL, 
	                                                    true, 
	                                                    false, 
	                                                    false);

	    ChartPanel cpanel = new ChartPanel(chart);
	    this.getContentPane().add(cpanel);
		this.setVisible(true);
	}
	
	public static void main(String [] argas) {
		Frame f = new Frame();
	}

}
