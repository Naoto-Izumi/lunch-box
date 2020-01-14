package Kanrisya.Store.JDBCFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Map;

/*-----------------------商品登録---------------------*/
public class RegistJdbc{	
	public static void main(String[] args){}	//テスト用メソッド
	
/*-----------------------店舗登録--------------------*/
	public static String RegistStore(Map m){
		
		Connection cn=null;
		Statement st=null;

		String name=((String[])m.get("sname"))[0];
		String address=((String[])m.get("saddress"))[0];
		String number=((String[])m.get("snumber"))[0];
		String openhours=((String[])m.get("openhours"))[0];
		String closehours=((String[])m.get("closehours"))[0];
		String hours = openhours+"~"+closehours;


		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "helshin","helshinbox");
			
			cn.setAutoCommit(false);
			
			System.out.println("接続完了");
			
			st=cn.createStatement();
			//シーケンスで主キーを制御
			String sql="insert into storeTable values(sq_st_id.Nextval,'"+name+"','"+address+"','"+number+"','"+hours+"')";
						
			int count=st.executeUpdate(sql);
			
			System.out.println(count+"件処理完了");
			
			cn.commit();
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
		return "/sqs";
	}
}