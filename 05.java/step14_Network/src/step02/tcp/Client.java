package step02.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		// 1단계 : 연결(연결을 위해서는 socket이 필수)
		
		
		Socket socket = null;
		try {
			System.out.println("연결 중입니다");
			socket = new Socket();
			socket.connect(new InetSocketAddress("localhost", 8888));
			System.out.println("서버 접속 했습니다.");
			
			// 2단계 : 통신
			OutputStream os = socket.getOutputStream();
			String msg = "오늘은 목요일 빨리 집에 가야지";
			
			byte[] data = msg.getBytes();
			os.write(data);
			os.flush();
			System.out.println("메세지 전송 완");
			
			// 2-2단계  : 통신(서버로 부터 데이터를 받음)
			InputStream is =socket.getInputStream();
			byte[] data2 = new byte[100];
			int countByte2 = is.read(data2);
			String msg2 = new String(data2, 0, countByte2, "UTF-8");
			System.out.println("서버로 부터 메세지를 정상적으로 받음 : " + msg2);
			
			is.close();
			os.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(!socket.isClosed()) {
			try {
				System.out.println("서버와의 연결을 해제합니다.");
				socket.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}
