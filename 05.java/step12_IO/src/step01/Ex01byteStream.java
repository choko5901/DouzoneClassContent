package step01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex01byteStream {
	
	public static void fileSave() {
		//OutputStream
		
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("ByteStream.txt");
			
			try {
				fos.write(97); //a
				byte[] data = {65,66,67,68,69};
				
				fos.write(data); //ABCD
				fos.write(data, 1, 3); // data라는 배열에서 인덱스 번호 1부터 3까지 출력 
				
				
				
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void fileOpen() {
		// InputStream
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("ByteStream.txt");
//			System.out.println(fis.read());
			
			//방법 1
//			int data;
//			while((data = fis.read()) != -1) {
//				System.out.println(data + " " + (char)data);
//			}
			
			//방법2
			int fileSize = (int)new File("ByteStream.txt").length();
			System.out.println(fileSize);
			byte[] readData = new byte[fileSize];
			fis.read(readData);
			
			for(int i = 0 ; i < fileSize; i++) {
				System.out.println(readData[i] +"  " + (char)readData[i] );
				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	

	public static void main(String[] args) {
//		fileSave();
		fileOpen();
				
	}
	
	

	
	
	

}
