package User.JDBCFiles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

import java.util.ArrayList;
import java.util.List;

import User.Beans.UserBox;

public class UserData{
	public static List OracleUserData(UserBox b){
		Statement st = null;
		ResultSet rs = null;
		Connection cn = null;
		
		ArrayList<UserBox> ub = new ArrayList<UserBox>();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","helshin","helshinbox");//パスワードを指定
			System.out.println(b.getSex());	//性別を実行
			cn.setAutoCommit(false);
			
			st=cn.createStatement();
		
			/*指定したいSELECT文を表示*/
			//String q = "SELECT MAX(user_id+1) FROM userTable";	
			//String qq = "SELECT MAX(address_id+1) FROM addressTable";
			
			/*この文は1行にしないと動かない。*/
			String query = 
				"INSERT INTO USERTABLE (user_id,user_lastname,user_firstname,user_lastname_hira,user_firstname_hira,user_sex,user_mail,user_phone,user_pass,user_birthyear,user_admin,user_lock) VALUES( sq_user_id.NEXTVAL,'"+b.getLname()+"','"+b.getFname()+"','"+b.getLhname()+"','"+b.getFhname()+"','"+b.getTelphone()+"','"+b.getMail()+"','"+b.getPass()+"',1,'"+b.getSex()+"','"+b.getBirth()+"')";
			int i = st.executeUpdate(query);
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
		return ub;
	}
}

