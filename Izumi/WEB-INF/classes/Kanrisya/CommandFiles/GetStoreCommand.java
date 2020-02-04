package Kanrisya.CommandFiles;

import java.util.List;
import Kanrisya.ResponseContext;
import Kanrisya.RequestContext;
import java.util.Map;
import Kanrisya.AbstractCommand;

import Kanrisya.JDBCFiles.StoreQuery;
import Kanrisya.Beans.StoreBean;
import Kanrisya.JDBCFiles.RegistJdbc;

public class GetStoreCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		//RequestContextクラスの変数reqcでRequestContext()メソッドを取得している。
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
		
		//ResponseContextの変数でList型の変数をセットする。
		resc.setResult(storebean);
		
		resc.setTargetCommand("sqs");	//kanrisya.jspに転送
		
		return resc;
	
	}
	
}
