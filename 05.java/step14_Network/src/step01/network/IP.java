package step01.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IP {

	public static void main(String[] args) {
		//IP
		
		InetAddress local;
		
		try {
			
			//local
			local = InetAddress.getLocalHost();
			System.out.println(local);
			System.out.println(local.getHostAddress());
			
			System.out.println();
			
			
			// 외부 정보
//			InetAddress remote = InetAddress.getByName("google.com");
			InetAddress[] remote = InetAddress.getAllByName("naver.com");
			System.out.println(remote);
			
			for (InetAddress inet : remote) {
				System.out.println(inet);
			}
			
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
