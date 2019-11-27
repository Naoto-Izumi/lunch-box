package Kanrisya;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class KanrisyaData{
	public static void main(String[] args){
		
		Product a = new Product();
		
		OracleKanrisyaData("1");
		
	}
	public static void OracleKanrisyaData(String lname){
		Statement st = null;
		ResultSet rs = null;
		Connection cn = new OracleConnector("helshin","helshinbox").getCn();
		String q = "SELECT user_id,user_lastname,user_mail,user_phone FROM userTable where user_lastname = "+lname;
		
		try{
			st = cn.createStatement();
			rs = st.executeQuery(q);
			
			ResultSetMetaData rsMeta = rs.getMetaData();
			
			int columnCount = rsMeta.getColumnCount();
			
			while(rs.next()){
				for(int i = 1; i<=columnCount; i++){
					String data = rs.getString(i);
					
					System.out.println(data);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}

