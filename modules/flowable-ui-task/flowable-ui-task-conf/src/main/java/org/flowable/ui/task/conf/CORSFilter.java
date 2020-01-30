package org.flowable.ui.task.conf;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter implements Filter{
	
	@Override
		public void init(FilterConfig filterConfig) throws ServletException {
			// TODO Auto-generated method stub
			
		}

   @Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
		throws IOException, ServletException {
	// TODO Auto-generated method stub
	   
   	HttpServletRequest request = (HttpServletRequest) req;
	HttpServletResponse response = (HttpServletResponse) res;
//	response.setHeader("Access-Control-Allow-Origin","https://s3.ap-south-1.amazonaws.com");
	response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
	   response.setHeader("Access-Control-Allow-Credentials", "true");
	response.setHeader("Access-Control-Allow-Methods", "POST, GET,PUT, OPTIONS, DELETE");
	response.setHeader("Access-Control-Max-Age", "3600");
	response.setHeader("Access-Control-Allow-Headers", "Authorization, X-Requested-with,Accept,Content-Type");
	response.setHeader("Access-Control-Expose-Headers", "Authorization, X-Requested-with,Accept,Content-Type");
	if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {			
        response.setStatus(HttpServletResponse.SC_OK);
    } else {
    	
        chain.doFilter(req, res);
    } 
   	
}
	
    public void destroy() {}
}