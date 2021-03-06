package JDBCFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Map;

public class ChangeJdbc{


/*------------------------------在庫変更-------------------------------*/
	public static String ChangeProduct(Map m){
		
		Connection cn=null;
		Statement st=null;
	String id=((String[])m.get("id"))[0];
	String stock=((String[])m.get("stock"))[0];
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "info","pro");
			
			cn.setAutoCommit(false);
			
			System.out.println("接続完了");

			st=cn.createStatement();

			String sql="update productTable set pro_stock = '"+stock+"' where pro_id ='"+id+"'";

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
		return "/pss";
	}
}