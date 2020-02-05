package Kanrisya.CommandFiles;

import Kanrisya.JDBCFiles.UriageData;
import java.util.List;
import Kanrisya.ResponseContext;
import Kanrisya.RequestContext;
import java.util.Map;
import Kanrisya.AbstractCommand;
import Kanrisya.Beans.UriageBox;

//import java.util.ArrayList;

//import Kanrisya.Beans.PrintWriter;

public class UriageCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		UriageBox ub = new UriageBox();
		String year = ((String[])reqc.getParameter("nen"))[0];
		ub.setYear(year);
		
		String month = ((String[])reqc.getParameter("tuki"))[0];
		ub.setMonth(month);
		
		//String url = "WEB-INF/jsp/kanrisya/kanrisya.jsp";
		
		//String year = req.getParameter("nen");		//年
		//String month = req.getParameter("tuki");	//月
		System.out.println(year);					//年を表示
		System.out.println(month);					//月を表示
		
		//UriageBox u = new UriageBox();				//Beanファイルをインスタンス化
		
		//u.setYear(year);							//年をセット。
		//u.setMonth(month);							//月をセット。
		
		//UserDataにある戻り値を受け取る
		//List<UriageBox>ppp = UriageData.OracleUriageData(u);
		//req.setAttribute("kanrisya",ppp);
		
		//req.setAttribute("uriage",ppp);	//jspにあるitemsからセット
		//System.out.println(ppp);
		//RequestDispatcher r = req.getRequestDispatcher(url);	//url-patternにあるサーブレットパス
		//r.forward(req,res);
		
		List uriage = UriageData.OracleUriageData(ub);
		
		String url = "WEB-INF/jsp/kanrisya/store.jsp";
		resc.setResult(url);
		
		resc.setTarget("kanrisya/kanrisya");
		return resc;		

	}
}
