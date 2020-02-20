package Kanrisya.JDBCFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import Kanrisya.Beans.ProductBean;

public class ProductQuery{
	
	public static List getAllProducts(){
		Connection cn=null;
		PreparedStatement st=null;
		ResultSet rs=null;

		ArrayList<ProductBean> products=new ArrayList<ProductBean>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","helshin","helshinbox");
			cn.setAutoCommit(false);
			String sql="select pro_id,pro_name,pro_price,pro_stock,pro_calorie,pro_release_date,pro_type,pro_image,pro_protein,pro_carbohydrate,pro_lipid,pro_vitamin,pro_inorganic,pro_wheat,pro_egg,pro_milk,pro_peanuts,pro_buckwheat,pro_shrimp,pro_crab from producttable";
			st=cn.prepareStatement(sql);
			rs=st.executeQuery();
			while(rs.next()){
				ProductBean p=new ProductBean();

				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getInt(3));
				p.setStock(rs.getInt(4));
				p.setCalorie(rs.getInt(5));
				p.setDate(rs.getString(6));
				p.setType(rs.getString(7));
				p.setImage(rs.getString(8));
				p.setPro(rs.getString(9));
				p.setCarbo(rs.getString(10));
				p.setLip(rs.getString(11));
				p.setVita(rs.getString(12));
				p.setIno(rs.getString(13));
				p.setWheat(rs.getString(14));
				p.setEgg(rs.getString(15));
				p.setMilk(rs.getString(16));
				p.setPeanut(rs.getString(17));
				p.setBuck(rs.getString(18));
				p.setShrimp(rs.getString(19));
				p.setKani(rs.getString(20));

				products.add(p);
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
		return products;
	}
}
