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
import JDBCFiles.LoginJdbc;


public class LoginCheckFilter implements Filter{
	public void init(FilterConfig config)throws ServletException{
	}
	public void destroy(){
	}
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException{

		String name=req.getParameter("name");	//キーを引数に名前を取得(メールアドレス)
		String pass=req.getParameter("pass");	//キーを引数にパスワードを取得

		if(name!=null&&pass!=null){	//名前かパスワードがnullでないなら(値がある！)
			
			String id = LoginJdbc.login(name,pass);//その値があるか確認
			if(id!=null){			//ユーザーidがnullでないなら(値がある！)
				//セッションを取得
				HttpSession session=((HttpServletRequest)req).getSession();
				//ユーザーidをセッションにセット
				session.setAttribute("token",id);
			}
		}
		//もとの接続ページに飛ばす
		chain.doFilter(req,res);
	}
}
