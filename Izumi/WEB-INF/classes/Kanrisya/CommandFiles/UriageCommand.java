package Kanrisya.CommandFiles;

import Kanrisya.JDBCFiles.UriageData;
import java.util.List;
import Kanrisya.ResponseContext;
import Kanrisya.RequestContext;
import java.util.Map;
import Kanrisya.AbstractCommand;
import Kanrisya.Beans.UriageBox;

public class UriageCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		UriageBox ub = new UriageBox();
		String year = ((String[])reqc.getParameter("nen"))[0];
		ub.setYear(year);
		
		String month = ((String[])reqc.getParameter("tuki"))[0];
		ub.setMonth(month);
		
		System.out.println(year);					//年を表示
		System.out.println(month);					//月を表示
		
		List uriage = UriageData.OracleUriageData(ub);
		
		resc.setResult(uriage);
		resc.setResultName("uriage");
		
		resc.setTarget("kanrisya/user");
		resc.setTargetCommand("ks");
		return resc;		

	}
}
