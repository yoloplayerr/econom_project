package economic_project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class reader1 {
	
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
		
		// Вызов функции возврающей препологаемую цену закрытия
		System.out.println(Matrice1.New_close(getOpen(text),getHigh(text),getLow(text),getClose(text)));
		
		
		
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
		
		System.out.println("The file has been written");


	}
	// Процедура возвращающая массив с ценами открытия
	public static ArrayList<Double> getOpen(ArrayList<String> text) {

		ArrayList<Double> be = new ArrayList<>();
		for (int i = 1; i < text.size(); i++) {
			be.add(Double.parseDouble(text.get(i).substring(25, 34)));
		}
		return be;
	}
	// Процедура  возвращающая массив с наибольшей ценой 
	public static ArrayList<Double> getHigh(ArrayList<String> text) {  

		ArrayList<Double> be = new ArrayList<>();
		for (int i = 1; i < text.size(); i++) {
			be.add(Double.parseDouble(text.get(i).substring(35, 44)));
		}
		return be;
	}
	// функция возвращающая массив с наименьшей ценой
	public static ArrayList<Double> getLow(ArrayList<String> text) { 

		ArrayList<Double> be = new ArrayList<>();
		for (int i = 1; i < text.size(); i++) {
			be.add(Double.parseDouble(text.get(i).substring(45, 54)));
		}
		return be;
	}
	// функция возвращающая массив с ценами закрытия
	public static ArrayList<Double> getClose(ArrayList<String> text) {

		ArrayList<Double> be = new ArrayList<>();
		for (int i = 1; i < text.size(); i++) {
			be.add(Double.parseDouble(text.get(i).substring(55, 64)));
		}
		return be;
	}

}
