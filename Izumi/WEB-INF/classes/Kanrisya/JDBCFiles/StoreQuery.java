package Kanrisya.JDBCFiles;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import Kanrisya.Beans.StoreBean;


class Test{
	public static void main(String[] args){

		List l =StoreQuery.getAllStore();
	}
}
public class StoreQuery{
	
	public static List getAllStore(){
		Connection cn=null;
		PreparedStatement st=null;
		ResultSet rs=null;

		ArrayList<StoreBean> store=new ArrayList<StoreBean>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","helshin","helshinbox");
			cn.setAutoCommit(false);
			String sql="select st_id,st_name,st_address,st_phone,st_hours from storeTable";
			st=cn.prepareStatement(sql);
			rs=st.executeQuery();
			while(rs.next()){
				StoreBean s=new StoreBean();

				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setAddress(rs.getString(3));
				s.setPhone(rs.getString(4));
				s.setHours(rs.getString(5));
			

				store.add(s);
			}
			cn.commit();
		}catch(ClassNotFoundException e){
			e.printStackTrace();	
		}catch(SQLException e){
			try{
				cn.rollback();
			}catch(SQLException e2){
				e2.printStackTrace();
			}
			e.printStackTrace();		
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(st!=null){
					st.close();
				}
			}catch(SQLException e2){
				e2.printStackTrace();
			}finally{
				try{
					if(cn!=null){
						cn.close();
					}
				}catch(SQLException e3){
					e3.printStackTrace();
				}
			}

		}
		return store;
	}
}
