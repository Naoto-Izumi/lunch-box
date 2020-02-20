package Kanrisya.CommandFiles;

import Kanrisya.JDBCFiles.DeleteJdbc;

import java.util.List;
import Main.ResponseContext;
import Main.RequestContext;
import java.util.Map;
import Main.AbstractCommand;

//商品の削除
public class PDeleteCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		Map m = reqc.getParameterMap();
		DeleteJdbc.DeleteProduct(m);
		resc.setTargetCommand("pqs");
		
		return resc;
	}
}
