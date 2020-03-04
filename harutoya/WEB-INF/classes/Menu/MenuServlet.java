package Menu;

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
import Menu.JDBCFiles.MenuPriceDao;
import Menu.Beans.Product;

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
            System.out.println("sessionListがつくられてないとき:"+sessionlist);
        }
        //カートが既に作られている場合取得
        else{
            sessionlist=(Map)h.getAttribute("list");
            System.out.println("sessionListがつくられてるとき:"+sessionlist);
        }
        //カートに商品番号と個数を格納
        
        //jspで入力した個数を残すため
        String[] v = null;
        
        while(it.hasNext()){
            String key = (String)it.next();
            System.out.println("sessionList:"+sessionlist.get(key));
            //jspで入力した個数
            v = (String[])m.get(key);
            //sessionに登録した個数
            String count = (String)sessionlist.get(key);
            //今まで注文したことなかったら

            //仮
            
            if(count != null){
                int total = Integer.parseInt(count)+Integer.parseInt(v[0]);
                System.out.println("totalParse:"+total);
                sessionlist.put(key,String.valueOf(total));
                System.out.println("if内sessionList:"+sessionlist.get(key)+" key:"+key+ " v[0]:"+v[0]);
                break;
            }
            sessionlist.put(key,v[0]);
            System.out.println("キー"+key+" 値"+v[0]+" sessionlist:"+sessionlist);
        }
        //SessionとRequestにカートを格納
        h.setAttribute("list",sessionlist);
        req.setAttribute("plist",sessionlist);

        Set sessionset=sessionlist.keySet();
        Iterator sessionit=sessionset.iterator();

        ArrayList<Product> al = new ArrayList();
        
        while(sessionit.hasNext()){
            String key1=(String)sessionit.next();
            String id1 = null;
            if(key1.length()>=3){
                id1 = key1.substring(2);
            }else{
				id1=key1;
			}
            MenuPriceDao mp = new MenuPriceDao();
            System.out.println("id1:"+id1+" key1:"+key1+ " 注文個数"+ sessionlist.get(key1));
            Product pppp = new Product();
            System.out.println();
            pppp.setCount((String)sessionlist.get(key1));
            pppp.setPro_id(id1);
            mp.addProduct(pppp);
            //DAO内で合計金額を出してる（出せてるといいな）
            al.addAll((ArrayList)mp.getAllProducts());
        }
        // //Parametorの名前をすべて取得
        // Enumeration names = req.getParameterNames();
        // String name = (String)names.nextElement();
        // //no1などで送られているのを1などに整形
        // String id = name.substring(2);
        
        // //Parametor名を取得したので値を受け取る
        //String vals[] = req.getParameterValues(name);
        // //Daoで商品内容を取得
        // MenuPriceDao mp = new MenuPriceDao();
        // Product p = new Product();
        // p.setPro_id(id);
        // mp.addProduct(p);
        //ArrayList al = (ArrayList)mp.getAllProducts();

        //すべての商品の値段合計
        int totalPrice = 0;
        for(int i = 0; i < al.size(); i++){
            Product ppp = al.get(i);
            totalPrice += Integer.parseInt(ppp.getTotal());
            System.out.println("totalPrice:"+totalPrice);
        }


        // int total = 0;
        // Product pro = (Product)ite.next();
        // System.out.println("al"+al+"pro"+pro);
        // total = Integer.parseInt(pro.getTotal());
        // System.out.println("totalIterator" + total);
        
        //total = total*Integer.parseInt(vals[0]);

        //会計の金額合計(total)をSessionに追加
        // if(h.getAttribute("totalPrice") != null){
        //     Integer i = (Integer)h.getAttribute("totalPrice");
        //     System.out.println("totalprice:"+i);
        //     total += i;
        // }
        /*
        if(h.getAttribute("cart") != null){
            ArrayList i = (ArrayList)h.getAttribute("cart");
            i.add(al.get(0));
        }
        */
        req.setAttribute("product",al);
        h.setAttribute("cart",al);
        req.setAttribute("total",totalPrice);
        h.setAttribute("totalPrice",totalPrice);
        



		RequestDispatcher dispatcher=req.getRequestDispatcher("/order.jsp");
		
		dispatcher.forward(req,res);

	}
}