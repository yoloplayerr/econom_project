package economic_project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class Reader {
	

	/**
	 * Создание обькта класса Tree для работы с коэффициентами детерминации
	 */
	static Tree tree = new Tree();
	/**
	 * Список хранящий коэф детерм
	 */
	public static ArrayList<Double> r = new ArrayList<>();

	public static void main(String[] args) {
		StandardCharsets.UTF_8.name();
		/**
		 * Считывание данных в Список
		 */
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
			//Этот
			 Matrice1.New_close(getOpen(text, 30), getHigh(text, 30), getLow(text, 30), getClose(text, 30));
			 Matrice1.New_close(getOpen(text, 60), getHigh(text, 60), getLow(text, 60), getClose(text, 60));
			 Matrice1.New_close(getOpen(text, 90), getHigh(text, 90), getLow(text, 90), getClose(text, 90));
			 Matrice1.New_close(getOpen(text, 120), getHigh(text, 120), getLow(text, 120), getClose(text, 120));
			 Matrice1.New_close(getOpen(text, 150), getHigh(text, 150), getLow(text, 150), getClose(text, 150));
			 Matrice1.New_close(getOpen(text, 180), getHigh(text, 180), getLow(text, 180), getClose(text, 180));
			 Matrice1.New_close(getOpen(text, 210), getHigh(text, 210), getLow(text, 210), getClose(text, 210));
			 Matrice1.New_close(getOpen(text, 240), getHigh(text, 240), getLow(text, 240), getClose(text, 240));
			 Matrice1.New_close(getOpen(text, 270), getHigh(text, 270), getLow(text, 270), getClose(text, 270));

			

		}

		catch (DataException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getNumber());
		}
		
	/*
	 * Заполняем дерево 
	 */
		for (int i = 0; i < Matrice1.data.size(); i++) {
			tree.root = tree.insert(tree.root, Matrice1.data.get(i).getDeterm());
		}
		//Вывод ключей
		tree.preOrder(tree.root);
		
		try {
			
			FileWriter fw = new FileWriter("/Users/maxim/close.txt");
			PrintWriter writer = new PrintWriter(fw);
			
			for(int i=0;i<Matrice1.data.size();i++) { //Идем по циклу пока не закончатся обьекты data хранящие в себе данные
				for(int j=0;j<Matrice1.data.get(i).getZ().length;j++) {//Идем по циклу пока есть коэффициенты уравнения
				
					writer.write("z["+j+"]="+Double.toString(Matrice1.data.get(i).getValueOfZ(j)));// Записываем коэф уравнения
					writer.println();
				}			
			writer.print("determ ="+ Double.toString(Matrice1.data.get(i).getDeterm()));// Записываем Коэф детерм
			writer.println();
			writer.println();
			
			}
			writer.close();
	
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}

	}

	/**
	 * Функция возвращающая массив с ценами открытия
	 * 
	 * @param text
	 * @param      key-значение представляет с собой какое количество дней нужно
	 *             взять
	 * @return
	 * @throws DataException
	 */
	public static ArrayList<Double> getOpen(ArrayList<String> text, int key) throws DataException {
		ArrayList<Double> open = new ArrayList<>();

		for (int i = 1; i < key; i++) {

			open.add(Double.parseDouble(text.get(i).substring(25, 34)));

		}
		for (int i = 0; i < key - 1; i++) {
			if ((open.get(i) <= 1) || (open.get(i) > 2) || (open.get(i) < 0)) {// Значения не должны превышать 2,быть не
																				// меньше 1 и не должны быть
																				// отрицательными
				throw new DataException("OpenValueOutOfBounds", open.get(i));
			}
		}

		return open;
	}

	/**
	 * Функция возвращающая массив с наибольшей ценой
	 * 
	 * @param text
	 * @param      key-значение представляет с собой какое количество дней нужно
	 *             взять
	 * @return
	 * @throws DataException
	 */
	public static ArrayList<Double> getHigh(ArrayList<String> text, int key) throws DataException {

		ArrayList<Double> high = new ArrayList<>();
		for (int i = 1; i < key; i++) {
			high.add(Double.parseDouble(text.get(i).substring(35, 44)));

		}
		for (int i = 0; i < key - 1; i++) {
			if ((high.get(i) <= 1) || (high.get(i) > 2) || (high.get(i) < 0)) {// Значения не должны превышать 2,быть не
																				// меньше 1 и не должны быть
																				// отрицательными
				throw new DataException("HighValueOutOfBounds", high.get(i));
			}
		}
		return high;
	}

	/**
	 * функция возвращающая массив с наименьшей ценой
	 * 
	 * @param text
	 * @param      key-значение представляет с собой какое количество дней нужно
	 *             взять
	 * @return
	 * @throws DataException
	 */
	public static ArrayList<Double> getLow(ArrayList<String> text, int key) throws DataException {

		ArrayList<Double> low = new ArrayList<>();
		for (int i = 1; i < key; i++) {
			low.add(Double.parseDouble(text.get(i).substring(45, 54)));

		}
		for (int i = 0; i < key - 1; i++) {
			if ((low.get(i) <= 1) || (low.get(i) > 2) || (low.get(i) < 0)) {// Значения не должны превышать 2,быть не
																			// меньше 1 и не должны быть отрицательными
				throw new DataException("LowValueOutOfBounds", low.get(i));
			}
		}
		return low;
	}

	/**
	 * функция возвращающая массив с ценами закрытия
	 * 
	 * @param text
	 * @param      key-значение представляет с собой какое количество дней нужно
	 *             взять
	 * @return
	 * @throws DataException
	 */
	public static ArrayList<Double> getClose(ArrayList<String> text, int key) throws DataException {

		ArrayList<Double> close = new ArrayList<>();
		for (int i = 1; i < key; i++) {
			close.add(Double.parseDouble(text.get(i).substring(55, 64)));

		}
		for (int i = 0; i < key - 1; i++) {
			if ((close.get(i) <= 1) || (close.get(i) > 2) || (close.get(i) < 0)) { // Значения не должны превышать
																					// 2,быть не меньше 1 и не должны
																					// быть отрицательными
				throw new DataException("CloseValueOutOfBounds", close.get(i));
			}
		}
		return close;
	}

}
