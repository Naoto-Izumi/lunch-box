package Kanrisya.JDBCFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Map;
import Kanrisya.Beans.ProductBean;
import Kanrisya.Beans.StoreBean;

/*-----------------------商品登録---------------------*/
public class RegistJdbc{	
	public static void main(String[] args){}	//テスト用メソッド
	public static String RegistProduct(ProductBean m){
		
		Connection cn=null;
		Statement st=null;

		//キーを引数にそれぞれの値(アレルゲンや五大栄養素など)を受け取る
		String name= m.getName();		//商品名
		int price=m.getPrice();			//値段
		int cal=m.getCalorie();			//カロリー
		String cate=m.getType();		//商品の種類
		String image=m.getImage();		//商品画像
		String pro=m.getPro();			//タンパク質(五大栄養素)
		String carbo=m.getCarbo();		//糖質(五大栄養素)
		String lip=m.getLip();			//脂質(五大栄養素)
		String vita=m.getVita();		//ビタミン(五大栄養素)
		String ino=m.getIno();			//無機質(五大栄養素)
		String wheat=m.getWheat();		//小麦(アレルギー)
		String egg=m.getEgg();			//卵(アレルギー)
		String milk=m.getMilk();		//牛乳(アレルギー)
		String peanut=m.getPeanut();	//落花生(アレルギー)
		String buck=m.getBuck();		//そば(アレルギー)
		String shrimp=m.getShrimp();	//えび(アレルギー)
		String kani=m.getKani();		//かに(アレルギー)
		
		//栄養素は何も空文字入力if文で空文字なら0に返る

		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "helshin","helshinbox");
			
			cn.setAutoCommit(false);
			
			System.out.println("接続完了");

			st=cn.createStatement();
			/*----主キーにシーケンスを付けるなら↓----*/
			
			String sql1 = "select max(pro_id) from producttable";	
			ResultSet rs2=st.executeQuery(sql1);
			rs2.next();
			int id=(rs2.getInt(1) )+ 1;	//主キーにプラス1して次へ
			/*--------ここまでいらない↑----------*/

			String sql="insert into productTable(pro_id,pro_name,pro_price,pro_calorie,pro_type,pro_image,pro_protein,pro_carbohydrate,pro_lipid,pro_vitamin,pro_inorganic,pro_wheat,pro_egg,pro_milk,pro_peanuts,pro_buckwheat,pro_shrimp,pro_crab) values('"+id+"','"+name+"','"+price+"','"+cal+"','"+cate+"','"+image+"','"+pro+"','"+carbo+"','"+lip+"','"+vita+"','"+ino+"','"+wheat+"','"+egg+"','"+milk+"','"+peanut+"','"+buck+"','"+shrimp+"','"+kani+"')";
			
			int count=st.executeUpdate(sql);
			
			System.out.println(count+"件処理完了");
			
			cn.commit();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
			if(cn!=null && st!=null){
				try{
					cn.rollback();
					System.out.println("ロールバックしました");
				}catch(SQLException ex){
					ex.printStackTrace();
				}
			}
		}finally{
			try{
				if(st!=null){
					st.close();
					System.out.println("ステートメントを解放");
				}
				if(cn!=null){
					cn.close();
					System.out.println("コネクションを解放");
				}
				System.out.println("リソースの開放完了");
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return "/pqs";
	}
/*-----------------------店舗登録--------------------*/
	public static String RegistStore(StoreBean m){
		
		Connection cn=null;
		Statement st=null;

		String name= m.getName();
		String address= m.getAddress();
		String number= m.getPhone();
		String hours= m.getHours();


		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "helshin","helshinbox");
			
			cn.setAutoCommit(false);
			
			System.out.println("接続完了");
			
			st=cn.createStatement();
			//シーケンスで主キーを制御
			String sql="insert into storeTable values(sq_st_id.Nextval,'"+name+"','"+address+"','"+number+"','"+hours+"')";
						
			int count=st.executeUpdate(sql);
			
			System.out.println(count+"件処理完了");
			
			cn.commit();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
			if(cn!=null && st!=null){
				try{
					cn.rollback();
					System.out.println("ロールバックしました");
				}catch(SQLException ex){
					ex.printStackTrace();
				}
			}
		}finally{
			try{
				if(st!=null){
					st.close();
					System.out.println("ステートメントを解放");
				}
				if(cn!=null){
					cn.close();
					System.out.println("コネクションを解放");
				}
				System.out.println("リソースの開放完了");
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return "/sqs";
	}
	
}