package Kanrisya;
import java.util.Map;
import java.util.ArrayList;
import java.util.Iterator;

public class GetProductsCommand extends AbstractCommand{
	public String execute(){
	
		ArrayList pList=DbDummy.getDatabase();
		Iterator it = pList.iterator();
		while(it.hasNext()){
			Product p  = (Product)it.next();
			String a = p.getLname();
			//System.out.println("a");
			//System.out.println(a);
		}
		super.setResult(pList);
		
		return "/WEB-INF/jsp/kanrisya.jsp";
	}
	
}
