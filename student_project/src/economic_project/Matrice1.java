package economic_project;

import java.util.ArrayList;

import Jama.Matrix;


public class Matrice1 {
	double[] z=new double[3];
	
	public static double New_close(ArrayList<Double> O, ArrayList<Double> H, ArrayList<Double> L ,ArrayList<Double> C) {
		ArrayList<Double> Open=O;
		
		ArrayList<Double> High=H;
		ArrayList<Double> Low=L;
		ArrayList<Double> Close=C;
		ArrayList<Double> New_Close=new ArrayList<>();
		double[] y=new double[Open.size()];
		double[][] x=new double[4][O.size()];// some comment
		for(int i=0;i<O.size();i++) {
			x[0][i]=1;
			x[1][i]=Open.get(i);
			x[2][i]=High.get(i);
			x[3][i]=Low.get(i);
			y[i]=Close.get(i);
		}
		

		
			Matrice1 He= new Matrice1();
			
		
		return He.test(x, y);	 
	}
	
			public double test(double[][]ff, double[]yy){
				Matrix A1=new Matrix(ff);
		        A1.print(10, 2);
				Matrix B1=A1.transpose();
				Matrix F1=A1.times(B1);
				Matrix F4=F1.inverse();
				
				Matrix F2=F4.times(A1);
				Matrix C=new Matrix(yy,yy.length);
				
				Matrix F3=F2.times(C);
				z=F3.getColumnPackedCopy();
				
				double open=1.1338700;
				double high=1.1351600;
				double low=1.1329000;
				double real_close=0;
				double close=1.1339100;
				real_close=z[0]+z[1]*open+z[2]*high+z[3]*low;
				
				System.out.println(real_close);
				return real_close;

			}

}