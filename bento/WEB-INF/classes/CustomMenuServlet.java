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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.*;

public class CustomMenuServlet extends HttpServlet{
    private CartBean cb = new CartBean();
    private TotalPriceBean tpb = new TotalPriceBean();

	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		req.setCharacterEncoding("UTF-8");
		
		String syusyoku=req.getParameter("syusyoku");
		String syusai=req.getParameter("syusai");
        String huku1=req.getParameter("huku1");
		String huku2=req.getParameter("huku2");
        
        CustomBentoBean cbb = new CustomBentoBean();
        cbb.setSyusyoku(CutURL.getString(syusyoku));
        cbb.setSyusai(CutURL.getString(syusai));
        cbb.setHuku1(CutURL.getString(huku1));
        cbb.setHuku2(CutURL.getString(huku2));

        price p = new price();
        int Syusyoku = p.priceIf(syusyoku);
        int Syusai = p.priceIf(syusai);
        int Huku1 = p.priceIf(huku1);
        int Huku2 = p.priceIf(huku2);
        int total = Syusyoku+Syusai+Huku1+Huku2;

        PriceBean pb = new PriceBean();
        pb.setSyusyoku(Syusyoku);
        pb.setSyusai(Syusai);
        pb.setHuku1(Huku1);
        pb.setHuku2(Huku2);
        pb.setTotal(total);

        tpb.addPrice(pb);
        int realTotal = 0;
        ArrayList list = tpb.getPriceList();
        Iterator it = list.iterator();
        while(it.hasNext()){
            PriceBean priceb = (PriceBean)it.next();
            realTotal += priceb.getTotal();
        }


        cb.addBento(cbb);
        
        HttpSession session = req.getSession();
        session.setAttribute("tpb",tpb);
        session.setAttribute("realTotal",realTotal);
        session.setAttribute("cb",cb);

        Map sessionlist;
        
        if(null==session.getAttribute("list")){
            sessionlist=new TreeMap();
        }else{
            sessionlist=(Map)session.getAttribute("list");
        }
        req.setAttribute("plist",sessionlist);
			
		RequestDispatcher dispatcher=req.getRequestDispatcher("/order.jsp");
		
		dispatcher.forward(req,res);

	}
}