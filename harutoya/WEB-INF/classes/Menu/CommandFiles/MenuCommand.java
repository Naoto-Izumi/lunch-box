package Menu.CommandFiles;

import Main.ResponseContext;
import Main.RequestContext;
//import harutoya.Beans.LockUserBox;
import Main.AbstractCommand;
//import Menu.JDBCFiles.LockUserInsert;

import javax.servlet.http.HttpSession;
import java.util.*;
import Menu.JDBCFiles.MenuPriceDao;
import Menu.Beans.Product;
//import Menu.JDBCFiles.AbstractFactory;
import Menu.JDBCFiles.ProductsDao;

public class MenuCommand extends AbstractCommand{


	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		//reqcUESTからMapを受け取る
		Map m=reqc.getParameterMap();
        //MapをIteratorにするためにSetに一時的に変換
        Set s=m.keySet();
        //すべて取得するためにIterator  にする
        Iterator it=s.iterator();
        //Seesionにカートの中身を格納するためにSessionを取得
        //HttpSession h=reqc.getSession();
        //Map型でカートを定義
        Map sessionlist;
        //カートが作られてなかったら
        if(null==reqc.getSessionObject("list")){
            sessionlist=new TreeMap();
        }
        //カートが既に作られている場合取得
        else{
            sessionlist=(Map)reqc.getSessionObject("list");
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
        //Sessionとreqcuestにカートを格納
        reqc.setSessionObject("list",sessionlist);
        resc.setResult(sessionlist);
		resc.setResultName("plist");

        Set sessionset=sessionlist.keySet();
        Iterator sessionit=sessionset.iterator();
        while(sessionit.hasNext()){
            String key1=(String)sessionit.next();
            String id1 = null;
            if(key1.length()==3){
                id1 = key1.substring(2);
            }else{
				id1=key1;
			}
            MenuPriceDao mp = new MenuPriceDao();
            System.out.println(id1);
            al.add(mp.getProduct(id1));

        }
        //Parametorの名前をすべて取得
        Enumeration names = reqc.getParameterNames();
        String name = (String)names.nextElement();
        //no1などで送られているのを1などに整形
        String id = name.substring(2);
        
        //Parametor名を取得したので値を受け取る
        String vals[] = reqc.getParameter(name);
        //Daoで商品内容を取得
        MenuPriceDao mp = new MenuPriceDao();
        Product p = new Product();
        p.setPro_id(id);
        mp.addProduct(p);
        //ArrayList al = (ArrayList)mp.getAllProducts();

        Iterator ite = al.iterator();
        int total = 0;
        Product pro = (Product)ite.next();
        System.out.println("al"+al+"pro"+pro);
        total = Integer.parseInt(pro.getTotal());
        
        total = total*Integer.parseInt(vals[0]);

        //会計の金額合計(total)をSessionに追加
        if(reqc.getSessionObject("totalPrice") != null){
           // Integer i = (Integer)reqc.getSessionObject("totalPrice");
           // total += i;
        }
        
		//AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		//ProductsDao dao = factory.getProductsDao();
		
		//List menu = ProductsDao.getProduct();
		
		//MenuPriceDao.getProduct(mp);
		
		reqc.setResult("product",al);
        reqc.setSessionObject("cart",al);
		reqc.setResult("total",total);
        reqc.setSessionObject("totalPrice",total);
		//resc.setResult(menu);
		resc.setTarget("menu/order");
		
		return resc;

	}
}