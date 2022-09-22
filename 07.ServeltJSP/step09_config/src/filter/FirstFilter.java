package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


//@WebFilter("/first")
public class FirstFilter implements Filter {

  
    public FirstFilter() {
    	System.out.println("필터 생성자 1 ");
    }

	@Override
	public void destroy() {
		System.out.println("필터 제거 1 ");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("필터 처리 1 처리 전 ");
		chain.doFilter(request, response);
		System.out.println("필터 처리 1 처리 후 ");

	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("필터 초기화 1");
	}

}
	