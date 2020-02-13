import java.util.List;
import JDBCFiles.UserQuery;
import Basic.AbstractCommand;
import Basic.ResponseContext;
import Basic.RequestContext;
import Beans.ProductBean;

//ユーザ情報を表示
public class UQueryCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		//JDBCにユーザ情報を要求
		System.out.println("UQueryCommand"+reqc.getId());
		List ps = UserQuery.getUser(reqc.getId());
		resc.setResult(ps);
		resc.setTarget("userinfo");
		return resc;
		
	}
}