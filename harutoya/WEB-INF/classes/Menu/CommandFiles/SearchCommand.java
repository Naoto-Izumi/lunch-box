package Menu.CommandFiles;

import java.io.IOException;

import Main.AbstractCommand;
import Main.RequestContext;
import Main.ResponseContext;
import javax.servlet.http.HttpSession;
import java.util.*;
import Menu.JDBCFiles.SearchDao;
import Menu.Beans.Product;

public class SearchCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){
        RequestContext reqc = getRequestContext();

        Product p = new Product();

        String sname=((String[])reqc.getParameter("sname"))[0];

        System.out.println(sname);

        p.setPro_name(sname);
     
        SearchDao rd=new SearchDao();
        rd.addProduct(p);
        List pl = rd.getAllProducts();

        reqc.setSessionObject("product",pl);
		resc.setTarget("menu/menu");
		
		return resc;

	}
}