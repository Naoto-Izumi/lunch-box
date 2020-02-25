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
		
		List ph = PHistoryJdbc.getPhistory();
		resc.setResult(ph);
		resc.setResultName("ph");
		resc.setTarget("user/phistory");
		return resc;
		
	}
}
