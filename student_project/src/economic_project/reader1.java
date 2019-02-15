package economic_project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class reader1 {

	

	public static void main(String[] args) {
		String[] text = new String[0];
		try {
		    String str = null;
		    BufferedReader br = new BufferedReader(new FileReader("/Users/maxim/eurusd.csv"));
		    while ((str = br.readLine()) != null) {
		        //получаем новые слова
		        String[] newWords = str.split(" ");
		        //создаем расширенный массив
		        String[] result = new String[text.length + newWords.length];
		        //копируем элементы в массив
		        System.arraycopy(text, 0, result, 0, text.length);
		        System.arraycopy(newWords, 0, result, text.length, newWords.length);
		        //присваиваем результирующий массив текущему
		        text = result;
		    }
		    br.close();
		} catch (IOException exc) {
		    System.out.println("IO error!" + exc);//some
		}for (int i=0;i<text.length;i++) {
		    System.out.println(text[i]);
		    }
		main.mnk(text);
			String[] some=text;
			try(FileOutputStream fos=new FileOutputStream("/Users/maxim/close.txt"))
		        {
				for (int i=0;i<some.length;i++) {
		            // перевод строки в байты
		            byte[] buffer = some[i].getBytes();
		              
		            fos.write(buffer, 0, buffer.length);
				}
		        }
		        catch(IOException ex){
		              
		            System.out.println(ex.getMessage());
		        }
		        System.out.println("The file has been written");

		       
	            
	            
}
}
