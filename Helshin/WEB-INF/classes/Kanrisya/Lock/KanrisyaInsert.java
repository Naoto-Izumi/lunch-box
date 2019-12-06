package Kanrisya.Lock;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class KanrisyaInsert{
	public static void main(String[] args){
		
		Product a = new Product();	//Productクラスをインスタンス化する。
		a.setLname("b");			//Lname列の値をセットする。
		a.setId("111");				//Id列の値をセットする。
		a.setMail("mail");			//Mail列の値をセットする。
		a.setTelphone("tel");		//Telphone列の値をセットする。
		a.setLid("111");			//Lid列の値をセットする。
		
		OracleKanrisyaInsert(a);	//OracleKanrisyaInsert()メソッドを呼び出す。
		
	}
	public static void OracleKanrisyaInsert(Product b){
		PreparedStatement st = null;
		Statement sst = null;
		ResultSet rs = null;
		
		//OracleConnectorでユーザー名とパスワードを指定する。
		Connection cn = new OracleConnector("helshin","helshinbox").getCn();
		
		//表示したい列をSELECT文で指定する。
		String qq = "SELECT MAX(lo_id+1) FROM lockTable";

		try{
			//Statementの変数でConnectionのcreateStatement()メソッドを呼び出す。
			sst = cn.createStatement();	
			
			//ResultSetの変数でStatementのexecuteQuery()メソッドを呼び出す。
			rs = sst.executeQuery(qq);
			
			rs.next();
			int qqa = rs.getInt(1);
			
			/*この文は1行にしないと動かない。*/
			String query = 
				"INSERT INTO lockTable (lo_id,lo_user_id) VALUES( '"+b.getLid()+" ','"+qqa+"')";
			
			st=cn.prepareStatement(query);	//プリコンパイルされ、オブジェクトに格納される。
			
			st.executeUpdate();	//実行。
			
			cn.commit();	//コミットする。
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}


