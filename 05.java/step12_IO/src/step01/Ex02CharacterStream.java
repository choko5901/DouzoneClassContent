package step01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex02CharacterStream {

	public static void fileSave() {
		// Writer
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("CharacterStream.txt");
			
			char[] city = {'더', '블', '린'};
			
			fw.write(city);
			
			fw.write("\n배고픔");
			
			fw.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void fileOpen() {
		//Reader
		
//		FileReader fr = null;
		try(FileReader fr = new FileReader("CharacterStream.txt");) {
			
			int data;
			while((data = fr.read()) != -1) {
				System.out.println(data + " " + (char)data);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) {

//		fileSave();
		fileOpen();
		
	}

}
