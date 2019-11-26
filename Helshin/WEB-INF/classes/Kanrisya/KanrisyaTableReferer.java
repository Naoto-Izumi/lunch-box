package Kanrisya;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class KanrisyaTableReferer{
	
	Connection cn = null;
	Statement st = null;
	ResultSet rs = null;
	
	public KanrisyaTableReferer(Connection cn,String TableName){
		this.cn = cn;
		String query = "SELECT user_id,user_lastname,user_mail,user_phone FROM userTable WHERE user_lastname" +TableName;
		try{
			st = cn.createStatement();
			rs = st.executeQuery(query);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public String getColumnName(){
		String columnname="";
		try{
			ResultSetMetaData rsmeta = rs.getMetaData();
			int columnCount = rsmeta.getColumnCount();
			for(int i = 1; i<=columnCount; i++){
				columnname += rsmeta.getColumnName(i)+" ";
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	return columnname;
	}
	public ResultSet getTableContentsA(){
		return rs;
	}
}
