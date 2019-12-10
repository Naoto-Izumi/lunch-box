package Kanrisya.Uriage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class UriageData{
	public static void main(String[] args){
		UriageBox u = new UriageBox();
		u.setYear("2019");
		u.setMonth("01");
		//u.setCount("10");
		
		/*UriageProduct up = new UriageProduct();
		up.setPpid("1");
		up.setPname("泉");
		up.setPprice("1000");
		up.setPstock("a");
		up.setPcalory("b");
		up.setPrdate("c");
		up.setPimage("d");
		up.setPprotein("e");
		up.setPt("f");
		up.setPlipid("g");
		up.setPvitamin("h");
		up.setPmugen("i");
		up.setPwheat("j");
		up.setPegg("k");
		up.setPmilk("l");
		up.setPrakkasei("m");
		up.setPbuck("n");
		up.setPshrimp("o");
		up.setPcrab("p");
		
		UriageOrder uo = new UriageOrder();
		uo.setOoid("111");
		uo.setOuid("1111");
		uo.setOtype("a");
		uo.setOcount("b");
		uo.setOinfo("c");
		uo.setOaddressid("d");
		uo.setOddate("e");
		uo.setOstore("f");*/
		
		OracleUriageData(u);
	}
	public static void OracleUriageData(UriageBox ub){
		Statement st = null;
		ResultSet rs = null;
		
		Connection cn = new OracleConnector("helshin","helshinbox").getCn();
		String d = ub.getYear()+"-"+ub.getMonth()+"-01";
		String q = "SELECT p.pro_name ,SUM(s.sp_count) as 売り上げ FROM  specificationTable s JOIN orderTable o ON s.sp_or_id = o.or_id JOIN productTable p ON s.sp_pro_id = p.pro_id WHERE trunc(o.or_date,'mm') = TO_DATE('"+d+"','YYYY-MM-DD') GROUP BY p.pro_name";
		
		try{
			st = cn.createStatement();
			rs = st.executeQuery(q);
			rs.next();
			
			/*String query =
				"INSERT INTO specificationTable(sp_or_id,sp_pro_id,sp_count) VALUES('"+ub.getOid()+"','"+ub.getPid()+"','"+ub.getCount()+"')";
			int i = st.executeUpdate(query);*/
			
			/*String query2 =
				"INSERT INTO orderTable(or_id,or_pro_id,or_user_id,or_count,or_type,or_address_id) VALUES('"+ub.getOoid()+"','"+ub.getOuid()+"','"+ub.getOtype()+"','"+ub.getOcount()+"','"+ub.getOinfo()+"','"+ub.getOaddressid()+"','"+ub.getOddate()+"','"+ub.getOstore()+"')";
			int i = st.executeUpdate(query2);
			
			String query3 =
				"INSERT INTO productTable(pro_id,pro_name,pro_price,pro_stock,pro_calorie,pro_release_date,pro_type,pro_image,pro_protein,pro_carbohydrate,pro_lipid,pro_vitamin,pro_inorganic,pro_wheat,pro_peanu) VALUES('"+ub.getOid()+"','"+ub.getPid()+"','"+ub.getCount()+"')";
			int i = st.executeUpdate(query3);*/
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
