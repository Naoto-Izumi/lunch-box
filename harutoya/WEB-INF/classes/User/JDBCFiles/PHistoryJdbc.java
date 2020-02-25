package User.JDBCFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import Kanrisya.Beans.ProductBean;
import User.Beans.OrderBean;

public class PHistoryJdbc{
	public static List getPhistory(){
	
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		//System.out.println(pb);
		ArrayList<OrderBean> order = new ArrayList<OrderBean>();
	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","helshin","helshinbox");
			cn.setAutoCommit(false);
			String sql = "SELECT s.sp_pro_id,p.pro_name,o.or_date,s.sp_count FROM specificationTable s JOIN productTable p ON s.sp_pro_id = p.pro_id JOIN orderTable o ON s.sp_or_id = o.or_id";
			st=cn.prepareStatement(sql);
			rs=st.executeQuery();
			while(rs.next()){
				OrderBean o = new OrderBean();
				o.setOdate(rs.getString(1));
				o.setSproid(rs.getString(2));
				o.setScount(rs.getString(3));
				o.setPid(rs.getString(4));
				
				order.add(o);
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
		return order;
	}
}
