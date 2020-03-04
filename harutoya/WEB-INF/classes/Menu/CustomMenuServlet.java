package Menu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import Menu.Beans.CustomBentoBean;
import Menu.Beans.CartBean;
import Menu.Beans.TotalPriceBean;
import Menu.Beans.PriceBean;
import Menu.function.price;
import Menu.function.CutURL;
import java.util.*;
import Menu.JDBCFiles.CusSyusyokuDao;
import Menu.JDBCFiles.CustomExcDao;
import Menu.Beans.CustomBean;
import Menu.Beans.ElementBean;
import Menu.Beans.CustomCartBean;
import Menu.exception.ReturnHomeException;
import Menu.function.NumberCheck;

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

        CustomExcDao ce = new CustomExcDao();
        System.out.println("syusyoku"+syusyoku);
        System.out.println("syusai"+syusai);
        System.out.println("huku1"+huku1);
        System.out.println("huku2"+huku2);

        System.out.println(NumberCheck.isNumber(syusyoku));
        
        if(!NumberCheck.isNumber(syusyoku)|!NumberCheck.isNumber(syusai)|!NumberCheck.isNumber(huku1)|!NumberCheck.isNumber(huku2)){
            throw new ReturnHomeException("正しく入力されていません");
        }
        

        if(ce.getProduct(syusyoku,"主食")||ce.getProduct(syusai,"主菜")||ce.getProduct(huku1,"副菜")||ce.getProduct(huku2,"副菜")){
            throw new ReturnHomeException("正しく入力されていません");
        }

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
        RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/jsp/menu/order.jsp");
		
		dispatcher.forward(req,res);
	}
}