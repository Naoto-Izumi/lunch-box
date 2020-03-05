package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Product;

public class SortHukuDao implements ProductsDao{
    private Product _p;
    public Product getProduct(String pid){return null;}
    public void addProduct(Product p){_p=p;}
    public List getAllProducts(){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        List products=new ArrayList();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","helshin","helshinbox");

            cn.setAutoCommit(false);

            

            String reSql = _p.getSortVal();
            String preSql="select  pro_id,pro_image,pro_name,pro_price,pro_calorie from productTable where pro_type='副菜' ";
            String sql=preSql + reSql;

            
            //PreparedStatementインターフェイスを実装するクラスをインスタンス化する
			st=cn.prepareStatement(sql);







			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			rs=st.executeQuery();

            //カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
                Product p = new Product();
				System.out.println("no"+rs.getString(1));
				String id = "no"+rs.getString(1);	//1列目のデータを取得
				String image = rs.getString(2);	//2列目のデータを取得
				String name = rs.getString(3);	//3列目のデータを取得
                String price = rs.getString(4);
                String calorie = rs.getString(5);
				p.setId(id);
				p.setImage(image);
				p.setName(name);
                p.setPro_price(price);
                p.setPro_calorie(calorie);

                products.add(p);
				
			}
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
        return products;

    }

}
