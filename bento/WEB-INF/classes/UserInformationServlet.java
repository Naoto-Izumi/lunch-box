import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import Bean.UserBean;

public class UserInformationServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	

        UserBean ub = new UserBean();

		req.setCharacterEncoding("Windows-31J");
        String name = req.getParameter("name");
        String tel = req.getParameter("tel");
        String mail = req.getParameter("mail");
        String address = req.getParameter("address");
        String time = req.getParameter("time");
        String price = req.getParameter("price");

        if(price.equals("1")){
            String cardname=req.getParameter("cardname");
            String cardnumber=req.getParameter("cardnumber");
            String carddate=req.getParameter("carddate");

            System.out.println("cardname"+cardname);
            System.out.println("cardnumber"+cardnumber);
            System.out.println("carddate"+carddate);

            ub.setCardname(cardname);
            ub.setCardnumber(cardnumber);
            ub.setCarddate(carddate);

        }
        


        System.out.println("name"+name);
        System.out.println("tel"+tel);
        System.out.println("mail"+mail);
        System.out.println("address"+address);
        System.out.println("time"+time);
        System.out.println("price"+price);




        // UserBean ub = new UserBean();
        ub.setName(name);
        ub.setTel(tel);
        ub.setMail(mail);
        ub.setAddress(address);
        ub.setTime(time);
        ub.setPrice(price);
        HttpSession session = req.getSession();
        session.setAttribute("ub",ub);

		RequestDispatcher dispatcher=req.getRequestDispatcher("/confirmation.jsp");
		
		dispatcher.forward(req,res);

	}
}