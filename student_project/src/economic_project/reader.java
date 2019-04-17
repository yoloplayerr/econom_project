package economic_project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class reader {

	static Matrice1 mSecondThread;
	static Matrice1 mSecondThread1;
	static Matrice1 mSecondThread2;
	static Matrice1 mSecondThread3;
	static Matrice1 mSecondThread4;
	static Matrice1 mSecondThread5;
	static Matrice1 mSecondThread6;
	static Matrice1 mSecondThread7;
	static Matrice1 mSecondThread8;
	static Matrice1 mSecondThread9;
	public static ArrayList<Double> r = new ArrayList<>();

	public static void main(String[] args) {

		// Считывание данных в динамический массив
		ArrayList<String> text = new ArrayList<>();
		try {
			String str = null;
			BufferedReader br = new BufferedReader(new FileReader("/Users/maxim/EURUSD.csv"));
			while ((str = br.readLine()) != null) {
				text.addAll(Arrays.asList(str.split(" ")));
			}
			br.close();
		} catch (IOException exc) {
			System.out.println("IO error!" + exc);

		}

		try {

			// Вызов функции возврающей препологаемую цену закрытия за месяц
			mSecondThread = new Matrice1(getOpen(text, 30), getHigh(text, 30), getLow(text, 30), getClose(text, 30));
			mSecondThread.start();
			

			// Вызов функции возврающей препологаемую цену закрытия за 2 месяцa
			mSecondThread1 = new Matrice1(getOpen(text, 60), getHigh(text, 60), getLow(text, 60), getClose(text, 60));
			mSecondThread1.start();
			

			// Вызов функции возврающей препологаемую цену закрытия за 3 месяц
			mSecondThread2 = new Matrice1(getOpen(text, 90), getHigh(text, 90), getLow(text, 90), getClose(text, 90));
			mSecondThread2.start();
			
			// Вызов функции возврающей препологаемую цену закрытия за 4 месяц
			mSecondThread3 = new Matrice1(getOpen(text, 120), getHigh(text, 120), getLow(text, 120),getClose(text, 120));
			mSecondThread3.start();
			

			// Вызов функции возврающей препологаемую цену закрытия за 5 месяц
			mSecondThread4 = new Matrice1(getOpen(text, 150), getHigh(text, 150), getLow(text, 150),getClose(text, 150));
			mSecondThread4.start();
			
			// Вызов функции возврающей препологаемую цену закрытия за 6 месяц
			mSecondThread5 = new Matrice1(getOpen(text, 180), getHigh(text, 180), getLow(text, 180),getClose(text, 180));
			mSecondThread5.start();
			
			// Вызов функции возврающей препологаемую цену закрытия за 7 месяц
			mSecondThread6 = new Matrice1(getOpen(text, 210), getHigh(text, 210), getLow(text, 210),getClose(text, 210));
			mSecondThread6.start();
		
			// Вызов функции возврающей препологаемую цену закрытия за 8 месяц
			mSecondThread7 = new Matrice1(getOpen(text, 240), getHigh(text, 240), getLow(text, 240),getClose(text, 240));
			mSecondThread7.start();
			
			
			// Вызов функции возврающей препологаемую цену закрытия за 9 месяц
			mSecondThread8 = new Matrice1(getOpen(text, 270), getHigh(text, 270), getLow(text, 270),getClose(text, 270));
			mSecondThread8.start();
			
			
			// Вызов функции возврающей препологаемую цену закрытия за 10 месяц
			mSecondThread9 = new Matrice1(getOpen(text, 300), getHigh(text, 300), getLow(text, 300),getClose(text, 300));
			mSecondThread9.start();
			

		} catch (DataException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getNumber());
		}
		System.out.println(r);
		for (int i = 0; i < r.size(); i++) {
			Tree some_node = new Tree();
			some_node.insert(i, r.get(i));
			
		}

		// Запись данных в файл
		try (FileOutputStream fos = new FileOutputStream("/Users/maxim/close.txt")) {
			for (int i = 1; i < text.size(); i++) {
				// перевод строки в байты
				byte[] buffer = text.get(i).getBytes();

				fos.write(buffer, 0, buffer.length);
			}
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
		
	

	}

	// Процедура возвращающая массив с ценами открытия
	public static ArrayList<Double> getOpen(ArrayList<String> text, int key) throws DataException {
		ArrayList<Double> be = new ArrayList<>();

		for (int i = 1; i < key; i++) {

			be.add(Double.parseDouble(text.get(i).substring(25, 34)));

		}
		for (int i = 0; i < key - 1; i++) {
			if ((be.get(i) <= 1) || (be.get(i) > 2)) {
				throw new DataException("OpenValueOutOfBounds", be.get(i));
			}
		}

		return be;
	}

	// Процедура возвращающая массив с наибольшей ценой
	public static ArrayList<Double> getHigh(ArrayList<String> text, int key) throws DataException {

		ArrayList<Double> be = new ArrayList<>();
		for (int i = 1; i < key; i++) {
			be.add(Double.parseDouble(text.get(i).substring(35, 44)));

		}
		for (int i = 0; i < key - 1; i++) {
			if ((be.get(i) <= 1) || (be.get(i) > 2)) {
				throw new DataException("HighValueOutOfBounds", be.get(i));
			}
		}
		return be;
	}

	// функция возвращающая массив с наименьшей ценой
	public static ArrayList<Double> getLow(ArrayList<String> text, int key) throws DataException {

		ArrayList<Double> be = new ArrayList<>();
		for (int i = 1; i < key; i++) {
			be.add(Double.parseDouble(text.get(i).substring(45, 54)));

		}
		for (int i = 0; i < key - 1; i++) {
			if ((be.get(i) <= 1) || (be.get(i) > 2)) {
				throw new DataException("LowValueOutOfBounds", be.get(i));
			}
		}
		return be;
	}

	// функция возвращающая массив с ценами закрытия
	public static ArrayList<Double> getClose(ArrayList<String> text, int key) throws DataException {

		ArrayList<Double> be = new ArrayList<>();
		for (int i = 1; i < key; i++) {
			be.add(Double.parseDouble(text.get(i).substring(55, 64)));

		}
		for (int i = 0; i < key - 1; i++) {
			if ((be.get(i) <= 1) || (be.get(i) > 2)) {
				throw new DataException("CloseValueOutOfBounds", be.get(i));
			}
		}
		return be;
	}

}
