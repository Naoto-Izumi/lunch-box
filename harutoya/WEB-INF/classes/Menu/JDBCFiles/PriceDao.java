package Menu.JDBCFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Menu.Beans.Product;

public class PriceDao implements ProductsDao{
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

            String sql="select  * from productTable where pro_id IN (?,?,?,?)";

            
            //PreparedStatementインターフェイスを実装するクラスをインスタンス化する
			st=cn.prepareStatement(sql);

            st.setString(1,_p.getSyusyokuId());
            st.setString(2,_p.getSyusaiId());
            st.setString(3,_p.getHuku1Id());
            st.setString(4,_p.getHuku2Id());

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			rs=st.executeQuery();

            // rs.last();
            // int row = rs.getRow();//行数を取得
            // rs.beforeFirst(); //最初に戻る
            int total = 0;
            //カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
                Product p = new Product();
				// for(int i=0;i<=row;i++){
                //     String value = rs.getString(i);	//列目のデータを取得
                // }
                String id = "no"+rs.getString("pro_id");	//1列目のデータを取得
                String name = rs.getString("pro_name");	//列目のデータを取得
                String price = rs.getString("pro_price");	//列目のデータを取得
                String stock = rs.getString("pro_stock");	//列目のデータを取得
                String calorie = rs.getString("pro_calorie");	//列目のデータを取得
                String date = rs.getString("pro_release_date");	//列目のデータを取得
                String type = rs.getString("pro_type");	//列目のデータを取得
                String image = rs.getString("pro_image");	//列目のデータを取得
                String description = rs.getString("pro_description");	//列目のデータを取得
                String protein = rs.getString("pro_protein");	//列目のデータを取得
                String carbohydrate = rs.getString("pro_carbohydrate");	//列目のデータを取得
                String lipid = rs.getString("pro_lipid");	//列目のデータを取得
                String vitamin = rs.getString("pro_vitamin");	//列目のデータを取得
                String inorganic = rs.getString("pro_inorganic");	//列目のデータを取得
                String wheat = rs.getString("pro_wheat");	//列目のデータを取得
                String egg = rs.getString("pro_egg");	//列目のデータを取得
                String milk = rs.getString("pro_milk");	//列目のデータを取得
                String peanuts = rs.getString("pro_peanuts");	//列目のデータを取得
                String buckwheat = rs.getString("pro_buckwheat");	//列目のデータを取得
                String shrimp = rs.getString("pro_shrimp");	//列目のデータを取得
                String crab = rs.getString("pro_crab");	//列目のデータを取得

                
                total += Integer.parseInt(price);
                System.out.println("ID"+id+"合計金額"+total);

				p.setPro_id(id);
				p.setPro_name(name);
                p.setPro_price(price);
				p.setPro_stock(stock);
                p.setPro_calorie(calorie);
				p.setPro_date(date);
                p.setPro_type(type);
				p.setPro_image(image);
                p.setPro_description(description);
				p.setPro_protein(protein);
                p.setPro_carbohydrate(carbohydrate);
				p.setPro_lipid(lipid);
                p.setPro_vitamin(vitamin);
				p.setPro_inorganic(inorganic);
                p.setPro_wheat(wheat);
				p.setPro_egg(egg);
                p.setPro_milk(milk);
				p.setPro_peanuts(peanuts);
                p.setPro_buckwheat(buckwheat);
				p.setPro_shrimp(shrimp);
                p.setPro_crab(crab);
                p.setTotal(((Integer)total).toString());
                
            
            
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

























// package dao;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.List;
// import java.util.ArrayList;

// import Bean.Product;

// public  class PriceDao implements ProductsDao{
//     private Product _p;
//     public Product getProduct(String pid){return null;}
//     public void addProduct(Product p){_p=p;}
//     public List getAllProducts(){
//         Connection cn=null;
//         PreparedStatement st=null;
//         ResultSet rs=null;

//         List products=new ArrayList();

//         try{
//             Class.forName("oracle.jdbc.driver.OracleDriver");

//             cn=DriverManager.getConnection(
//                 "jdbc:oracle:thin:@localhost:1521:orcl","info","pro"
//             );

//             cn.setAutoCommit(false);

//             String sql="select pro_price, pro_calorie, PRO_WHEAT ,PRO_EGG ,PRO_MILK ,PRO_PEANUTS ,PRO_BUCKWHEAT ,PRO_SHRIMP ,PRO_CRAB ,pro_id from productTable where pro_id IN (?,?,?,?)";

//             //PreparedStatementインターフェイスを実装するクラスをインスタンス化する
// 			st=cn.prepareStatement(sql);


//             //メモ帳みてね1213
//             st.setString(1,_p.getSyusyokuId());
//             st.setString(2,_p.getSyusaiId());
//             st.setString(3,_p.getHuku1Id());
//             st.setString(4,_p.getHuku2Id());

// 			//select文を実行し
// 			//ResultSetインターフェイスを実装したクラスの
// 			//インスタンスが返る
// 			rs=st.executeQuery();

//             //カーソルを一行だけスクロールし、データをフェッチする
// 			while(rs.next()){

//                 Product p = new Product();
// 				System.out.println(rs.getString(1));
// 				String pro_price = rs.getString(1);	//1列目のデータを取得
//                 String pro_calorie = rs.getString(2);	//2列目のデータを取得
//                 String pro_wheat = rs.getString(3);	//3列目のデータを取得
//                 String pro_egg = rs.getString(4);	//4列目のデータを取得
//                 String pro_milk = rs.getString(5);	//5列目のデータを取得
//                 String pro_peanuts = rs.getString(6);	//6列目のデータを取得
//                 String pro_buckwheat = rs.getString(7);	//7列目のデータを取得
//                 String pro_shrimp = rs.getString(8);	//8列目のデータを取得
//                 String pro_crab = rs.getString(9);	//9列目のデータを取得
//                 String pro_id = rs.getString(10); //10列目のデータを取得
// 				p.setPro_price(pro_price);
// 				p.setPro_calorie(pro_calorie);
//                 p.setPro_wheat(pro_wheat);
//                 p.setPro_egg(pro_egg);
//                 p.setPro_milk(pro_milk);
//                 p.setPro_peanuts(pro_peanuts);
//                 p.setPro_buckwheat(pro_buckwheat);
//                 p.setPro_shrimp(pro_shrimp);
//                 p.setPro_crab(pro_crab);
//                 p.setId(pro_id);


//                 products.add(p);
				
// 			}


//         }catch(ClassNotFoundException e) {
// 			e.printStackTrace();

// 		//getConnection,createStatement,executeQueryで例外発生の場合
// 		} catch(SQLException e) {
// 			e.printStackTrace();
// 		} finally {
// 			//リソースの解放処理を行う
// 			try {
// 				if(rs != null){
// 					rs.close();
// 				}
// 				if(st != null){
// 					st.close();
// 				}
// 				if(cn!=null){
// 					cn.close();
// 				}
// 			} catch(SQLException e2) {
// 				e2.printStackTrace();
// 			}
// 		}
//         return products;
//     }

// }