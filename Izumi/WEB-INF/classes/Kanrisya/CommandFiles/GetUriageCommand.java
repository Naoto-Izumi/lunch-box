package Kanrisya.CommandFiles;

import java.util.List;
import Kanrisya.ResponseContext;
import Kanrisya.RequestContext;
import Kanrisya.AbstractCommand;
import java.util.Map;

import Kanrisya.JDBCFiles.UriageData;
import Kanrisya.JDBCFiles.KanrisyaInsert;
import Kanrisya.Beans.UriageBox;

public class GetUriageCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		//RequestContextクラスの変数reqcでRequestContext()メソッドを取得している。
		RequestContext reqc = getRequestContext();
		
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
