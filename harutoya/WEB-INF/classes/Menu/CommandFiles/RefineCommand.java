package Menu.CommandFiles;

import java.io.IOException;

import Main.AbstractCommand;
import Main.RequestContext;
import Main.ResponseContext;
import javax.servlet.http.HttpSession;
import java.util.*;
import Menu.JDBCFiles.RefineDao;
import Menu.Beans.Product;

public class RefineCommand extends AbstractCommand{
public ResponseContext execute(ResponseContext resc){
        RequestContext reqc = getRequestContext();

        Product p = new Product();

        String s1=((String[])reqc.getParameter("check1"))[0];
        String s2=((String[])reqc.getParameter("check2"))[0];
        String s3=((String[])reqc.getParameter("check3"))[0];
        String s4=((String[])reqc.getParameter("check4"))[0];
        String s5=((String[])reqc.getParameter("check5"))[0];
        String s6=((String[])reqc.getParameter("check6"))[0];
        String s7=((String[])reqc.getParameter("check7"))[0];

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);

        p.setPro_wheat(s1);
        p.setPro_egg(s2);
        p.setPro_milk(s3);
        p.setPro_peanuts(s4);
        p.setPro_buckwheat(s5);
        p.setPro_shrimp(s6);
        p.setPro_crab(s7);
        
        RefineDao rd=new RefineDao();
        rd.addProduct(p);
        List pl = rd.getAllProducts();

        reqc.setSessionObject("product",pl);
		resc.setTarget("menu/menu");
        
        return resc;

	}
}