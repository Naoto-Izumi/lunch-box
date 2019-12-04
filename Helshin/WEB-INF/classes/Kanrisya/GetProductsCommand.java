package Kanrisya;
import java.util.Map;
import java.util.List;

public class GetProductsCommand extends AbstractCommand{
	public String execute(){
		
		Map parameters = getParameters();
		
		String lname =((String[])parameters.get("lastname"))[0];
	
		List pList = KanrisyaData.OracleKanrisyaData(lname);
		
		setResult(pList);
		
		/*for(int i = 0; i<=9; i++){
			KanrisyaData k = new KanrisyaData
			System.out.println(p.getLid());
			
		}*/
		
		return "/WEB-INF/jsp/kanrisya/kanrisya.jsp";
	}
	
}
