package economic_project;

import java.util.ArrayList;


import Jama.Matrix;

public class Matrice1 extends Thread {
	
	public static ArrayList<Double> Open;
	public static  ArrayList<Double> High;
	public static ArrayList<Double> Low;
	public static ArrayList<Double> Close; 
	

	 public Matrice1(ArrayList<Double> O, ArrayList<Double> H, ArrayList<Double> L, ArrayList<Double> C) {
		 	Matrice1.Open = O;
			Matrice1.High = H;
			Matrice1.Low = L;
			Matrice1.Close = C;
	   }
	 @Override
	// Этот метод будет вызван при старте потока
	public void run() {
		double det=New_close();			
		reader.r.add(det);
		
					
	}

	static double[] z = new double[3];

	public static double New_close() {

		
		

		double[] y = new double[Open.size()];
		double[][] x = new double[4][Open.size()];// some comment
		for (int i = 0; i < Open.size(); i++) {
			x[0][i] = 1;
			x[1][i] = Open.get(i);
			x[2][i] = High.get(i);
			x[3][i] = Low.get(i);
			y[i] = Close.get(i);
		}

		

		
		return Matrice1.determ(x, y);

	}

	public static double test(double[][] ff, double[] yy) {
		Matrix A1 = new Matrix(ff);
		Matrix B1 = A1.transpose();

		Matrix F1 = A1.times(B1);
		Matrix F4 = F1.inverse();

		Matrix F2 = F4.times(A1);

		Matrix C = new Matrix(yy, yy.length);
		Matrix F3 = F2.times(C);

		z = F3.getColumnPackedCopy();

		double open = 1.1338700;
		double high = 1.1351600;
		double low = 1.1329000;
		double real_close = 0;
		double close = 1.1339100;
		real_close = z[0] + z[1] * open + z[2] * high + z[3] * low;
		return real_close;
	}

	public static double determ(double[][] ff, double[] yy) {
		double r = 0, S1 = 0, S2 = 0, S3 = 0;
		double[] u1 = new double[yy.length];
		double[] u2 = new double[yy.length];
		for (int i = 0; i < yy.length; i++) {
			S3 += yy[i];
			u1[i] = 0;
		}
		S3 = S3 / 5;
		for (int m = 0; m < yy.length; m++) {
			u1[m] = (z[0] + z[1] * ff[1][m] + z[2] * ff[2][m] - yy[m])
					* (z[0] + z[1] * ff[1][m] + z[2] * ff[2][m] - yy[m]);
			S1 += u1[m];
			u2[m] = (S3 - yy[m]) * (S3 - yy[m]);
			S2 += u2[m];
		}
		r = 1 - S1 / S2;
		
		return r;
	}

}