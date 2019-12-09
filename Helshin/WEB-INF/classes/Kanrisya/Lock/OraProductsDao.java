package Kanrisya.Lock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSetMetaData;

import java.sql.Statement;

public class OraProductsDao implements ProductsDao{
	/*add側*/
	public void addProduct(Product p){
		Connection cn = null;
		
		PreparedStatement st = null;
		
		try{
			//クラスをロードする。
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//パスワードを指定する。
			cn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl","helshin","helshinbox");
			
			//自動コミットをoffにする。
			cn.setAutoCommit(false);
			
			//Select文を実行。
			String sql2 = "SELECT MAX(lo_id+1) FROM lockTable";
			
			//Statementの変数でConnectionのcreateStatement()メソッドを呼び出す。
			Statement st2 = cn.createStatement();
			
			//ResultSetの変数でexecuteQuery()メソッドを呼び出す。
			ResultSet rs2 = st2.executeQuery(sql2);
			
			rs2.next();
			
			int newid = rs2.getInt(1);	//値をセットする・
			
			//Insert文を実行。
			String sql = "insert into lockTable(lo_id,lo_user_id)"
			+"values(?,?)";
			
			st = cn.prepareStatement(sql);	//プリコンパイルされたSQL文を表す。
			
			/*値をセットする*/
			st.setInt(1,newid);
			st.setInt(2,Integer.parseInt(p.getId()));
			
			st.executeUpdate();		//実行する。
			
			cn.commit();	//コミットする。
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
						
		}finally{
			
		}
	}
	
	/*view側*/
	public List getProduct(String pid){
		Statement st = null;
		ResultSet rs = null;
		
		//OracleConnectorでユーザー名とパスワードを指定する。
		Connection cn = new OracleConnector("helshin","helshinbox").getCn();
		
		//表示したい列をSELECT文で指定する。
		String q = "SELECT user_id,user_lastname,user_mail,user_phone FROM userTable  where user_lastname LIKE '"+pid+"%'";
		
		//List型のProductの変数pppをArrayListのProductに呼び出す。
		List<Product> ppp= new ArrayList<Product>();
		
		try{
			
			//Statementの変数でConnectionのcreateStatement()メソッドを呼び出す。
			st = cn.createStatement();
			rs = st.executeQuery(q);	//SELECT命令を実行。
			
			//ResultSetMetaDataの変数rsMetaでResultSetのgetMetaDataを呼び出す。
			ResultSetMetaData rsMeta = rs.getMetaData();
			
			//列数をカウントする。
			int columnCount = rsMeta.getColumnCount();
			
			while(rs.next()){
				Product pr = new Product();		//Productクラスをインスタンス化する。
				
				pr.setId(rs.getString(1));				//Id列をセットする。
				pr.setLname(rs.getString(2));			//Lname列をセットする。
				pr.setMail(rs.getString(3));			//Mail列をセットする。
				pr.setTelphone(rs.getString(4));		//Telphone列をセットする。
				System.out.println(rs.getString(1));	//Id列を表示する。
				System.out.println(rs.getString(2));	//Lname列を表示する。
				System.out.println(rs.getString(3));	//Mail列を表示する。
				System.out.println(rs.getString(4));	//Telphone列を表示する。
								
				ppp.add(pr);		//Productの変数で値を追加する。
			}
		}
		catch(SQLException e){
			
		}finally{
			if(st != null){
				try{
					st.close();
				}catch(SQLException e){	}
			}if(cn != null){
				try{
					cn.close();
				}catch(SQLException e){}
			}
		}
		return ppp;
		
	}
	public List getAllProducts(){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList products = new ArrayList();
		try{
			//クラスをロードする。
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//パスワードを指定する。
			cn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl","helshin","helshinbox");
			
			cn.setAutoCommit(false);	//自動コミットをoffにする。
			
			String sql = "select lo_id,lo_user_id FROM lockTable";	//Select文を実行。
			
			st = cn.prepareStatement(sql);		//プリコンパイルされたSQL文を表す。
			
			rs = st.executeQuery();		//実行する。
			
			while(rs.next()){
				Product p = new Product();		//Productクラスをインスタンス化する。
				p.setId(rs.getString(1));		//Lid列をセットする。
				products.add(p);				//Productの変数で値を追加する。
			}
			cn.commit();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			
		}
		return products;
	}				
}