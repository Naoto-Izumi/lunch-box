package Kanrisya.CommandFiles;

//店舗の表示

import Kanrisya.JDBCFiles.StoreQuery;
import java.util.List;
import Kanrisya.ResponseContext;
import Kanrisya.RequestContext;
import java.util.Map;
import Kanrisya.AbstractCommand;


public class SQueryCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		List sd = StoreQuery.getAllStore();
		//req.setAttribute("store",sd);
		String url = "WEB-INF/jsp/kanrisya/store.jsp";

		resc.setResult(url);
		resc.setTarget("kanrisya/store");
		return resc;
		}
}
