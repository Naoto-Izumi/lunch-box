package Kanrisya.CommandFiles;

import Kanrisya.JDBCFiles.ProductQuery;
import java.util.List;
import Kanrisya.ResponseContext;
import Kanrisya.RequestContext;
import java.util.Map;
import Kanrisya.AbstractCommand;

//変更用商品の表示
public class PStockCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		List product = ProductQuery.getAllProducts();
		String url = "WEB-INF/jsp/kanrisya/product.jsp";

		resc.setResult(url);
		resc.setTarget("kanrisya/product");
		return resc;
		}
}
