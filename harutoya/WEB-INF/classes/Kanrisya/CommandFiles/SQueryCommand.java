package Kanrisya.CommandFiles;

//店舗の表示

import Kanrisya.JDBCFiles.StoreQuery;
import java.util.List;
import Main.ResponseContext;
import Main.RequestContext;
import java.util.Map;
import Main.AbstractCommand;


public class SQueryCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		List store = StoreQuery.getAllStore();

		resc.setResult(store);
		resc.setResultName("store");
		
		resc.setTarget("kanrisya/store");
		return resc;
		}
}
