package Menu;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.*;
import Menu.Beans.Product;
import Menu.Beans.CustomCartBean;

//一つの商品だけ削除
public class RemoveServlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        doPost(req,res);
    }
public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        req.setCharacterEncoding("UTF-8");
        HttpSession h=req.getSession();
        if(req.getParameter("judge").equals("1")){
            CustomCartBean ccb= (CustomCartBean)h.getAttribute("ccb");
            int minus_money = ccb.customRemove(Integer.parseInt(req.getParameter("judge"))-1);
            ccb.setCustom_total_money(ccb.getCustom_total_money()-minus_money); 
        }else if(req.getParameter("judge").equals("2")){
            h.removeAttribute("ccb");
            h.removeAttribute("cart");
            h.removeAttribute("totalPrice");
            h.removeAttribute("list");
        }else{
            int key = Integer.parseInt((String)req.getParameter("remove"));
            key = key - 1;
            //
            String id = req.getParameter("id");
            //Seesionにカートの中身を格納するためにSessionを取得
            //カートと個数と合計金額を取得
            ArrayList cartList = (ArrayList)h.getAttribute("cart");
            Map map = (Map)h.getAttribute("list");
            //ArrayList count = (ArrayList)h.getAttribute("list");//keyはid
            int totalPrice = (Integer)h.getAttribute("totalPrice");
            System.out.println("totalPrice"+totalPrice);
            
            //---------------合計金額の処理-------------
            Product p = (Product)cartList.get(key);
            int price = Integer.parseInt(p.getPro_price());

            int count = Integer.parseInt((String)map.get(id));
            int newPrice = totalPrice - price*count;
            System.out.println("newPrice"+newPrice+"price"+price);
            //---------------ここまで-----------------

            //セッションからループした回数-1のcartList番号の商品だけ削除
            cartList.remove(key);

            //よくわからんけどidのやつだけ削除しとく
            System.out.println("RemoveID:"+id);
            map.remove(id);
            
            //削除した後のカートを登録
            h.setAttribute("cart", cartList);
            //合計金額
            h.setAttribute("totalPrice", newPrice);
            //nullにした個数をセット
            h.setAttribute("list", map);
        }
		RequestDispatcher dispatcher=req.getRequestDispatcher("/order.jsp");
		
		dispatcher.forward(req,res);

	}
}