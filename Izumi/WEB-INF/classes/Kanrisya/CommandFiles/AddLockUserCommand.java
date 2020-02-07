package Kanrisya.CommandFiles;

import Kanrisya.ResponseContext;
import Kanrisya.RequestContext;
import Kanrisya.Beans.LockUserBox;
import Kanrisya.AbstractCommand;
import Kanrisya.JDBCFiles.LockUserInsert;


public class AddLockUserCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		//RequestContextクラスをインスタンス化する。
		RequestContext reqc = getRequestContext();
		
		//LockUserクラスをインスタンス化する。
		LockUserBox p = new LockUserBox();
		//String配列の変数aoをRequestContextの変数でパラメータを呼び出す。
		String[] ao= reqc.getParameter("id");
		//変数aaaaaを配列の変数にセットする。
		String aaaaa = ao[0];
		//LockUserクラスの変数でId列をセットする。
		p.setId(aaaaa);
		
		//変数aaaaaを表示する。
		System.out.println(aaaaa);
		
		
		if(reqc.getParameter("lock")==null){
			
			
			String locks = "0";
			p.setLocks(locks);
		}else{
			String locks = "1";
			p.setLocks(locks);
		}
		
		//LockUsersDaoの変数でaddLockUser()メソッドを呼び出す。
		LockUserInsert.OracleLockUserInsert(p);
		
		resc.setTargetCommand("ks");	//kanrisya.jspに転送
		
		return resc;
		
	}
}

	
		