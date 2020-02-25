package Menu;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class MenuAuthenticateFilter implements Filter{
	public void init(FilterConfig config)throws ServletException{
	}
	public void destroy(){
	}
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException{
		HttpSession session=((HttpServletRequest) req).getSession();
		String flag=(String)session.getAttribute("menutoken");
		System.out.println("MenuAuthenticatefilter24");
		if(flag==null){
			System.out.println("MenuAuthenticatefilter26");
			RequestDispatcher dis=req.getRequestDispatcher("/WEB-INF/jsp/menu/menuorderlogin.jsp");
			dis.forward(req,res);
		}else{
			System.out.println("MenuAuthenticatefilter28");
			chain.doFilter(req,res);
		}
	}
}