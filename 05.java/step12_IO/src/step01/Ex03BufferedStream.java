package step01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex03BufferedStream {
	//버퍼(8192바이트 배열) : 입력 혹은 출력에 대한 임시 저장 공간
	// -> 데이터를 한번에 처리 하도록 도와주는 보조 스트림
	
	/* 예시) 
	 * InputStream is = System.in;
	 * InputStreamReader isr = new InputStreamReader(is);
	 * BufferedReader br = new BufferdReader(isr);
	 * 
	 */
	public static void testbufferdStram() throws IOException {
		long start;
		long end;
		
		
		// 버퍼 미사용 
		FileInputStream fis1 = new FileInputStream("fall.jfif");
		
		start = System.currentTimeMillis();
		
		while(fis1.read() != -1) {}
		
		end = System.currentTimeMillis();

		System.out.println("버퍼 미사용 : " + (end - start) + "ms");
		fis1.close();
		
		// 버퍼 사용
		
		FileInputStream fis2 = new FileInputStream("fall.jfif");
		BufferedInputStream bis2 = new BufferedInputStream(fis2);
		
		start = System.currentTimeMillis();
		while(fis2.read() != -1) {}
		end = System.currentTimeMillis();

		System.out.println("버퍼 사용 : " + (end - start) + "ms");
		bis2.close();
		fis2.close();
		
	}
	
	
	public static void main(String[] args) {
		try {
			testbufferdStram();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		
		
		
		
		
		
		
	}

}
