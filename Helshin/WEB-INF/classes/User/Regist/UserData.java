package User.Regist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

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
	public static void OracleUserData(UserBox b){
		Statement st = null;
		ResultSet rs = null;
		
		Connection cn = new OracleConnector("helshin","helshinbox").getCn();	//パスワードを指定
		System.out.println(b.getSex());	//性別を実行
		
		/*指定したいSELECT文を表示*/
		String q = "SELECT MAX(user_id+1) FROM userTable";	
		String qq = "SELECT MAX(address_id+1) FROM addressTable";

		try{
			
			st = cn.createStatement();
			rs = st.executeQuery(q);
			
			
			rs.next();
			int aq = rs.getInt(1);
			rs = st.executeQuery(qq);
			rs.next();
			int qqq = rs.getInt(1);
			
			/*この文は1行にしないと動かない。*/
			String query = 
				"INSERT INTO USERTABLE (user_id,user_lastname,user_firstname,user_lastname_hira,user_firstname_hira,user_phone,user_mail,user_pass,user_address_id,user_sex,user_birthday) VALUES( '"+aq+" ','"+b.getLname()+"','"+b.getFname()+"','"+b.getLhname()+"','"+b.getFhname()+"','"+b.getTelphone()+"','"+b.getMail()+"','"+b.getPass()+"',1,'"+b.getSex()+"','"+b.getBirth()+"')";
			int i = st.executeUpdate(query);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}

