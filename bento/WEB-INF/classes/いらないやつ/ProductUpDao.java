//注文した個数、productTableの在庫を減らす
//いらないやつ
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Bean.Product;

public  class ProductUpDao implements ProductsDao{
	public Product getProduct(String pid){return null;}
    public List getAllProducts(){return null;}
    public void addProduct(Product p){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            cn=DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl","info","pro"
            );

            cn.setAutoCommit(false);

            String sql="UPDATE productTable SET pro_stock=pro_stock-? WHERE pro_id=?";

            st=cn.prepareStatement(sql);

            // id=id.substring(5);

            st.setInt(1,Integer.parseInt(stock));
            st.setInt(2,Integer.parseInt(id));

            st.executeUpdate();


        }catch(ClassNotFoundException e) {
			e.printStackTrace();

		//getConnection,createStatement,executeQueryで例外発生の場合
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//リソースの解放処理を行う
			try {
				if(rs != null){
					rs.close();
				}
				if(st != null){
					st.close();
				}
				if(cn!=null){
					cn.close();
				}
			} catch(SQLException e2) {
				e2.printStackTrace();
			}
		}
    }
}