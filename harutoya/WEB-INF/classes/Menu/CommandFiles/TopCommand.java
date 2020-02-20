package Menu.CommandFiles;

import java.io.IOException;

import Main.AbstractCommand;
import Main.RequestContext;
import Main.ResponseContext;
import javax.servlet.http.HttpSession;
import java.util.*;

import Menu.JDBCFiles.MenuDao;

public class TopCommand extends AbstractCommand{
public ResponseContext execute(ResponseContext resc){
        RequestContext reqc = getRequestContext();

        MenuDao md=new MenuDao();
        ArrayList mlist = (ArrayList)md.getAllProducts();
        System.out.println(mlist);
        reqc.setSessionObject("product",mlist);

		resc.setTarget("menu/menu");
		
		return resc;

	}
}