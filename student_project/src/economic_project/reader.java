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
	
	public static void main(String[] args) {
		
		
		
		ArrayList<Double> r=new ArrayList<>();
		
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
		String some="kek";
		some.indexOf(1);
		try {
			// Вызов функции возврающей препологаемую цену закрытия за неделю
			
			
			r.add(Matrice1.New_close(getOpen(text,8),getHigh(text,8),getLow(text,8), getClose(text,8)));
			// Вызов функции возврающей препологаемую цену закрытия за месяц
			
		
			r.add(Matrice1.New_close(getOpen(text,30),getHigh(text,30),getLow(text,30), getClose(text,30)));
			// Вызов функции возврающей препологаемую цену закрытия за 2 месяцa			
			r.add(Matrice1.New_close(getOpen(text,30),getHigh(text,30),getLow(text,30), getClose(text,30)));
			
			r.add(Matrice1.New_close(getOpen(text,62),getHigh(text,62),getLow(text,62), getClose(text,62)));
			
			r.add(Matrice1.New_close(getOpen(text,70),getHigh(text,70),getLow(text,70), getClose(text,70)));
			
			
			for (int i=0;i<r.size();i++) {
				Tree some_node=new Tree();
				some_node.insert(i,r.get(i));
			}
			
			
			}
			catch (DataException ex) {
				System.out.println(ex.getMessage());
		        System.out.println(ex.getNumber());
			}
			

	}
	// Процедура возвращающая массив с ценами открытия
	public static ArrayList<Double> getOpen(ArrayList<String> text,int key) throws DataException{
		ArrayList<Double> be = new ArrayList<>();
		
		for (int i = 1; i <key ;i++) {
			
			be.add(Double.parseDouble(text.get(i).substring(25, 34)));
			
		}for (int i = 0; i <key-1; i++) {
			if((be.get(i)<=1)||(be.get(i)>2)){
				throw new DataException("OpenValueOutOfBounds",be.get(i));
			}
			}
		
		return be;
	}
	
	// Процедура  возвращающая массив с наибольшей ценой 
	public static ArrayList<Double> getHigh(ArrayList<String> text,int key) throws DataException {  

		ArrayList<Double> be = new ArrayList<>();
		for (int i = 1; i < key; i++) {
			be.add(Double.parseDouble(text.get(i).substring(35, 44)));
			
		}
		for (int i = 0; i <key-1; i++) {
			if((be.get(i)<=1)||(be.get(i)>2)){
			throw new DataException("HighValueOutOfBounds",be.get(i));
		}
		}
		return be;
	}
	// функция возвращающая массив с наименьшей ценой
	public static ArrayList<Double> getLow(ArrayList<String> text,int key) throws DataException { 

		ArrayList<Double> be = new ArrayList<>();
		for (int i = 1; i <key; i++) {
			be.add(Double.parseDouble(text.get(i).substring(45, 54)));
			
		}
		for (int i = 0; i < key-1; i++) {
			if((be.get(i)<=1)||(be.get(i)>2)){
				throw new DataException("LowValueOutOfBounds",be.get(i));
			}
		}
		return be;
	}
	// функция возвращающая массив с ценами закрытия
	public static ArrayList<Double> getClose(ArrayList<String> text,int key) throws DataException {

		ArrayList<Double> be = new ArrayList<>();
		for (int i = 1; i <key; i++) {
			be.add(Double.parseDouble(text.get(i).substring(55, 64)));
			
		}for (int i = 0; i <key-1; i++) {
			if((be.get(i)<=1)||(be.get(i)>2)){
				throw new DataException("CloseValueOutOfBounds",be.get(i));
			}
			}
		return be;
	}

}







