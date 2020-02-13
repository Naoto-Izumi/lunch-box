package User.CommandFiles;

import java.util.List;
import User.JDBCFiles.UserQuery;
import Kanrisya.AbstractCommand;
import Kanrisya.ResponseContext;
import Kanrisya.RequestContext;
import Kanrisya.Beans.ProductBean;

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