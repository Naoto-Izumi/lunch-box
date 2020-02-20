package Menu.CommandFiles;

import java.io.IOException;
import Main.AbstractCommand;
import Main.RequestContext;
import Main.ResponseContext;
import javax.servlet.http.HttpSession;
import Menu.Beans.Product;

public class UserInformationCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){	

        RequestContext reqc = getRequestContext();
        Product p = new Product();

        String name = ((String[])reqc.getParameter("name"))[0];
        String tel = ((String[])reqc.getParameter("tel"))[0];
        String mail = ((String[])reqc.getParameter("mail"))[0];
        String address = ((String[])reqc.getParameter("address"))[0];
        String date = ((String[])reqc.getParameter("date"))[0];
        String time = ((String[])reqc.getParameter("time"))[0];
        String type = ((String[])reqc.getParameter("type"))[0];

        

        if(type.equals("1")){
            String cardname=((String[])reqc.getParameter("cardname"))[0];
            String cardnumber=((String[])reqc.getParameter("cardnumber"))[0];
            String carddate=((String[])reqc.getParameter("carddate"))[0];

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

        reqc.setSessionObject("p",p);

		resc.setTarget("menu/confirmation");
		
		return resc;

	}
}