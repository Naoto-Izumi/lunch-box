package Kanrisya.CommandFiles;

import Kanrisya.ResponseContext;
import Kanrisya.JDBCFiles.ProductQuery;
import Kanrisya.JDBCFiles.RegistJdbc;
import Kanrisya.RequestContext;
import Kanrisya.Beans.ProductBean;
import Kanrisya.AbstractCommand;


public class AddProductCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		//RequestContextクラスをインスタンス化する。
		RequestContext reqc = getRequestContext();
		
		//String配列の変数aoをRequestContextの変数でパラメータを呼び出す。
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
		
		//Daoパターンのクラスの変数でそれぞれのgetメソッドを呼び出す。
		//AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		//MenuUsersDao dao = factory.getMenuUsersDao();
		
		String menuusers = RegistJdbc.RegistProduct(pb);
		
		//MenuUsersDaoの変数でaddMenuUser()メソッドを呼び出す。
		//dao.addProductBean(p);
		
		resc.setTarget("kanrisya/product");	//kanrisya.jspに転送
		
		return resc;
		
	}
}

	
		