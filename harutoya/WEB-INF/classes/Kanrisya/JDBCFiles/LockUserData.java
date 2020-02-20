package Kanrisya.JDBCFiles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.List;
import java.util.ArrayList;

import Kanrisya.Beans.LockUserBox;

public class LockUserData{
	public static List OracleLockUserData(String lname){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		//List型のLockUserBoxの変数pppをArrayListのLockUserBoxに呼び出す。
		ArrayList<LockUserBox> l= new ArrayList<LockUserBox>();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","helshin","helshinbox");
			cn.setAutoCommit(false);
			String q = "SELECT user_id,user_lastname,user_mail,user_phone,user_lock FROM userTable  where user_lastname LIKE '"+lname+"%'";
			
			st=cn.prepareStatement(q);
			rs=st.executeQuery();
			
			while(rs.next()){
				LockUserBox lock = new LockUserBox();		//LockUserBoxクラスをインスタンス化する。
				
				lock.setId(rs.getString(1));				//Id列をセットする。
				lock.setLname(rs.getString(2));			//Lname列をセットする。
				lock.setMail(rs.getString(3));			//Mail列をセットする。
				lock.setTelphone(rs.getString(4));		//Telphone列をセットする。
				
				if(1==rs.getInt(5)){
					 lock.setLocks("checked");
				}
				else{
					System.out.println(lock);
				}
				
				l.add(lock);	//LockUserBoxの変数で各列を追加する。
			}
			cn.commit();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			try{
				cn.rollback();
			}catch(SQLException e2){
				e2.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(st!=null){
					st.close();
				}
			}catch(SQLException e2){
				e2.printStackTrace();
			}finally{
				try{
					if(cn!=null){
						cn.close();
					}
				}catch(SQLException e3){
					e3.printStackTrace();
				}
			}
		}
		return l;
		
	}
}

