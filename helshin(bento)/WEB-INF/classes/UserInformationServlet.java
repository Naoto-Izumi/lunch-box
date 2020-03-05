import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import Bean.Product;

public class UserInformationServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	

        Product p = new Product();

		req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String tel = req.getParameter("tel");
        String mail = req.getParameter("mail");
        String address = req.getParameter("address");
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        String type = req.getParameter("type");

        

        if(type.equals("1")){
            String cardname=req.getParameter("cardname");
            String cardnumber=req.getParameter("cardnumber");
            String carddate=req.getParameter("carddate");

            System.out.println("cardname"+cardname);
            System.out.println("cardnumber"+cardnumber);
            System.out.println("carddate"+carddate);

            p.setCardname(cardname);
            p.setCardnumber(cardnumber);
            p.setCarddate(carddate);

        }
        


        System.out.println("name"+name);
        System.out.println("tel"+tel);
        System.out.println("mail"+mail);
        System.out.println("address"+address);
        System.out.println("date"+date);
        System.out.println("time"+time);
        System.out.println("type"+type);




        // UserBean p = new UserBean();
        p.setName(name);
        p.setTel(tel);
        p.setMail(mail);
        p.setAddress(address);
        p.setDate(date);
        p.setTime(time);
        p.setType(type);
        HttpSession session = req.getSession();
        session.setAttribute("p",p);

		RequestDispatcher dispatcher=req.getRequestDispatcher("/confirmation.jsp");
		
		dispatcher.forward(req,res);

	}
}