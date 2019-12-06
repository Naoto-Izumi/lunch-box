package User.Regist;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		req.setCharacterEncoding("UTF-8");
		
		/*パラメータを返す*/
		String lname = req.getParameter("lastname");			//名前(上の名前)
		String fname = req.getParameter("firstname");			//名前(下の名前)
		String lhname = req.getParameter("lastname_hira");		//名前(上の名前(ふりがな))
		String fhname = req.getParameter("firstname_hira");		//名前(下の名前(ふりがな))
		String telphone = req.getParameter("phone");			//電話番号
		String mail = req.getParameter("mail");					//メールアドレス
		String pass = req.getParameter("password");				//パスワード
		String address = req.getParameter("address");			//住所
		String sex = req.getParameter("sex");					//性別
		String birth = req.getParameter("birthyear");			//誕生日
		
		UserBox a = new UserBox();		//Beanファイルをインスタンス化

		/*各セット*/
		a.setLname(lname);			//名前(上の名前)をセット
		a.setFname(fname);			//名前(下の名前)をセット
		a.setLhname(lhname);		//名前(上の名前(ふりがな))をセット
		a.setFhname(fhname);		//名前(下の名前(ふりがな))をセット
		a.setTelphone(telphone);	//電話番号をセット
		a.setMail(mail);			//メールアドレスをセット
		a.setPass(pass);			//パスワードをセット
		a.setAddress(address);		//住所をセット
		a.setSex(sex);				//性別をセット
		a.setBirth(birth);			//誕生日をセット
		
		req.setAttribute("userbox",a);	
		
		UserData.OracleUserData(a);	//クラスメソッドを参照
		
		RequestDispatcher f = req.getRequestDispatcher("/helshin");		//Web.xmlに転送
		f.forward(req,res);
	}
}
