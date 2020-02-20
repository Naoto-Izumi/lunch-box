package Menu.CommandFiles;

import java.io.IOException;

import Main.AbstractCommand;
import Main.RequestContext;
import Main.ResponseContext;
import javax.servlet.http.HttpSession;
import java.util.*;
import Menu.JDBCFiles.StoreDao;

public class StoreCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){
        RequestContext reqc = getRequestContext();

        StoreDao st=new StoreDao();
        ArrayList slist = (ArrayList)st.getAllProducts();
        System.out.println(slist);
        reqc.setSessionObject("product",slist);

		resc.setTarget("menu/store");
		
		return resc;

	}
}