package Kanrisya.CommandFiles;

//店舗の削除

import Kanrisya.JDBCFiles.DeleteJdbc;
import java.util.List;
import Kanrisya.ResponseContext;
import Kanrisya.RequestContext;
import java.util.Map;
import Kanrisya.AbstractCommand;

public class SDeleteCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		Map m = reqc.getParameterMap();
		DeleteJdbc.DeleteStore(m);

		resc.setTargetCommand("sqs");
		
		return resc;
		
		}
}
