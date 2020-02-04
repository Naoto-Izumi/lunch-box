package Kanrisya.CommandFiles;

import Kanrisya.ResponseContext;
import Kanrisya.JDBCFiles.StoreQuery;
import Kanrisya.JDBCFiles.RegistJdbc;
import Kanrisya.RequestContext;
import Kanrisya.Beans.StoreBean;
import Kanrisya.AbstractCommand;


public class AddStoreCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		//RequestContextクラスをインスタンス化する。
		RequestContext reqc = getRequestContext();
		
		StoreBean sb = new StoreBean();
		String name=((String[])reqc.getParameter("sname"))[0];
		sb.setName(name);
		
		String address=((String[])reqc.getParameter("saddress"))[0];
		sb.setAddress(address);
		
		String number=((String[])reqc.getParameter("snumber"))[0];
		sb.setPhone(number);
		
		String openhours=((String[])reqc.getParameter("openhours"))[0];
		sb.setHours(openhours);
		
		String closehours=((String[])reqc.getParameter("closehours"))[0];
		sb.setHours(closehours);
		
		//RegistJdbcをBeanに引数を使う。
		
		String storebean = RegistJdbc.RegistStore(sb);
		
		resc.setTarget("kanrisya/product");	//kanrisya.jspに転送
		
		return resc;
		
	}
}

	
		