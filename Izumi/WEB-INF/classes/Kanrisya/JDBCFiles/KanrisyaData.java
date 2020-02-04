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

public class KanrisyaData{
	public static void main(String[] args){
		
		//LockUserBox a = new LockUserBox();	//LockUserBoxクラスを呼び出す。
		
		//OracleKanrisyaData("1");	//OracleKanrisyaData()メソッドを呼び出す。
		
	}
	public static List OracleKanrisyaData(String lname){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		//OracleConnectorでユーザー名とパスワードを指定する。
		//Connection cn = new OracleConnector("helshin","helshinbox").getCn();
		
		//表示したい列をSELECT文で指定する。
		//String q = "SELECT user_id,user_lastname,user_mail,user_phone FROM userTable  where user_lastname LIKE '"+lname+"%'";
		
		//List型のLockUserBoxの変数pppをArrayListのLockUserBoxに呼び出す。
		ArrayList<LockUserBox> l= new ArrayList<LockUserBox>();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","helshin","helshinbox");
			cn.setAutoCommit(false);
			String q = "SELECT user_id,user_lastname,user_mail,user_phone FROM userTable  where user_lastname LIKE '"+lname+"%'";
			st=cn.prepareStatement(q);
			rs=st.executeQuery();
			
			
			//Statementの変数でConnectionのcreateStatement()メソッドを呼び出す。
			//st = cn.createStatement();
			//rs = st.executeQuery(q);	//SELECT命令を実行。
			
			//ResultSetMetaDataの変数rsMetaでResultSetのgetMetaDataを呼び出す。
			//ResultSetMetaData rsMeta = rs.getMetaData();
			
			//列数をカウントする。
			//int columnCount = rsMeta.getColumnCount();
			
			while(rs.next()){
				LockUserBox lock = new LockUserBox();		//LockUserBoxクラスをインスタンス化する。
				
				lock.setId(rs.getString(1));				//Id列をセットする。
				lock.setLname(rs.getString(2));			//Lname列をセットする。
				lock.setMail(rs.getString(3));			//Mail列をセットする。
				lock.setTelphone(rs.getString(4));		//Telphone列をセットする。
				
				//System.out.println(rs.getString(1));	//Id列を表示する。
				//System.out.println(rs.getString(2));	//Lname列を表示する。
				//System.out.println(rs.getString(3));	//Mail列を表示する。
				//System.out.println(rs.getString(4));	//Telphone列を表示する。
				
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
	
	public static void OracleKanrisyaInsert(LockUserBox b){
		Connection cn = null;
		//PreparedStatement st = null;
		Statement st = null;
		
		String lname = b.getLname();
		String id = b.getId();
		String mail = b.getMail();
		String telphone = b.getTelphone();
		String lid = b.getLid();
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
			String qq = "SELECT MAX("+id+"+1) FROM lockTable";
			
			ResultSet rs= st.executeQuery(qq);
			rs.next();
			int qqa = rs.getInt(1);
			
			/*この文は1行にしないと動かない。*/
			String query = 
				"INSERT INTO lockTable ("+id+",lo_user_id) VALUES( '"+lid+" ','"+qqa+"')";
			
			st=cn.prepareStatement(query);	//プリコンパイルされ、オブジェクトに格納される。
			
			//st.executeUpdate();	//実行。
			
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
		//return "/ls";
	}
}

