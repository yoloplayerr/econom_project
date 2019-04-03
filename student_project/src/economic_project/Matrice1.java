package economic_project;

import java.util.ArrayList;

import Jama.Matrix;

public class Matrice1 {

	double[] z = new double[3];

	public static double New_close(ArrayList<Double> O, ArrayList<Double> H, ArrayList<Double> L, ArrayList<Double> C) {

		ArrayList<Double> Open = O;
		ArrayList<Double> High = H;
		ArrayList<Double> Low = L;
		ArrayList<Double> Close = C;

		double[] y = new double[Open.size()];
		double[][] x = new double[4][O.size()];// some comment
		for (int i = 0; i < O.size(); i++) {
			x[0][i] = 1;
			x[1][i] = Open.get(i);
			x[2][i] = High.get(i);
			x[3][i] = Low.get(i);
			y[i] = Close.get(i);
		}

		Matrice1 He = new Matrice1();

		He.determ(x, y);
		return He.test(x, y);

	}

	public double test(double[][] ff, double[] yy) {
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

	public double determ(double[][] ff, double[] yy) {
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
		System.out.println("r=" + r);
		return r;
	}
}