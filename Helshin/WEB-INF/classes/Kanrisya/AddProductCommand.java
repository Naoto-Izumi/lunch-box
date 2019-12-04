package Kanrisya;
import java.util.Map;

public class AddProductCommand extends AbstractCommand{
	
	public String execute(){
		Product p=new Product();
		
		Map parameters = getParameters();	//parameterMapからnameとpriceうけとる
		
		String aaaaa = ((String[])parameters.get("id"))[0];	//requestで送られてきたキーのパラメーター
		
		p.setId(aaaaa);
		KanrisyaInsert.OracleKanrisyaInsert(p);
		
		//lock
		
		System.out.println(aaaaa);
		//lock
		
		
		/*for(int i = 0; i<=9; i++){
			//Product p = new Product();
			System.out.println(p.getLid());
			
		}*/
		//受け取った物をproductにsetする
		String o = p.getLname();//別のクラスでpをセットする
		//lock
		
		return "/WEB-INF/jsp/kanrisya/kanrisya.jsp";
		
	}
}

	
		