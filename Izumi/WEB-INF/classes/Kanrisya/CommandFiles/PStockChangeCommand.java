package Kanrisya.CommandFiles;

import Kanrisya.JDBCFiles.ChangeJdbc;
import java.util.List;
import Kanrisya.ResponseContext;
import Kanrisya.RequestContext;
import java.util.Map;
import Kanrisya.AbstractCommand;

//在庫変更
public class PStockChangeCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		Map m = reqc.getParameterMap();
		ChangeJdbc.ChangeProduct(m);
		
		resc.setTargetCommand("pqs");
		
		return resc;
	}
}
