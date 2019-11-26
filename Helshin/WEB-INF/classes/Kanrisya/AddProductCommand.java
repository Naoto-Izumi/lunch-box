package Kanrisya;
import java.util.Map;

public class AddProductCommand extends AbstractCommand{
	
	public String execute(){
		Product p=new Product();
		//FrontServlet f = new FrontServlet();
		
		//parameterMapからnameとpriceうけとる
		Map parameters = getParameters();
		
		String aaaaa = ((String[])parameters.get("lastname"))[0];	//requestで送られてきたキーのパラメーター
		
		//Product[] s = new 
		//lock
		
		System.out.println(aaaaa);
		//System.out.println(id);
		//System.out.println(mail);
		//System.out.println(telphone);
		//lock
		
		//受け取った物をproductにsetする
		String o = p.getLname();//別のクラスでpをセットする
		//p.getId(id);
		//p.getMail(mail);
		//p.getTelphone(telphone);
		//lock
		
		//データベースに登録する
		DbDummy.addProduct(p);
		
		return "/view";
		
	}
}

	
		