package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


class Test{
	public static void main(String[] args){
		//System.out.println("/"+args[0]+"/");
		//System.out.println("/"+args[1]+"/");
		LoginJdbc.login("aaa@gmail.com","aiudao");
	}
}

public class LoginJdbc{
	
	
	public static String login(String mail,String pass){
		
		Connection cn=null;
		Statement st=null;
		String id = null;
		
		try{
			//System.out.println("s");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("t");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "helshin","helshinbox");
			//System.out.println("a");
			cn.setAutoCommit(false);
			//System.out.println("r");
			System.out.println("接続完了");
			
			//select文
			String sql="SELECT user_id FROM userTable WHERE user_mail = '"+mail+"' AND user_pass = '"+pass+"'";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);

			//System.out.println("t");
			//カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
				id=rs.getString (1);	//1列目のデータを取得
			
				System.out.println("id");
				System.out.println(id);
			}

			
			//Oracleから切断する
			cn.close();
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
				System.out.println("リソースの開放");
				
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return id;
	}
}