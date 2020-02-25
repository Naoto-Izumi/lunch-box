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
import User.JDBCFiles.LoginJdbc;

public class MenuFilter implements Filter{
	public void init(FilterConfig config)throws ServletException{}
	public void destroy(){}
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException{

		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		System.out.println("Menufilter22");
		if(name!=null&&pass!=null){
			System.out.println("Menufilter24");
			String id = LoginJdbc.mlogin(name,pass);
			if(id!=null){
			HttpSession session=((HttpServletRequest)req).getSession();
			session.setAttribute("menutoken",id);
				
			}
		}		
		chain.doFilter(req,res);
	}
}
