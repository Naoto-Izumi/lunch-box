package Menu.JDBCFiles;
import Menu.Beans.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

// public  class CusSyusyokuDao implements ProductsDao{
public  class CusDao{
    public ElementBean getProduct(String pid){
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
		ElementBean eb = new ElementBean();
		try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","helshin","helshinbox");
            cn.setAutoCommit(false);
            String sql="select * from productTable　where pro_id = ?";
            st=cn.prepareStatement(sql);
			st.setString(1,pid);
			rs=st.executeQuery();
			rs.next();
			NutritionBean nb = new NutritionBean();
			nb.setPro_protein(rs.getInt("pro_protein"));
			nb.setPro_carbohydrate(rs.getInt("pro_carbohydrate"));
			nb.setPro_lipid(rs.getInt("pro_lipid"));
			nb.setPro_vitamin(rs.getInt("pro_vitamin"));
			nb.setPro_inorganic(rs.getInt("pro_inorganic"));
			AllergyBean ab = new AllergyBean();
			ab.setPro_wheat(rs.getInt("pro_wheat"));
			ab.setPro_egg(rs.getInt("pro_egg"));
			ab.setPro_milk(rs.getInt("pro_milk"));
			ab.setPro_peanuts(rs.getInt("pro_peanuts"));
			ab.setPro_buckwheat(rs.getInt("pro_buckwheat"));
			ab.setPro_shrimp(rs.getInt("pro_shrimp"));
			ab.setPro_crab(rs.getInt("pro_crab"));
			eb.setImage(rs.getString("pro_image"));
			eb.setId(rs.getString("pro_id"));
			eb.setName(rs.getString("pro_name"));
			eb.setMoney(rs.getInt("pro_price"));
			eb.setCalory(rs.getString("pro_calorie"));
			eb.setType(rs.getString("pro_type"));
			eb.setCount(rs.getString("pro_stock"));
			eb.setAb(ab);
			eb.setNb(nb);



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
		return eb;
	}
    public void addProduct(Product p){}
    public List getAllProducts(){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        List products=new ArrayList();

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            cn=DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl","helshin","helshinbox"
            );

            cn.setAutoCommit(false);

            String sql="select pro_id,pro_image,pro_name,pro_price,pro_calorie from productTable　where pro_type = '主食'  ";

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