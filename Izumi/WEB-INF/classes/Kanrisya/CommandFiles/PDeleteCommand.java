package Kanrisya.CommandFiles;

import Kanrisya.JDBCFiles.DeleteJdbc;

import java.util.List;
import Kanrisya.ResponseContext;
import Kanrisya.RequestContext;
import java.util.Map;
import Kanrisya.AbstractCommand;

//商品の削除
public class PDeleteCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		Map m = reqc.getParameterMap();
		DeleteJdbc.DeleteProduct(m);
		//resc.setResult(url);

		resc.setTargetCommand("pqs");
		
		return resc;
	}
}
