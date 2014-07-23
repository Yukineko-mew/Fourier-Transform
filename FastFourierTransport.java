/**
 * 
 */
package FT;

/**
 * @author b1012213
 *
 */
public class FastFourierTransport {
	public static void fft(double[] real,double[] imaginary){
		  int n = real.length;
		  double theta = -2*Math.PI/n;//(9)
		  _fft(n,theta,real,imaginary);
		}

		private static void _fft(
		    int n,double theta,
		    double[] real,double[] imaginary){
		  if(n<=1)return;//n=1の時、(1)の右辺はf(0)であるから、F(0)=f(0)で変わらないので処理なし。
		  int nh = n/2;
		  double[] ro = new double[nh],io=new double[nh],//F(j*2+1)を格納する
		    re = new double[nh],ie = new double[nh];//F(j*2+0)を格納する
		  for(int m=0;m<nh;m++){
		    re[m] = real[m]+real[nh+m];//(13)
		    ie[m] = imaginary[m] + imaginary[nh+m];//(13)
		    double Rm = real[m] - real[nh+m];//(15)
		    double Im =  imaginary[m] - imaginary[nh+m];//(16)
		    double cos = Math.cos(m*theta);//(17)のcos(mθ)
		    double sin = Math.sin(m*theta);//(17)のsin(mθ)
		    ro[m] = Rm*cos-Im*sin;//(17)
		    io[m] = Rm*sin+Im*cos;//(17)
		  }
		  //ここまででf(m,0)(←　re+i*ie)とf(m,1)(← ro+i*io)計算終了
		  //次にそれぞれをフーリエ変換すればいいので、_fftに投げる
		  _fft(nh,2*theta,re,ie);//(7)
		  _fft(nh,2*theta,ro,io);//(7)
		  //計算結果をreal とimaginaryに書き出す
		  //偶数奇数を順に書き出せばいいので、
		  for(int j=0;j<nh;j++){
		    real[2*j] = re[j];
		    imaginary[2*j] = ie[j];
		    real[2*j+1] = ro[j];
		    imaginary[2*j+1]=io[j];
		  }
		}
}
