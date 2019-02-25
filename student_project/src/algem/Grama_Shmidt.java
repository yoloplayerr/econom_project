package algem;

import java.util.ArrayList;
import java.util.Scanner;

public class Grama_Shmidt {

	public static void main(String[] args) {
		double z1, z2, z3, b1, b2, b3, c1, c2, c3;
		z1 = 0;// скалярное произведение (h1,h1)
		z2 = 0;//скалярное произведение (h2,h2)
		z3 = 0;//скалярное произведение(h3,h3)
		b1 = 0;//скалярное произведение (h1,a[1][a2])
		b2 = 0;//скалярное произведение (h2,a[1][a2])
		b3 = 0;//скалярное произведение (h3,a[1][a2])
		c1 = 0;//каэффицаент альфа 2 1
		c2 = 0;//каэффицаент альфа 3 1
		c3 = 0;//каэффицаент альфа 3 2

		System.out.println("Введите количество векторов a");
		Scanner cons = new Scanner(System.in);
		int e = cons.nextInt();
		double[] h1 = new double[4];
		double[] h2 = new double[4];
		double[] h3 = new double[4];
		for (int i = 0; i < 3; i++) {
			h1[i] = 0;

		}
		double[][] a = new double[3][e];

		System.out.print("Введите координаты векторов");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < e; j++) {
				a[i][j] = cons.nextDouble();
			}

		}
		for (int i = 0; i < e; i++) {
			h1[i] = a[0][i];
			b1 += a[1][i] * h1[i];
			z1 = h1[i] * h1[i] + z1;
			

		}
		c1 = (b1 / z1) * (-1);
		

	}

}
