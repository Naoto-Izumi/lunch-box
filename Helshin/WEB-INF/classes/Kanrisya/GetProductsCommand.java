package Kanrisya;
//import java.util.Map;
import java.util.List;

//import dao.AbstractDaoFactory;
//import dao.ProductsDao;

public class GetProductsCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		String[] ao = reqc.getParameter("lastname");
		String lastname = ao[0];
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductsDao dao = factory.getProductsDao();//OraProductsDaoなのでは！？
		
		
		List products = dao.getProduct(lastname);
		
		resc.setResult(products);
		resc.setTarget("kanrisya/kanrisya");
		
		return resc;
	}
	
}
