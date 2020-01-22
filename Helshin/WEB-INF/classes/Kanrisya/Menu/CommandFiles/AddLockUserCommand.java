package Kanrisya.Menu.CommandFiles;

import Kanrisya.Menu.ResponseContext;
import Kanrisya.Menu.Dao.AbstractDaoFactory;
import Kanrisya.Menu.Dao.MenuUsersDao;
import Kanrisya.Menu.RequestContext;
import Kanrisya.Menu.Beans.MenuUserBox;


public class AddMenuUserCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		//RequestContextクラスをインスタンス化する。
		RequestContext reqc = getRequestContext();
		
		//String配列の変数aoをRequestContextの変数でパラメータを呼び出す。
		String[] ao = reqc.getParameter("id");
		
		//変数aaaaaを配列の変数にセットする。
		String aaaaa = ao[0];
		
		//MenuUserクラスをインスタンス化する。
		MenuUserBox p = new MenuUserBox();
		
		//MenuUserクラスの変数でId列をセットする。
		p.setId(aaaaa);
		
		//変数aaaaaを表示する。
		System.out.println(aaaaa);
		
		//Daoパターンのクラスの変数でそれぞれのgetメソッドを呼び出す。
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		MenuUsersDao dao = factory.getMenuUsersDao();
		
		//MenuUsersDaoの変数でaddMenuUser()メソッドを呼び出す。
		dao.addMenuUserBox(p);
		
		resc.setTarget("kanrisya/product");	//kanrisya.jspに転送
		
		return resc;
		
	}
}

	
		