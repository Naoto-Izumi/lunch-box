package Menu.CommandFiles;

import java.io.IOException;

import Main.AbstractCommand;
import Main.ResponseContext;
import Main.RequestContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.*;
import Menu.Beans.Product;

import Menu.JDBCFiles.MenuDao;

public class SPUNextCommand extends AbstractCommand{
public ResponseContext execute(ResponseContext resc){

        RequestContext reqc = getRequestContext();
        Product p = new Product();
        //HttpSession h = req.getSession();

        // String date = req.getParameter("date");//日付取得
        // String time = req.getParameter("time");//時間取得
        String st_name = ((String[])reqc.getParameter("st_name"))[0];//店舗名
        String store = ((String[])reqc.getParameter("store"))[0]; //st_id取得

        
        // p.setDate(date);
        // p.setTime(time);
        p.setSt_name(st_name);
        p.setStore(store);
        reqc.setSessionObject("spuData",p);

        
        MenuDao md=new MenuDao();
        ArrayList mlist = (ArrayList)md.getAllProducts();
        System.out.println(mlist);

        resc.setResult(mlist);
        resc.setResultName("product");

		resc.setTarget("menu/menu");

        return resc;

	}
}