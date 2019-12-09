package Kanrisya.Lock;

public class AddProductCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		//RequestContextクラスをインスタンス化する。
		RequestContext reqc = getRequestContext();
		
		//String配列の変数aoをRequestContextの変数でパラメータを呼び出す。
		String[] ao = reqc.getParameter("id");
		
		//変数aaaaaを配列の変数にセットする。
		String aaaaa = ao[0];
		
		//Productクラスをインスタンス化する。
		Product p = new Product();
		
		//Productクラスの変数でId列をセットする。
		p.setId(aaaaa);
		
		//変数aaaaaを表示する。
		System.out.println(aaaaa);
		
		//Daoパターンのクラスの変数でそれぞれのgetメソッドを呼び出す。
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductsDao dao = factory.getProductsDao();
		
		//ProductsDaoの変数でaddProduct()メソッドを呼び出す。
		dao.addProduct(p);
		
		resc.setTarget("kanrisya/kanrisya");	//kanrisya.jspに転送
		
		return resc;
		
	}
}

	
		