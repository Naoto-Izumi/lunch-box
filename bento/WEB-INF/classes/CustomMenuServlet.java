import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import Bean.CustomBentoBean;
import Bean.CartBean;
import Bean.TotalPriceBean;
import Bean.PriceBean;
import function.price;
import function.CutURL;
import java.util.*;
import dao.CusSyusyokuDao;
import Bean.CustomBean;
import Bean.ElementBean;
import Bean.CustomCartBean;

public class CustomMenuServlet extends HttpServlet{
    
    private CartBean cb = new CartBean();
    private TotalPriceBean tpb = new TotalPriceBean();

    public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
        doPost(req,res);
    }	

	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
        HttpSession session = req.getSession();
		
		req.setCharacterEncoding("UTF-8");

        CustomCartBean ccb = (CustomCartBean)session.getAttribute("ccb");
        if(ccb == null){
            ccb = new CustomCartBean();
        }
		String syusyoku=req.getParameter("syusyoku").substring(11).replace(".jpg","");
		String syusai=req.getParameter("syusai").substring(11).replace(".jpg","");
        String huku1=req.getParameter("huku1").substring(11).replace(".jpg","");
		String huku2=req.getParameter("huku2").substring(11).replace(".jpg","");
        CusSyusyokuDao cd = new CusSyusyokuDao();
        CustomBean cb = new CustomBean();
        ElementBean eb = cd.getProduct(syusyoku); 
        ElementBean eb1 = cd.getProduct(syusai); 
        ElementBean eb2 = cd.getProduct(huku1); 
        ElementBean eb3 = cd.getProduct(huku2); 
        cb.setTotal_money(eb.getMoney()+eb1.getMoney()+eb2.getMoney()+eb3.getMoney());
        cb.elementAdd(eb);
        cb.elementAdd(eb1);
        cb.elementAdd(eb2);
        cb.elementAdd(eb3);
        ccb.customAdd(cb); 
        ccb.setCustom_total_money(ccb.getCustom_total_money()+cb.getTotal_money()); 
        session.setAttribute("ccb",ccb);
        RequestDispatcher dispatcher=req.getRequestDispatcher("/order.jsp");
		
		dispatcher.forward(req,res);
	}
}