
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


public class AuthenticateFilter implements Filter{
	public void init(FilterConfig config)throws ServletException{
	}
	public void destroy(){
	}
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException{
		HttpSession session=((HttpServletRequest) req).getSession();//セッションを取得
		String flag=(String)session.getAttribute("token");	//ユーザーidを取得してflagに代入する

		if(flag==null){
			RequestDispatcher dis=req.getRequestDispatcher("/orderlogin");	//flagがnullなら再度ログイン画面へ	
			dis.forward(req,res);
		}else{
			chain.doFilter(req,res);
		}
	}
}