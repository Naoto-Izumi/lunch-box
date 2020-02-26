package User.CommandFiles;

import User.JDBCFiles.PHistoryJdbc;
import User.Beans.OrderBean;
import java.util.List;
import Main.ResponseContext;
import Main.RequestContext;
import java.util.Map;
import Main.AbstractCommand;


public class PHistoryCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		String id = (String)reqc.getSessionObject("menutoken");
		
		//String[] aid = reqc.getParameter("id");
		//String id = aid[0];
		OrderBean o = new OrderBean();
		o.setPid(id);
		List ph = PHistoryJdbc.getPhistory(o);
		resc.setResult(ph);
		resc.setResultName("ph");
		resc.setTarget("user/phistory");
		return resc;
		//sessionのメニュートークンを持ってくる
		
	}
}
