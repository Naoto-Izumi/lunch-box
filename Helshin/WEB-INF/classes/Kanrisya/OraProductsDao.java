package Kanrisya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSetMetaData;

import java.sql.Statement;

//import tera.Product;
//import exp.ResourceAccessException;

public class OraProductsDao implements ProductsDao{
	public void addProduct(Product p){
		Connection cn = null;
		
		//add(40行まで)
		PreparedStatement st = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl","helshin","helshinbox");
			
			cn.setAutoCommit(false);
			
			String sql2 = "SELECT MAX(lo_id+1) FROM lockTable";
			Statement st2 = cn.createStatement();
			ResultSet rs2 = st2.executeQuery(sql2);
			rs2.next();
			int newid = rs2.getInt(1);
			
			String sql = "insert into lockTable(lo_id,lo_user_id)"
			+"values(?,?)";
			
			st = cn.prepareStatement(sql);
			//st.setString(1,p.getPid());
			//st.setString(2,p.getName());
			//st.setString(3,p.getPrice());
			
			st.setInt(1,newid);
			st.setInt(2,Integer.parseInt(p.getId()));
			
			st.executeUpdate();
			
			cn.commit();
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			//throw new ResourceAccessException(e.getMessage(),e);
		}catch(SQLException e){
			e.printStackTrace();
			/*try{
				cn.rollback();
			}catch(SQLException e2){
				throw new ResourceAccessException(e2.getMessage(),e2);
			}
			throw new ResourceAccessException(e.getMessage(),e);*/
			
		}finally{
			/*try{
				if(st != null){
					st.close();
				}
			}catch(SQLException e2){
				throw new ResourceAccessException(e2.getMessage(),e2);
			}finally{
				try{
					if(cn!= null){
						cn.close();
					}
				}catch(SQLException e3){
					throw new ResourceAccessException(e3.getMessage(),e3);
				}
			}*/
		}
	}
	public List getProduct(String pid){
		Statement st = null;
		ResultSet rs = null;
		Connection cn = new OracleConnector("helshin","helshinbox").getCn();
		String q = "SELECT user_id,user_lastname,user_mail,user_phone FROM userTable  where user_lastname LIKE '"+pid+"%'";
		
		List<Product> ppp= new ArrayList<Product>();
		
		try{
			st = cn.createStatement();
			rs = st.executeQuery(q);
			
			ResultSetMetaData rsMeta = rs.getMetaData();
			
			int columnCount = rsMeta.getColumnCount();
			
			while(rs.next()){
				Product pr = new Product();
				
				pr.setLname(rs.getString(2));
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				//System.out.println(rs.getString(5));
				pr.setTelphone(rs.getString(4));	
				pr.setMail(rs.getString(3));		
				pr.setId(rs.getString(1));
				//pr.setLid(rs.getString(5));
				
				/*for(int i = 0; true; i++){
					while(true){
						pr.setLid(rs.getString(5));
					}
					System.out.println(true);	
				}*/
				
				ppp.add(pr);
			}
		}
		catch(SQLException e){
			//throw new SQLException(e);
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
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			cn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl","helshin","helshinbox");
			
			cn.setAutoCommit(false);
			
			String sql = "select lo_id,lo_user_id FROM lockTable";
			
			st = cn.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()){
				Product p = new Product();
				//p.setPid(rs.getString(1));
				//p.setName(rs.getString(2));
				//p.setPrice(rs.getString(3));
				
				p.setId(rs.getString(1));
				
				products.add(p);
			}
			cn.commit();
		}catch(ClassNotFoundException e){
			//throw new ResourceAccessException(e.getMessage(),e);
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
			/*try{
				cn.rollback();
			}catch(SQLException e2){
				throw new ResourceAccessException(e2.getMessage(),e2);
			}
			throw new ResourceAccessException(e.getMessage(),e);*/
		}finally{
			/*try{
				if(rs != null){
					rs.close();
				}
				if(st != null){
					st.close();
				}
			}catch(SQLException e2){
				throw new ResourceAccessException(e2.getMessage(),e2);
			}finally{
				try{
					if(cn != null){
						cn.close();
					}
				}catch(SQLException e3){
					throw new ResourceAccessException(e3.getMessage(),e3);
				}
			}*/
		}
		return products;
	}				
}