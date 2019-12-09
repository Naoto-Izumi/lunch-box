package Kanrisya;

//import dao.AbstractDaoFactory;
//import dao.ProductsDao;

public class AddProductCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		//Map parameters = getParameters();	//parameterMapからnameとpriceうけとる
		
		//String aaaaa = ((String[])parameters.get("id"))[0];	//requestで送られてきたキーのパラメーター
		
		String[] ao = reqc.getParameter("id");
		String aaaaa = ao[0];
		
		Product p = new Product();
		
		p.setId(aaaaa);
		//KanrisyaInsert.OracleKanrisyaInsert(p);
		
		//lock
		
		System.out.println(aaaaa);
		//lock
		
		
		/*for(int i = 0; i<=9; i++){
			//Product p = new Product();
			System.out.println(p.getLid());
			
		}*/
		//受け取った物をproductにsetする
		//String o = p.getLname();//別のクラスでpをセットする
		//lock
		
		//return "/WEB-INF/jsp/kanrisya/kanrisya.jsp";
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductsDao dao = factory.getProductsDao();
		dao.addProduct(p);
		
		resc.setTarget("kanrisya/kanrisya");
		
		return resc;
		
	}
}

	
		