import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.*;
import Bean.Product;

//一つの商品だけ削除
public class RemoveServlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        doPost(req,res);
    }
public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        req.setCharacterEncoding("UTF-8");

        String key = req.getParameter("remove");
        String count = req.getParameter("count");
        //Seesionにカートの中身を格納するためにSessionを取得
        HttpSession h=req.getSession();
        //Map型でカートと個数と合計金額を取得
        Map sessionlist = (Map)h.getAttribute("cart");//keyはid
        //ArrayList count = (ArrayList)h.getAttribute("list");
        int totalprice = Integer.parseInt(h.getAttribute("totalPrice"));
        
        Product p = sessionlist.get(key);
        int price = Integer.parseInt(p.getPro_price());

        int newPrice = totalPrice - price;

        //セッションからそのIDの商品だけ削除
        sessionlist.remove(key);
        //削除した後のカートと合計金額を登録
        h.setAttribute("cart", sessionlist);
        //個数（list）
        h.setAttribute("totalPrice", newPrice);

		RequestDispatcher dispatcher=req.getRequestDispatcher("/order.jsp");
		
		dispatcher.forward(req,res);

	}
}