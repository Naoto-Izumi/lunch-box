package Menu.JDBCFiles;
import Menu.Beans.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuPriceDao implements ProductsDao{
    private Product _p;
    public void addProduct(Product p){_p=p;}
    //基本はこっちを使う
    public List getAllProducts(){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        List products=new ArrayList();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","helshin","helshinbox");

            cn.setAutoCommit(false);

            String sql="select * from productTable where pro_id = ?";

            
            //PreparedStatementインターフェイスを実装するクラスをインスタンス化する
			st=cn.prepareStatement(sql);

            st.setString(1,_p.getPro_id());


			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			rs=st.executeQuery();

            // rs.last();
            // int row = rs.getRow();//行数を取得
            // rs.beforeFirst(); //最初に戻る
            int total = 0;
            //servletから送られてきた注文個数
            String count = _p.getCount();
            //カーソルを一行だけスクロールし、データをフェッチする（そもそも1行しかループしないはず）
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

                //こっちにjspで入力した個数送ってこないと商品ごとの合計金額の計算できなくね？？？？？？？？？
                //と思ったのでProductに個数を登録しました
                total += Integer.parseInt(price);
                System.out.println("ID:"+id+" 金額:"+total);
                //商品ごとの合計金額を計算
                total = total * Integer.parseInt(count);
                System.out.println("合計金額:"+total);

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





    //こっちは使わないほうが好ましい（使わないようにしたい）
    public Product getProduct(String pid){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        Product p = new Product();
          try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","helshin","helshinbox");

            cn.setAutoCommit(false);

            String sql="select  * from productTable where pro_id = ?";
            //PreparedStatementインターフェイスを実装するクラスをインスタンス化する
			st=cn.prepareStatement(sql);
            st.setString(1,pid);

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			rs=st.executeQuery();
            int total = 0;
        
            //カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
               
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
        return p;

    }
    

}










