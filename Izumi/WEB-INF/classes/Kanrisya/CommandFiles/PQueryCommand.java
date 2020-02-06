package Kanrisya.CommandFiles;

import Kanrisya.JDBCFiles.ProductQuery;
import java.util.List;
import Kanrisya.ResponseContext;
import Kanrisya.RequestContext;
import java.util.Map;
import Kanrisya.AbstractCommand;

//商品の表示
public class PQueryCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		List product = ProductQuery.getAllProducts();
		//reqc.setAttribute("product",ps);
		
		resc.setResult(product);
		resc.setResultName("product");
		resc.setTarget("kanrisya/product");
		return resc;
		}
}
