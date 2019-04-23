package economic_project;

import java.util.ArrayList;

import Jama.Matrix;

public class Matrice1 extends Thread {

	public static ArrayList<Data> data=new ArrayList<>();
	

	public static void New_close(ArrayList<Double> Open, ArrayList<Double> High, ArrayList<Double> Low, ArrayList<Double> Close) {
		double[] y = new double[Open.size()];
		double[][] x = new double[4][Open.size()];

		for (int i = 0; i < Open.size(); i++) {
			x[0][i] = 1;
			x[1][i] = Open.get(i);
			x[2][i] = High.get(i);
			x[3][i] = Low.get(i);
			y[i] = Close.get(i);
		}
		test(x,y);
		
		
	}
	
	public static void test(double[][] ff, double[] yy) {
		 double[] z = new double[3];
		// Вычисление коэффициентов z 
		Matrix A1 = new Matrix(ff);
		Matrix B1 = A1.transpose();

		Matrix F1 = A1.times(B1);
		Matrix F4 = F1.inverse();

		Matrix F2 = F4.times(A1);

		Matrix C = new Matrix(yy, yy.length);
		Matrix F3 = F2.times(C);
		
		z = F3.getColumnPackedCopy();		
		//Вычесление коэффициента детерминации
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
		/**
		 *  Создание обьекта Класса Data,
		 *  Обьект Data содержит в себе массив коэффициентов уравнения(z) и коэф. детерминации
		 *  Заносим этот обьект в список обьектов data
		 *  Каждый раз при вызове этой функции создается новый обьект Data с новыми значениями
		 */
		Data dannie=new Data();
		dannie.setZ(z);
		dannie.setDeterm(r);
		data.add(dannie);	
	
		
	}
	

}