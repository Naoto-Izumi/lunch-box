package User.Regist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import User.Regist.Beans.UserBox;

public class TableReferer{
	
	Connection cn = null;
	Statement st = null;
	ResultSet rs = null;
	
	public TableReferer(Connection cn,String TableName){
		this.cn = cn;
		
		/*インサート文*/
		String query = "INSERT INTO" +TableName;
		
		try{
			st = cn.createStatement();		//Connectionの変数のcreateStatement()メソッドを呼び出す。
			rs = st.executeQuery(query);	//Statementの変数のexecuteQuery()メソッドを呼び出す。
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public String getColumnName(){
		String columnname="";
		try{
			//ResultSetMetaDataの変数をResulSetのgetMetaData()メソッドを呼び出す。
			ResultSetMetaData rsmeta = rs.getMetaData();
			
			//ResultSetMetaDataのgetColumnCount()メソッドを呼び出す。
			int columnCount = rsmeta.getColumnCount();
			
			/*列数をカウント*/
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
