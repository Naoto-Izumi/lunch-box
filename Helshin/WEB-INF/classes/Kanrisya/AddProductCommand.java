package Kanrisya;
import java.util.Map;

public class AddProductCommand extends AbstractCommand{
	
	public String execute(){
		Product p=new Product();
		
		Map parameters = getParameters();	//parameterMapからnameとpriceうけとる
		
		String aaaaa = ((String[])parameters.get("lastname"))[0];	//requestで送られてきたキーのパラメーター
		
		//lock
		
		System.out.println(aaaaa);
		//lock
		
		//受け取った物をproductにsetする
		String o = p.getLname();//別のクラスでpをセットする
		//lock
		
		return "/WEB-INF/jsp/kanrisya/kanrisya.jsp";
		
	}
}

	
		