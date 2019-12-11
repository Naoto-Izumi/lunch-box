package Kanrisya.Uriage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

import java.util.List;
import java.util.ArrayList;

public class UriageData{
	public static void main(String[] args){
		UriageBox u = new UriageBox();
		u.setYear("2019");
		u.setMonth("01");
		
		u.setName("とんかつ");
		u.setCount("1");
		
		OracleUriageData(u);
	}
	public static List OracleUriageData(UriageBox ub){
		Statement st = null;
		ResultSet rs = null;
		
		Connection cn = new OracleConnector("helshin","helshinbox").getCn();
		String d = ub.getYear()+"-"+ub.getMonth()+"-01";
		String q = "SELECT p.pro_name ,SUM(s.sp_count) as 売り上げ FROM  specificationTable s JOIN orderTable o ON s.sp_or_id = o.or_id JOIN productTable p ON s.sp_pro_id = p.pro_id WHERE trunc(o.or_date,'mm') = TO_DATE('"+d+"','YYYY-MM-DD') GROUP BY p.pro_name";
		
		//List
		List<UriageBox>ppp = new ArrayList<UriageBox>();
		
		try{
			st = cn.createStatement();
			rs = st.executeQuery(q);
			ResultSetMetaData rsMeta = rs.getMetaData();
			int columnCount = rsMeta.getColumnCount();
			
			while(rs.next()){
				UriageBox uu = new UriageBox();
				
				uu.setName(rs.getString(1));
				uu.setCount(rs.getString(2));
				
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				//list.add(uu
				ppp.add(uu);
			}
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		//return list
		return ppp;
	}
}
