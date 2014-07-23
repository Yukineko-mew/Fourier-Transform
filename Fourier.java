/**
 * 
 */
package FT;

/**
 * @author b1012213 小笠原 佑樹
 * 
 *
 */
class Fourier
{
	int num; // データの要素数
	double [] data; // 元データ
	double [] real; // 実数部
	double [] imaginary; // 虚数部

	
	/* 
	 * コンストラクタ
	 * 
	 * 変数と配列を初期化し，サンプルデータで埋めておく．
	 * 
	 */
	public Fourier(int num) {
		this.num = num;
		real = new double[num];
		imaginary = new double[num];
		data = new double[num];
		createSampleData();
	}
	
	/*
	 * サンプルデータを作成するメソッド
	 * 
	 * ランダム生成したテストデータを生データとしてdata配列に保存する．
	 * 
	 */
	private void createSampleData() {
		for(int i=0; i<num; i++) {
			data[i] = Math.random();
		}
	}
	
	/*
	 * 離散フーリエ変換を行うメソッド
	 * 
	 * 計算式としては Fn = Σ(k=i to n)fk * e^(2πikn/N) を用いているが，
	 * ここでは オイラーの公式 を用いて e^(2πikn/N) の部分を以下のように変形している．
	 * theta = 2πkn/N とすると， e^(theta) = cos(theta) + i(sin(theta))で表すことが出来る．
	 * したがって，実数部 ReF = cos(theta), 虚数部ImF = -sin(theta)となっている．
	 * 
	 */
	public void dftCalc() {
		for (int n = 0; n<num; n++) {
			double ReF = 0.0, ImF = 0.0;
			for (int k = 0; k <num; k++) {
				ReF += data[k]*Math.cos(2*Math.PI*k*n/(num + 1));
				ImF += -data[k]*Math.sin(2*Math.PI*k*n/(num + 1));
			}
			real[n] = ReF;
			imaginary[n] = ImF;
 		}		
	}
	
	/*
	 * 実数部の配列のゲッターメソッド
	 * 
	 */
	
	public double [] getReal() {
		return real;
	}
	
	/*
	 * 虚数部の配列のゲッターメソッド
	 * 
	 */
	
	public double [] getImaginary() {
		return imaginary;
	}
	
	/*
	 * 実数部と虚数部の値を出力するメソッド
	 * 
	 */
	
	public void show() {
		for(int i=0; i<num; i++) {
			System.out.println("real = [" + real[i] + "], imaginary = [" + imaginary[i] + "]");
		}
	}
}
