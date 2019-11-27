//package User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import User.UserBox;

public class UserData{
	public static void main(String[] args){
		
		UserBox a = new UserBox();
		a.setLname("a");
		a.setFname("b");
		a.setLhname("c");
		a.setFhname("d");
		a.setTelphone("e");
		a.setMail("f");
		a.setPass("g");
		a.setAddress("h");
		a.setSex("男");
		a.setBirth("j");
		
		OracleUserData(a);
		
	}
	public static void OracleUserData(UserBox b){
		Statement st = null;
		ResultSet rs = null;
		
		Connection cn = new OracleConnector("helshin","helshinbox").getCn();
		System.out.println(b.getSex());
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

