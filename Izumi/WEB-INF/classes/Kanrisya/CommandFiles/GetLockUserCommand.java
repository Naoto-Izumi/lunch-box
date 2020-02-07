package Kanrisya.CommandFiles;

import java.util.List;
import Kanrisya.ResponseContext;
import Kanrisya.RequestContext;
import Kanrisya.AbstractCommand;
import Kanrisya.JDBCFiles.LockUserData;

public class GetLockUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		//RequestContextクラスの変数reqcでRequestContext()メソッドを取得している。
		RequestContext reqc = getRequestContext();
		
		//String[]配列の変数aoでパラーメータを呼び込む。
		String[] ao = reqc.getParameter("lastname");
		
		//パラメータで値を入れたlastname変数でao変数の配列をセット。
		String lastname = ao[0];
		
		//List型の変数LockUsersでLockUsersDaoクラスのgetLockUserBox()メソッドを呼び出す。
		List lockusers = LockUserData.OracleLockUserData(lastname);
		
		//ResponseContextの変数でList型の変数をセットする。
		resc.setResult(lockusers);
		
		resc.setTarget("kanrisya/user");	//kanrisya.jspに転送
		
		return resc;
	}
	
}
