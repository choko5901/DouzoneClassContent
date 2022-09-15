package step02.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.print.attribute.standard.Severity;

public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			//IP , PortNumber 지정 해줘야하는데 bind() 메소드를 이용해 수행한다
			
			serverSocket.bind(new InetSocketAddress("localhost",8888));
			
			// 서버는 무한히 수행되어야 클라이언트가 요청 할 떄마다 처리 할 수 있다 그래서 while문 사용
			while(true) {
				// 1단계 : 연결 
				Socket socket = serverSocket.accept();
				
				InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println(isa.getHostName() + "님이 연결되셨습니다");
				
				// 2단계 통신
				
				InputStream is = socket.getInputStream();
				byte[] data = new byte[100];
				int countByte = is.read(data);
				String msg = new String(data, 0, countByte, "UTF-8");
				System.out.println("메세지를 정상적으로 받음 : " + msg);
				
				// 2-2단계 : 통신(서버 -> 클라이언트)
				
				OutputStream os = socket.getOutputStream();
				String msg2 = "퇴근 요청 완료";
				
				byte[] data2 = msg2.getBytes();
				os.write(data2);
				os.flush();
				System.out.println("메세지 전송 완");
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
