package Kanrisya.Lock.JDBCFiles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

import java.util.List;
import java.util.ArrayList;

import Kanrisya.Lock.Beans.LockUserBox;

public class KanrisyaData{
	public static void main(String[] args){
		
		LockUserBox a = new LockUserBox();	//LockUserBoxクラスを呼び出す。
		
		OracleKanrisyaData("1");	//OracleKanrisyaData()メソッドを呼び出す。
		
	}
	public static List OracleKanrisyaData(String lname){
		Statement st = null;
		ResultSet rs = null;
		
		//OracleConnectorでユーザー名とパスワードを指定する。
		Connection cn = new OracleConnector("helshin","helshinbox").getCn();
		
		//表示したい列をSELECT文で指定する。
		String q = "SELECT user_id,user_lastname,user_mail,user_phone FROM userTable  where user_lastname LIKE '"+lname+"%'";
		
		//List型のLockUserBoxの変数pppをArrayListのLockUserBoxに呼び出す。
		List<LockUserBox> ppp= new ArrayList<LockUserBox>();
		
		try{
			
			//Statementの変数でConnectionのcreateStatement()メソッドを呼び出す。
			st = cn.createStatement();
			rs = st.executeQuery(q);	//SELECT命令を実行。
			
			//ResultSetMetaDataの変数rsMetaでResultSetのgetMetaDataを呼び出す。
			ResultSetMetaData rsMeta = rs.getMetaData();
			
			//列数をカウントする。
			int columnCount = rsMeta.getColumnCount();
			
			while(rs.next()){
				LockUserBox pr = new LockUserBox();		//LockUserBoxクラスをインスタンス化する。
				
				pr.setId(rs.getString(1));				//Id列をセットする。
				pr.setLname(rs.getString(2));			//Lname列をセットする。
				pr.setMail(rs.getString(3));			//Mail列をセットする。
				pr.setTelphone(rs.getString(4));		//Telphone列をセットする。
				
				System.out.println(rs.getString(1));	//Id列を表示する。
				System.out.println(rs.getString(2));	//Lname列を表示する。
				System.out.println(rs.getString(3));	//Mail列を表示する。
				System.out.println(rs.getString(4));	//Telphone列を表示する。
				
				ppp.add(pr);	//LockUserBoxの変数で各列を追加する。
			}
		}catch(SQLException e){
			
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

