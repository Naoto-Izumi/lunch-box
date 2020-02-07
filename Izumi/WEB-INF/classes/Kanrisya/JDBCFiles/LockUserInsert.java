package Kanrisya.JDBCFiles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Kanrisya.Beans.LockUserBox;

public class LockUserInsert{
	public static void OracleLockUserInsert(LockUserBox b){
		Connection cn = null;
		Statement st = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "helshin","helshinbox");
			
			cn.setAutoCommit(false);
			
			//Statementの変数でConnectionのcreateStatement()メソッドを呼び出す。
			st = cn.createStatement();	
			
			/*この文は1行にしないと動かない。*/
			String update = 
			"UPDATE userTable SET user_lock = "+b.getLocks()+" WHERE user_id = "+b.getId();
			
			System.out.println(update);
			st.executeUpdate(update);
			
			cn.commit();	//コミットする。
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
			if(cn!=null && st!=null){
				try{
					cn.rollback();
					System.out.println("ロールバックしました");
				}catch(SQLException ex){
					ex.printStackTrace();
				}
			}
		}finally{
			try{
				if(st!=null){
					st.close();
					System.out.println("ステートメントを解放");
				}
				if(cn!=null){
					cn.close();
					System.out.println("コネクションを解放");
				}
				System.out.println("リソースの開放完了");
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
