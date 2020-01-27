import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.Map;
import java.util.*;
import dao.MenuPriceDao;
import Bean.Product;

public class MenuServlet extends HttpServlet{


	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		req.setCharacterEncoding("UTF-8");
		//REQUESTからMapを受け取る
		Map m=req.getParameterMap();
        //MapをIteratorにするためにSetに一時的に変換
        Set s=m.keySet();
        //すべて取得するためにIterator  にする
        Iterator it=s.iterator();
        //Seesionにカートの中身を格納するためにSessionを取得
        HttpSession h=req.getSession();
        //Map型でカートを定義
        Map sessionlist;
        //カートが作られてなかったら
        if(null==h.getAttribute("list")){
            sessionlist=new TreeMap();
        }
        //カートが既に作られている場合取得
        else{
            sessionlist=(Map)h.getAttribute("list");
        }
        //カートに商品番号と個数を格納
        ArrayList<Product> al = new ArrayList();
        while(it.hasNext()){
            String key=(String)it.next();
            //jspで入力した個数
            String[] v=(String[])m.get(key);
            //sessionに登録した個数
            String count = (String)sessionlist.get(key);
            //今まで注文したことなかったら

            //仮
            
            if(count != null){
                int total = Integer.parseInt(count)+Integer.parseInt(v[0]);
                sessionlist.put(key,String.valueOf(total));
                break;
            }
            sessionlist.put(key,v[0]);
            System.out.println("キー"+key+"値"+v[0]);
        }
        //SessionとRequestにカートを格納
        h.setAttribute("list",sessionlist);
        req.setAttribute("plist",sessionlist);

        Set sessionset=sessionlist.keySet();
        Iterator sessionit=sessionset.iterator();
        while(sessionit.hasNext()){
            String key1=(String)sessionit.next();
            String id1 = key1.substring(2);
            MenuPriceDao mp = new MenuPriceDao();
            System.out.println(id1);
            al.add(mp.getProduct(id1));

        }
        //Parametorの名前をすべて取得
        Enumeration names = req.getParameterNames();
        String name = (String)names.nextElement();
        //no1などで送られているのを1などに整形
        String id = name.substring(2);
        
        //Parametor名を取得したので値を受け取る
        String vals[] = req.getParameterValues(name);
        //Daoで商品内容を取得
        MenuPriceDao mp = new MenuPriceDao();
        Product p = new Product();
        p.setPro_id(id);
        mp.addProduct(p);
        //ArrayList al = (ArrayList)mp.getAllProducts();

        Iterator ite = al.iterator();
        int total = 0;
        Product pro = (Product)ite.next();
        total = Integer.parseInt(pro.getTotal());
        
        total = total*Integer.parseInt(vals[0]);

        //会計の金額合計(total)をSessionに追加
        if(h.getAttribute("totalPrice") != null){
            Integer i = (Integer)h.getAttribute("totalPrice");
            total += i;
        }
        /*
        if(h.getAttribute("cart") != null){
            ArrayList i = (ArrayList)h.getAttribute("cart");
            i.add(al.get(0));
        }
        */
        req.setAttribute("product",al);
        h.setAttribute("cart",al);
        req.setAttribute("total",total);
        h.setAttribute("totalPrice",total);
        



		RequestDispatcher dispatcher=req.getRequestDispatcher("/order.jsp");
		
		dispatcher.forward(req,res);

	}
}