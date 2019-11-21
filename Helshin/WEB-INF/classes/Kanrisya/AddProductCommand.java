package Kanrisya;
import java.util.Map;

public class AddProductCommand extends AbstractCommand{
	
	public String execute(){
		Product p=new Product();
		
		//parameterMapからnameとpriceうけとる
		Map parameters = getParameters();
		
		String name = ((String[])parameters.get("name"))[0];	//requestで送られてきたキーのパラメーター
		System.out.println(name);
		//String id = ((String[])parameters.get("id"))[0];	//requestで送られてきたキーのパラメーター
		//String tel = ((String[])parameters.get("telphone"))[0];
		//String mail = ((String[])parameters.get("mail"))[0];
		
		//受け取った物をproductにsetする
		p.setName(name);
		//p.setId(id);
		//p.setTelphone(tel);
		//p.setMail(mail);
		
		//データベースに登録する
		DbDummy.addProduct(p);
		
		return "/view";
		
	}
}

	
		