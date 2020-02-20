package Menu.CommandFiles;

import java.io.IOException;

import Main.AbstractCommand;
import Main.RequestContext;
import Main.ResponseContext;
import javax.servlet.http.HttpSession;
import java.util.*;

import Menu.JDBCFiles.OrderInDao;
import Menu.Beans.Product;



public class CompleteCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){	
		RequestContext reqc = getRequestContext();
        //HttpSession session = req.getSession();
        // UserBean ub = (UserBean)session.getAttribute("ub");
		Product p=(Product)reqc.getSessionObject("p");
		
		System.out.println(p);
        //データベースに個人情報・購入したものをinsertする

		// ProductUpDao pr=new ProductUpDao();

		Map m=(Map)reqc.getSessionObject("list");
		Set s=m.keySet();
        Iterator it=s.iterator();
		while(it.hasNext()){
            String key=(String)it.next();
			String v = null;
			if(m.get(key) instanceof Integer){
				Integer integer = (Integer)m.get(key);
				v = Integer.toString(integer);
			}else{
				v = (String)m.get(key);
			}
            
			System.out.println("キー"+key+"値"+v);
			String num = null;
			if(key.length()==3){
				num=key.substring(2);
			}else{
				num=key;
			}


        
            p.setNum(num);
			p.setStock(v);

            System.out.println("キー"+key+"値"+v+"切り取り後"+num);

			OrderInDao pi=new OrderInDao();
			pi.addProduct(p);
        }
		// pr.addProduct(p);

		// OrderInDao pi=new OrderInDao();
		// pi.addProduct(p);
		//sessionを消す
		reqc.DeleteSession();






		resc.setTarget("menu/complete");
		return resc;

	}
}