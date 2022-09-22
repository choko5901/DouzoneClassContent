package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


public class SecondFilter implements Filter {

  
    public SecondFilter() {
    	System.out.println("필터 생성자2");
    }

	@Override
	public void destroy() {
		System.out.println("필터 제거2");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("필터 처리2 전");
		chain.doFilter(request, response);
		System.out.println("필터 처리2 후");

	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("필터 초기화2");
	}

}
	