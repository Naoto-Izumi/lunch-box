package Menu.CommandFiles;

import java.io.IOException;

import Main.RequestContext;
import Main.ResponseContext;
import Main.AbstractCommand;
import javax.servlet.http.HttpSession;
import java.util.*;
import Menu.JDBCFiles.DetailDao;
import Menu.Beans.Product;

public class DetailCommand extends AbstractCommand{

    public ResponseContext execute(ResponseContext resc){
        
        RequestContext reqc = getRequestContext();
        Product p = new Product();

        String id=((String[])reqc.getParameter("id"))[0];

        System.out.println(id);

        id=id.substring(2);

        System.out.println(id);

        p.setPro_id(id);
     
        DetailDao rd=new DetailDao();
        rd.addProduct(p);
        List pl = rd.getAllProducts();

        reqc.setSessionObject("product",pl);
		resc.setTarget("menu/detail");

        return resc;

	}
}