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
	/**
	 * 0 поток
	 */
	static Matrice1 mSecondThread;
	/**
	 * 1 поток
	 */
	static Matrice1 mSecondThread1;
	/**
	 * 2 поток
	 */
	static Matrice1 mSecondThread2;
	/**
	 * 3 поток
	 */
	static Matrice1 mSecondThread3;
	/**
	 * 4 поток
	 */
	static Matrice1 mSecondThread4;
	/**
	 * 5 поток
	 */
	static Matrice1 mSecondThread5;
	/**
	 * 6 поток
	 */
	static Matrice1 mSecondThread6;
	/**
	 * 7 поток
	 */
	static Matrice1 mSecondThread7;
	/**
	 * 8 поток
	 */
	static Matrice1 mSecondThread8;
	/**
	 * 9 поток
	 */
	static Matrice1 mSecondThread9;
	/**
	 * Создание обькта класса Tree для работы с коэффициентами детерминации
	 */
	static Tree tree=new Tree();
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

			/**
			 * Создание потока отвечающего за подсчет коэффициента детерминации за 1 месяц
			 
			 */
			mSecondThread = new Matrice1(getOpen(text, 30), getHigh(text, 30), getLow(text, 30),
					getClose(text, 30));
			mSecondThread.start();

			/**
			 * Создание потока отвечающего за подсчет коэффициента детерминации за 2 месяц
			 
			 */
			mSecondThread1 = new Matrice1(getOpen(text, 60), getHigh(text, 60), getLow(text, 60),
					getClose(text, 60));
			mSecondThread1.start();

			/**
			 * Создание потока отвечающего за подсчет коэффициента детерминации за 3 месяц
			 
			 */
			mSecondThread2 = new Matrice1(getOpen(text, 90), getHigh(text, 90), getLow(text, 90),
					getClose(text, 90));
			mSecondThread2.start();

			/**
			 * Создание потока отвечающего за подсчет коэффициента детерминации за 4 месяц
			 
			 */
			mSecondThread3 = new Matrice1(getOpen(text, 120), getHigh(text, 120), getLow(text, 120),
					getClose(text, 120));
			mSecondThread3.start();

			/**
			 * Создание потока отвечающего за подсчет коэффициента детерминации за 5 месяц
			 
			 */
			mSecondThread4 = new Matrice1(getOpen(text, 150), getHigh(text, 150), getLow(text, 150),
					getClose(text, 150));
			mSecondThread4.start();

			/**
			 * Создание потока отвечающего за подсчет коэффициента детерминации за 6 месяц
			 
			 */
			mSecondThread5 = new Matrice1(getOpen(text, 180), getHigh(text, 180), getLow(text, 180),
					getClose(text, 180));
			mSecondThread5.start();

			/**
			 * Создание потока отвечающего за подсчет коэффициента детерминации за 7 месяц
			 
			 */
			mSecondThread6 = new Matrice1(getOpen(text, 210), getHigh(text, 210), getLow(text, 210),
					getClose(text, 210));
			mSecondThread6.start();

			/**
			 * Создание потока отвечающего за подсчет коэффициента детерминации за 8 месяц
			 
			 */
			mSecondThread7 = new Matrice1(getOpen(text, 240), getHigh(text, 240), getLow(text, 240),
					getClose(text, 240));
			mSecondThread7.start();

			/**
			 * Создание потока отвечающего за подсчет коэффициента детерминации за 9 месяц
			 
			 */
			mSecondThread8 = new Matrice1(getOpen(text, 270), getHigh(text, 270), getLow(text, 270),
					getClose(text, 270));
			mSecondThread8.start();

			/**
			 * Создание потока отвечающего за подсчет коэффициента детерминации за 10 месяц			 
			 */
			mSecondThread9 = new Matrice1(getOpen(text, 300), getHigh(text, 300), getLow(text, 300),
					getClose(text, 300));
			mSecondThread9.start();
			
			for(int i=0;i<r.size();i++) {
				
			tree.root=tree.insert(tree.root,r.get(i));
			
			}
			
			
			tree.preOrder(tree.root);	
			
			
		} 
		
		catch (DataException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getNumber());
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

	/**
	 *  Функция возвращающая массив с ценами открытия
	 * @param text
	 * @param key
	 * @return
	 * @throws DataException
	 */
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

	/**
	 *  Функция возвращающая массив с наибольшей ценой
	 * @param text
	 * @param key
	 * @return
	 * @throws DataException
	 */
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

	/**
	 *  функция возвращающая массив с наименьшей ценой
	 * @param text
	 * @param key
	 * @return
	 * @throws DataException
	 */
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

	/**
	 *  функция возвращающая массив с ценами закрытия
	 * @param text
	 * @param key
	 * @return
	 * @throws DataException
	 */
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
