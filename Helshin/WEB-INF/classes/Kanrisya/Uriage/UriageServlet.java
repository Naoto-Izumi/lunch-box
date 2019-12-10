package Kanrisya.Uriage;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

public class UriageServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		
		//SpecificationTable
		String year = req.getParameter("nen");
		String month = req.getParameter("tuki");
		System.out.println(year);
		System.out.println(month);
		//String count = req.getParameter("count");
		
		//ProductTable
		/*String ppid = req.getParameter("ppid");
		String pname = req.getParameter("pname");
		String pprice = req.getParameter("pprice");
		String pstock = req.getParameter("pstock");
		String pcalory = req.getParameter("pcalory");
		String prdate = req.getParameter("prdate");
		String pimage = req.getParameter("pimage");
		String pprotein = req.getParameter("pprotein");
		String pt = req.getParameter("pt");
		String plipid = req.getParameter("plipid");
		String pvitamin = req.getParameter("pvitamin");
		String pmugen = req.getParameter("pmugen");
		String pwheat = req.getParameter("pwheat");
		String pegg = req.getParameter("pegg");
		String pmilk = req.getParameter("pmilk");
		String prakkasei = req.getParameter("prakkasei");
		String pbuck = req.getParameter("pbuck");
		String pshrimp = req.getParameter("pshrimp");
		String pcrab = req.getParameter("pcrab");*/
		
		//OrderTable
		/*String ooid = req.getParameter("ooid");
		String ouid = req.getParameter("ouid");
		String otype = req.getParameter("otype");
		String ocount = req.getParameter("ocount");
		String oinfo = req.getParameter("oinfo");
		String oaddressid = req.getParameter("oaddressid");
		String oddate = req.getParameter("oddate");
		String odate = req.getParameter("odate");
		String ostore = req.getParameter("ostore");*/
		
		//UriageProduct up = new UriageProduct();
		UriageBox u = new UriageBox();
		//UriageOrder uo = new UriageOrder();
		
		//SpecificationTable
		u.setYear(year);
		u.setMonth(month);
		//u.setCount(count);
		
		//ProductTable
		/*up.setPpid(ppid);
		up.setPname(pname);
		up.setPprice(pprice);
		up.setPstock(pstock);
		up.setPcalory(pcalory);
		up.setPrdate(prdate);
		up.setPimage(pimage);
		up.setPprotein(pprotein);
		up.setPt(pt);
		up.setPlipid(plipid);
		up.setPvitamin(pvitamin);
		up.setPmugen(pmugen);
		up.setPwheat(pwheat);
		up.setPegg(pegg);
		up.setPmilk(pmilk);
		up.setPrakkasei(prakkasei);
		up.setPbuck(pbuck);
		up.setPshrimp(pshrimp);
		up.setPcrab(pcrab);*/
		
		//OrderTable
		/*uo.setOoid(ooid);
		uo.setOuid(ouid);
		uo.setOtype(otype);
		uo.setOcount(ocount);
		uo.setOinfo(oinfo);
		uo.setOaddressid(oaddressid);
		uo.setOddate(oddate);
		uo.setOstore(ostore);*/
		
		req.setAttribute("uriagebox",u);
		//req.setAttribute("uriageproduct",up);
		//req.setAttribute("uriageorder",uo);
		
		UriageData.OracleUriageData(u);
		//UriageData.OracleUriageData(up);
		//UriageData.OracleUriageData(uo);
		
		RequestDispatcher r = req.getRequestDispatcher("/helshin2");
		r.forward(req,res);

	}
}
