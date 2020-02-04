package Kanrisya.CommandFiles;

import java.util.List;
import Kanrisya.ResponseContext;
import Kanrisya.RequestContext;
import Kanrisya.AbstractCommand;
import java.util.Map;

import Kanrisya.JDBCFiles.UriageData;
import Kanrisya.JDBCFiles.KanrisyaInsert;
import Kanrisya.Beans.UriageBox;
//import Kanrisya.Lock.Dao.AbstractDaoFactory;
//import Kanrisya.Lock.Dao.LockUsersDao;

public class GetUriageCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		//RequestContextクラスの変数reqcでRequestContext()メソッドを取得している。
		RequestContext reqc = getRequestContext();
		
		//String[]配列の変数aoでパラーメータを呼び込む。
		//String[] ao = reqc.getParameter("lastname");
		
		//パラメータで値を入れたlastname変数でao変数の配列をセット。
		//String lastname = ao[0];
		
		//Daoパターンのクラスの変数でそれぞれのgetメソッドを呼び出す。
		//AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		//LockUsersDao dao = factory.getLockUsersDao();
		
		//List型の変数LockUsersでLockUsersDaoクラスのgetLockUserBox()メソッドを呼び出す。
		//List lockusers = dao.getLockUserBox(lastname);
		
		UriageBox ub = new UriageBox();
		
		String year = ((String[])reqc.getParameter("nen"))[0];
		ub.setYear(year);
		
		String month = ((String[])reqc.getParameter("tuki"))[0];
		ub.setMonth(month);
		
		String uriagebox = UriageData.OracleUriageData(ub);
		
		//ResponseContextの変数でList型の変数をセットする。
		resc.setResult(uriagebox);
		
		resc.setTargetCommand("us");	//kanrisya.jspに転送
		
		return resc;
	}
	
}
