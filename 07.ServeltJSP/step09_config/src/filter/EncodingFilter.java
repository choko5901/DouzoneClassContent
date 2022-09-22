package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


public class EncodingFilter implements Filter {
	String encoding;
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		//초기 환경값을 받아 오기 위해 init은 살려둔다
		encoding = fConfig.getInitParameter("encoding");	
		System.out.println(encoding);
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		request.setCharacterEncoding();
		System.out.println("doFilter : " + encoding);
		chain.doFilter(request, response);
	}
	
}
