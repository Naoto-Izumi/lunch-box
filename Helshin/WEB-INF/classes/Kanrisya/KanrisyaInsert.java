package Kanrisya;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import Kanrisya.Product;
import java.sql.PreparedStatement;

public class KanrisyaInsert{
	public static void main(String[] args){
		
		Product a = new Product();
		a.setLname("b");
		//a.setFname("b");
		//a.setLhname("c");
		//a.setFhname("d");
		//a.setTelphone("e");
		//a.setMail("f");
		//a.setPass("g");
		//a.setAddress("h");
		//a.setSex("男");
		//a.setBirth("j");
		
		a.setId("111");
		
		a.setMail("mail");
		
		a.setTelphone("tel");
		
		a.setLid("111");
		
		OracleKanrisyaInsert(a);
		
	}
	public static void OracleKanrisyaInsert(Product b){
		PreparedStatement st = null;
		Statement sst = null;
		ResultSet rs = null;
		
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection cn = new OracleConnector("helshin","helshinbox").getCn();
		//System.out.println(b.getSex());
		//String q = "SELECT MAX(lo_user_id+1) FROM lockTable";
		String qq = "SELECT MAX(lo_id+1) FROM lockTable";

		try{
			sst = cn.createStatement();
			//rs = st.executeQuery(q);
			
			
			//rs.next();
			//int aq = rs.getInt(1);
			rs = sst.executeQuery(qq);
			rs.next();
			int qqa = rs.getInt(1);
			
			/*この文は1行にしないと動かない。*/
			String query = 
				"INSERT INTO lockTable (lo_id,lo_user_id) VALUES( '"+b.getLid()+" ','"+qqa+"')";
			//int i = st.executeUpdate(query);
			
			st=cn.prepareStatement(query);
			
			/*st.setString(1,b.getId());
			st.setString(2,b.getLname());
			st.setString(3,b.getMail());
			st.setString(4,b.getTelphone());
			st.setString(5,b.getLid());*/
			
			st.executeUpdate();
			
			cn.commit();
			//何もしてない
			//１をもらったからそれをインサート
			String a =
			"DELETE FROM userTable(user_id) Values('"+query+"')";
			
			st=cn.prepareStatement(a);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}


