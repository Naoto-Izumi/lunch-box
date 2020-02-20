package Kanrisya.CommandFiles;

import java.util.List;
import Main.ResponseContext;
import Main.RequestContext;
import java.util.Map;
import Main.AbstractCommand;

import Kanrisya.JDBCFiles.StoreQuery;
import Kanrisya.Beans.StoreBean;
import Kanrisya.JDBCFiles.RegistJdbc;

public class SRegistCommand extends AbstractCommand{
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
		
		System.out.println(openhours);
		String closehours=((String[])reqc.getParameter("closehours"))[0];
		System.out.println(closehours);
		String hours = openhours+"~"+closehours;
		sb.setHours(hours);
		System.out.println(hours);
		
		
		//RegistJdbcをBeanに引数を使う。
		
		RegistJdbc.RegistStore(sb);
		
		
		
		resc.setTargetCommand("sqs");	//kanrisya.jspに転送
		
		return resc;
	
	}
	
}
