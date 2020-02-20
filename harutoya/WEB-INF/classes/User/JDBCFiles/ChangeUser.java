package User.JDBCFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Map;

public class ChangeUser{

/*------------------------------ユーザ情報変更-------------------------------*/
	public static String updateUser(String id,String seik,String meik,String seih,String meih,String sex,String mail,String pass,String phone){
		
		Connection cn=null;
		Statement st=null;
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "helshin","helshinbox");
			
			cn.setAutoCommit(false);
			
			System.out.println("接続完了");

			st=cn.createStatement();

			String sql="update userTable set user_lastname = '"+seik+"',user_firstname = '"+meik+"',user_lastname_hira ='"+seih+"',user_firstname_hira = '"+meih+"',user_sex = '"+sex+"',user_mail = '"+mail+"',user_pass = '"+pass+"',user_phone = '"+phone+"' where user_id ='"+id+"'";

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