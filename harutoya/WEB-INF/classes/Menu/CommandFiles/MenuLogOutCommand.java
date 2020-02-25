package Menu.CommandFiles;

import Main.ResponseContext;
import Main.RequestContext;
import Main.AbstractCommand;

import javax.servlet.http.HttpSession;
import java.util.*;
import Menu.JDBCFiles.MenuPriceDao;
import Menu.Beans.Product;
import Menu.JDBCFiles.ProductsDao;

public class MenuLogOutCommand extends AbstractCommand{


	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		reqc.setSessionObject("menutoken",null);
		
		resc.setTarget("menu/menuorderlogout");
		
		return resc;

	}
}