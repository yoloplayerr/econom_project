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
			BufferedReader br = new BufferedReader(new FileReader("/Users/maxim/eurusd.csv"));
			while ((str = br.readLine()) != null) {
				text.addAll(Arrays.asList(str.split(" ")));

			}
			br.close();
		} catch (IOException exc) {
			System.out.println("IO error!" + exc);// some
		}
	

		System.out.println(main.mnk(text));
		
		//kek
		// Запись данных в файл
		try (FileOutputStream fos = new FileOutputStream("/Users/maxim/close.txt")) {
			for (int i = 0; i < text.size(); i++) {
				// перевод строки в байты
				byte[] buffer = text.get(i).getBytes();

				fos.write(buffer, 0, buffer.length);
			}
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}//sdf-
		System.out.println("The file has been written");

		

	}
}
