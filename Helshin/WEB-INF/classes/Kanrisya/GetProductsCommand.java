package Kanrisya;
import java.util.Map;
import java.util.List;

public class GetProductsCommand extends AbstractCommand{
	public String execute(){
		
		Map parameters = getParameters();
		
		String lname =((String[])parameters.get("lastname"))[0];
	
		List pList = KanrisyaData.OracleKanrisyaData(lname);
		
		super.setResult(pList);
		
		return "/WEB-INF/jsp/kanrisya/kanrisya.jsp";
	}
	
}
