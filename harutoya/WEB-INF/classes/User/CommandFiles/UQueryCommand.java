package User.CommandFiles;

import java.util.List;
import User.JDBCFiles.UserQuery;
import Main.AbstractCommand;
import Main.ResponseContext;
import Main.RequestContext;
import Menu.Beans.ProductBean;

//ユーザ情報を表示
public class UQueryCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		//JDBCにユーザ情報を要求
		System.out.println("UQueryCommand"+reqc.getId());
		List ps = UserQuery.getUser(reqc.getId());
		resc.setResult(ps);
		resc.setTarget("user/userinfo");
		return resc;
		
	}
}