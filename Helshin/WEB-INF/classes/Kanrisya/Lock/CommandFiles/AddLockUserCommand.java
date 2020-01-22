package Kanrisya.Lock.CommandFiles;

import Kanrisya.Lock.ResponseContext;
import Kanrisya.Lock.Dao.AbstractDaoFactory;
import Kanrisya.Lock.Dao.LockUsersDao;
import Kanrisya.Lock.RequestContext;
import Kanrisya.Lock.Beans.LockUserBox;


public class AddLockUserCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		//RequestContextクラスをインスタンス化する。
		RequestContext reqc = getRequestContext();
		
		//String配列の変数aoをRequestContextの変数でパラメータを呼び出す。
		String[] ao = reqc.getParameter("id");
		
		//変数aaaaaを配列の変数にセットする。
		String aaaaa = ao[0];
		
		//LockUserクラスをインスタンス化する。
		LockUserBox p = new LockUserBox();
		
		//LockUserクラスの変数でId列をセットする。
		p.setId(aaaaa);
		
		//変数aaaaaを表示する。
		System.out.println(aaaaa);
		
		//Daoパターンのクラスの変数でそれぞれのgetメソッドを呼び出す。
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		LockUsersDao dao = factory.getLockUsersDao();
		
		//LockUsersDaoの変数でaddLockUser()メソッドを呼び出す。
		dao.addLockUserBox(p);
		
		resc.setTarget("kanrisya/kanrisya");	//kanrisya.jspに転送
		
		return resc;
		
	}
}

	
		