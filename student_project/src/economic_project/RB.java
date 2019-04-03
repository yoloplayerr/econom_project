package economic_project;

import java.util.ArrayList;
import java.util.Date;

public class RB {
	public static int p=997;
	public static int x=11;
	public static void main(String[] args) {
		String text = "kak delat' programmirovanie";
        String str = "delat' p";
        
		System.out.println(Indexof(text,str));
		
		
	}
	public static ArrayList<Integer> Indexof(String text,String str) {
		ArrayList<Integer> index=new ArrayList<Integer>();
		
		int text_length=text.length();
		int str_length=str.length();
	
		int hashStr=Hash(str);
		
		int hashText=Hash(text.substring(0,str.length()));
		
		for(int i=0;i<text_length-str_length;i++) {				
			if(hashText==hashStr) {
				index.add(i);							
			}			
			hashText = ((hashText*x%p - ((int)text.charAt(i) * (int)Math.pow(x,str_length)%p)) + (int)text.charAt(i+str_length)) % p;
			if(hashText<0) {
				hashText=hashText+p;
			}
		}				
		return index;
		
	}
	
	public static int Hash(String int_string) {
		int hash=0;					
		for(int i=0;i<int_string.length();i++) {
			
			hash+=(int)int_string.charAt(i)*Math.pow(x,int_string.length()-1-i);
			
		}
		
		return hash%p;
		
	}
}