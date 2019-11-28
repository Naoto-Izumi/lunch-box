package Kanrisya;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

import java.util.List;
import java.util.ArrayList;

public class KanrisyaData{
	public static void main(String[] args){
		
		Product a = new Product();
		
		OracleKanrisyaData("1");
		
	}
	public static List OracleKanrisyaData(String lname){
		Statement st = null;
		ResultSet rs = null;
		Connection cn = new OracleConnector("helshin","helshinbox").getCn();
		String q = "SELECT user_id,user_lastname,user_mail,user_phone FROM userTable u JOIN lockTable l ON u.user_id = l.lo_user_id where u.user_lastname LIKE '"+lname+"%'";
		//String aq = A.InportKanrisyaData(?);
		
		List<Product> ppp= new ArrayList<Product>();
		
		try{
			st = cn.createStatement();
			rs = st.executeQuery(q);
			
			ResultSetMetaData rsMeta = rs.getMetaData();
			
			int columnCount = rsMeta.getColumnCount();
			
			
			
			while(rs.next()){
				Product pr = new Product();
				
				pr.setLname(rs.getString(2));
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				pr.setTelphone(rs.getString(4));	
				pr.setMail(rs.getString(3));		
				pr.setId(rs.getString(1));
				pr.setLid(rs.getString(5));
					
				ppp.add(pr);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(st != null){
				try{
					st.close();
				}catch(SQLException e){	}
			}if(cn != null){
				try{
					cn.close();
				}catch(SQLException e){}
			}
		}
		return ppp;
		
	}
}

