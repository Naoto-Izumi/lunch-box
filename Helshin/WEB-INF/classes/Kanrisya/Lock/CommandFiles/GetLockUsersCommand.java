package Kanrisya.Lock.CommandFiles;

import java.util.List;
import Kanrisya.Lock.ResponseContext;
import Kanrisya.Lock.RequestContext;

import Kanrisya.Lock.Dao.AbstractDaoFactory;
import Kanrisya.Lock.Dao.LockUsersDao;

public class GetLockUsersCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		//RequestContextクラスの変数reqcでRequestContext()メソッドを取得している。
		RequestContext reqc = getRequestContext();
		
		//String[]配列の変数aoでパラーメータを呼び込む。
		String[] ao = reqc.getParameter("lastname");
		
		//パラメータで値を入れたlastname変数でao変数の配列をセット。
		String lastname = ao[0];
		
		//Daoパターンのクラスの変数でそれぞれのgetメソッドを呼び出す。
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		LockUsersDao dao = factory.getLockUsersDao();
		
		//List型の変数LockUsersでLockUsersDaoクラスのgetLockUserBox()メソッドを呼び出す。
		List lockusers = dao.getLockUserBox(lastname);
		
		//ResponseContextの変数でList型の変数をセットする。
		resc.setResult(lockusers);
		
		resc.setTargetCommand("pss");	//kanrisya.jspに転送
		
		return resc;
	}
	
}
