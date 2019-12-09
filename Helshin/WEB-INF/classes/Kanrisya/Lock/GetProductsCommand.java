package Kanrisya.Lock;
import java.util.List;

public class GetProductsCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		//RequestContextクラスの変数reqcでRequestContext()メソッドを取得している。
		RequestContext reqc = getRequestContext();
		
		//String[]配列の変数aoでパラーメータを呼び込む。
		String[] ao = reqc.getParameter("lastname");
		
		//パラメータで値を入れたlastname変数でao変数の配列をセット。
		String lastname = ao[0];
		
		//Daoパターンのクラスの変数でそれぞれのgetメソッドを呼び出す。
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductsDao dao = factory.getProductsDao();
		
		//List型の変数productsでProductsDaoクラスのgetProduct()メソッドを呼び出す。
		List products = dao.getProduct(lastname);
		
		//ResponseContextの変数でList型の変数をセットする。
		resc.setResult(products);
		
		resc.setTarget("kanrisya/kanrisya");	//kanrisya.jspに転送
		
		return resc;
	}
	
}
