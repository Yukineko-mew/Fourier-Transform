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
	DefaultCategoryDataset data; // JTreeChartのデータセットを格納する変数

	/*
	 * コンストラクタ
	 * 
	 * JTreeChartの設定とJFrameの設定を行う．
	 * 
	 * 
	 */
	
	public Frame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		createDataset(100);
	    JFreeChart chart = ChartFactory.createLineChart("Fourier Transform", 
	                                                    "Data Number",
	                                                    "Variable",
	                                                    data,
	                                                    PlotOrientation.VERTICAL, 
	                                                    true, 
	                                                    false, 
	                                                    false);

	    ChartPanel cpanel = new ChartPanel(chart);
	    this.getContentPane().add(cpanel);
		this.setVisible(true);
	}
	
	/*
	 * データセットを変数に登録するメソッド
	 * 
	 * デバッグとして，Fourierクラスのshowメソッドを呼びだしている．
	 * 引数 num はデータ数を示している．
	 * for文の部分のループ変数iが1から始まっているのは，
	 * 
	 */
	
	private void createDataset(int num) {
		data = new DefaultCategoryDataset();
		Fourier ft = new Fourier(num);
		ft.dftCalc();
		double [] theReal = ft.getReal();
		double [] theImaginary = ft.getImaginary();
		for(int i=1; i<num; i++) {
			data.addValue(theReal[i], "Real", String.valueOf(i));
			data.addValue(theImaginary[i], "Imaginary", String.valueOf(i));			
		}
		ft.show();
	}
	
	public static void main(String [] argas) {
		Frame f = new Frame();
	}

}
