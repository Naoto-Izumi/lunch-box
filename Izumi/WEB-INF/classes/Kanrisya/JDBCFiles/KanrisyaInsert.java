package Kanrisya.JDBCFiles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Kanrisya.Beans.LockUserBox;

public class KanrisyaInsert{
	/*public static void main(String[] args){
		
		LockUserBox a = new LockUserBox();	//LockUserBoxクラスをインスタンス化する。
		a.setLname("b");			//Lname列の値をセットする。
		a.setId("111");				//Id列の値をセットする。
		a.setMail("mail");			//Mail列の値をセットする。
		a.setTelphone("tel");		//Telphone列の値をセットする。
		a.setLid("111");			//Lid列の値をセットする。
		
		OracleKanrisyaInsert(a);	//OracleKanrisyaInsert()メソッドを呼び出す。
		
	}*/
	public static void OracleKanrisyaInsert(LockUserBox b){
		Connection cn = null;
		//PreparedStatement st = null;
		Statement st = null;
		
		
		//ResultSet rs = null;
		
		//OracleConnectorでユーザー名とパスワードを指定する。
		//Connection cn = new OracleConnector("helshin","helshinbox").getCn();
		
		//表示したい列をSELECT文で指定する。
		//String qq = "SELECT MAX(lo_id+1) FROM lockTable";

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "helshin","helshinbox");
			
			cn.setAutoCommit(false);
			
			//Statementの変数でConnectionのcreateStatement()メソッドを呼び出す。
			st = cn.createStatement();	
			
			//ResultSetの変数でStatementのexecuteQuery()メソッドを呼び出す。
			//rs = sst.executeQuery(qq);
			
			
			
			/*この文は1行にしないと動かない。*/
			String update = 
			"UPDATE userTable SET user_lock = "+b.getLocks()+" WHERE user_id = "+b.getId();
			
			//st=cn.createStatement();	//プリコンパイルされ、オブジェクトに格納される。
			
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
		//return 	"/ls";
	}
}


