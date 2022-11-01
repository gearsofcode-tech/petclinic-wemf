package tech.gearsofcode.petclinic.web.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component
public class AccessControlFilter implements Filter{
	private static Logger logger = LoggerFactory.getLogger(AccessControlFilter.class);

	@Override
	public void destroy() {
	}



	@Override
	public void doFilter(ServletRequest request, ServletResponse sResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) sResponse;
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type");
		chain.doFilter(request, response);
	}



	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.warn("AccessControlFilter should be used only in development environments.");
	}
}
