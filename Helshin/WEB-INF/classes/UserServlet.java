//package User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import User.UserBox;

public class UserServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		req.setCharacterEncoding("UTF-8");
		
		String lname = req.getParameter("lastname");
		String fname = req.getParameter("firstname");
		String lhname = req.getParameter("lastname_hira");
		String fhname = req.getParameter("firstname_hira");
		String telphone = req.getParameter("phone");
		String mail = req.getParameter("mail");
		String pass = req.getParameter("password");
		String address = req.getParameter("address");
		String sex = req.getParameter("sex");
		String birth = req.getParameter("birthyear");
		
		UserBox a = new UserBox();
		//a.UserBox(lname,fname,lhname,fhname,telphone,mail,pass,address,sex,birth,tableName);
		
		a.setLname(lname);
		a.setFname(fname);
		a.setLhname(lhname);
		a.setFhname(fhname);
		a.setTelphone(telphone);
		a.setMail(mail);
		a.setPass(pass);
		a.setAddress(address);
		a.setSex(sex);
		a.setBirth(birth);
		
		req.setAttribute("userbox",a);
		
		UserData.OracleUserData(a);	//クラスメソッドを参照
			
		//req.setAttribute("email",email);
		//req.setAttribute("tel",tel);
		
		RequestDispatcher f = req.getRequestDispatcher("/helshin");
		f.forward(req,res);
	}
}
