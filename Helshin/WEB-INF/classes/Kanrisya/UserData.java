package Kanrisya;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
//import User.UserBox;

public class KanrisyaData{
	public static void main(String[] args){
		//ResultSet rs = null;
		
		Product a = new Product();
		//a.setLname("a");
		//a.setFname("b");
		//a.setLhname("c");
		//a.setFhname("d");
		a.setTelphone("e");
		a.setMail("f");
		//a.setPass("g");
		//a.setAddress("h");
		//a.setSex("男");
		//a.setBirth("j");
		
		OracleKanrisyaData(a);
		
	}
	public static void OracleKanrisyaData(Product b){
		Statement st = null;
		ResultSet rs = null;
		
		Connection cn = new OracleConnector("helshin","helshinbox").getCn();
		//System.out.println(b.getSex());
		//int q;
		//int qq;
		String q = "SELECT MAX(user_id+1) FROM userTable";
		//int q = Integer.parseInt(aq);
		//System.out.println(q);
		
		//String qq = "SELECT MAX(address_id+1) FROM addressTable";
		//int qq = Integer.parseInt(qqq);
		//System.out.println(qq);
		
		
		
		
		try{
			st = cn.createStatement();
			//int i = st.executeUpdate(query);
			rs = st.executeQuery(q);
			
			ResultSetMetaData rsMeta = rs.getMetaData();
			
			int columnCount = rsMeta.getColumnCount();
			
			while(rs.next()){
				for(int i = 1; i<=columnCount; i++){
					String data = rs.getString(i);
					
					System.out.println(data);
				}
			}
			
			/*rs.next();
			//cn.commit();
			
			//String q = "SELECT MAX(user_id+1) FROM userTable";
			//String qq = "SELECT MAX(address_id+1) FROM userTable";
			
			int aq = rs.getInt(1);
			rs = st.executeQuery(qq);
			rs.next();
			int qqq = rs.getInt(1);*/
			
			
			/*String query = 
		"INSERT INTO USERTABLE (user_id,user_lastname,user_firstname,user_lastname_hira,user_firstname_hira,user_phone,user_mail,user_pass,user_address_id,user_sex,user_birthday) VALUES( '"+aq+" ','"+b.getLname()+"','"+b.getFname()+"','"+b.getLhname()+"','"+b.getFhname()+"','"+b.getTelphone()+"','"+b.getMail()+"','"+b.getPass()+"',1,'"+b.getSex()+"','"+b.getBirth()+"')";
		int i = st.executeUpdate(query);*/
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}

