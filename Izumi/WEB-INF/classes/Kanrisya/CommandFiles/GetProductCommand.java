package Kanrisya.CommandFiles;

import java.util.List;
import Kanrisya.ResponseContext;
import Kanrisya.RequestContext;
import java.util.Map;
import Kanrisya.AbstractCommand;

import Kanrisya.JDBCFiles.ProductQuery;
import Kanrisya.Beans.ProductBean;
import Kanrisya.JDBCFiles.RegistJdbc;
import Kanrisya.JDBCFiles.ChangeJdbc;

public class GetProductCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		//RequestContextクラスの変数reqcでRequestContext()メソッドを取得している。
		RequestContext reqc = getRequestContext();
		
		ProductBean pb = new ProductBean();
		String name=((String[])reqc.getParameter("pname"))[0];
		pb.setName(name);
		
		String price=((String[])reqc.getParameter("price"))[0];
		pb.setPrice(Integer.parseInt(price));
		
		String cal=((String[])reqc.getParameter("cal"))[0];
		pb.setCalorie(Integer.parseInt(cal));
		
		String cate=((String[])reqc.getParameter("cate"))[0];
		pb.setType(cate);
		
		String image=((String[])reqc.getParameter("image"))[0];
		pb.setImage(image);
		
		String pro=((String[])reqc.getParameter("pro"))[0];
		pb.setPro(pro);
		
		String carbo=((String[])reqc.getParameter("carbo"))[0];
		pb.setCarbo(carbo);
		
		String lip=((String[])reqc.getParameter("lip"))[0];
		pb.setLip(lip);
		
		String vita=((String[])reqc.getParameter("vita"))[0];
		pb.setVita(vita);
		
		String ino=((String[])reqc.getParameter("ino"))[0];
		pb.setIno(ino);
		
		String wheat=((String[])reqc.getParameter("wheat"))[0];
		pb.setWheat(wheat);
		
		String egg=((String[])reqc.getParameter("egg"))[0];
		pb.setEgg(egg);
		
		String milk=((String[])reqc.getParameter("milk"))[0];
		pb.setMilk(milk);
		
		String peanut=((String[])reqc.getParameter("peanut"))[0];
		pb.setPeanut(peanut);
		
		String buck=((String[])reqc.getParameter("buck"))[0];
		pb.setBuck(buck);
		
		String shrimp=((String[])reqc.getParameter("shrimp"))[0];
		pb.setShrimp(shrimp);
		
		String kani=((String[])reqc.getParameter("kani"))[0];
		pb.setKani(kani);
		
		//RegistJdbcをBeanに引数を使う。
		
		String menuusers = RegistJdbc.RegistProduct(pb);
		
		//ResponseContextの変数でList型の変数をセットする。
		resc.setResult(menuusers);
		
		resc.setTargetCommand("pqs");	//kanrisya.jspに転送
		
		return resc;
	
	}
	
}
