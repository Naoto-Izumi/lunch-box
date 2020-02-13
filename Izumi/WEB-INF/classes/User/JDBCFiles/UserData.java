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
	public static void main(String[] args){
		
		UserBox a = new UserBox();	//Beanクラスのインスタンス化
		a.setLname("a");	//名前(上の名前)
		a.setFname("b");	//名前(下の名前)
		a.setLhname("c");	//名前(上の名前(ふりがな))
		a.setFhname("d");	//名前(下の名前(ふりがな))
		a.setTelphone("e");	//電話番号
		a.setMail("f");		//メールアドレス
		a.setPass("g");		//パスワード
		a.setAddress("h");	//住所
		a.setSex("男");		//性別
		a.setBirth("j");	//誕生日
		
		OracleUserData(a);	//OracleUserData()メソッドを転送
		
	}
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

