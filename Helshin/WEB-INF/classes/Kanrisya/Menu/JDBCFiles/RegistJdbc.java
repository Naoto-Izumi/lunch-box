package Kanrisya.Menu.JDBCFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Map;

/*-----------------------商品登録---------------------*/
public class RegistJdbc{	
	public static void main(String[] args){}	//テスト用メソッド
	public static String RegistProduct(Map m){
		
		Connection cn=null;
		Statement st=null;

		//キーを引数にそれぞれの値(アレルゲンや五大栄養素など)を受け取る
		String name=((String[])m.get("pname"))[0];	
		String price=((String[])m.get("price"))[0];
		String cal=((String[])m.get("cal"))[0];
		String cate=((String[])m.get("cate"))[0];
		String image=((String[])m.get("image"))[0];
		String pro=((String[])m.get("pro"))[0];
		String carbo=((String[])m.get("carbo"))[0];
		String lip=((String[])m.get("lip"))[0];
		String vita=((String[])m.get("vita"))[0];
		String ino=((String[])m.get("ino"))[0];
		String wheat=((String[])m.get("wheat"))[0];
		String egg=((String[])m.get("egg"))[0];
		String milk=((String[])m.get("milk"))[0];
		String peanut=((String[])m.get("peanut"))[0];
		String buck=((String[])m.get("buck"))[0];
		String shrimp=((String[])m.get("shrimp"))[0];
		String kani=((String[])m.get("kani"))[0];

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

			String sql="insert into productTable(pro_id,pro_name,pro_price,pro_calorie,pro_type,pro_image,pro_protein,pro_carbohydrate,pro_lipid,pro_vitamin,pro_inorganic,pro_wheat,pro_egg,pro_milk,pro_peanuts,pro_buckwheat,pro_shrimp,pro_club) values('"+id+"','"+name+"','"+price+"','"+cal+"','"+cate+"','"+image+"','"+pro+"','"+carbo+"','"+lip+"','"+vita+"','"+ino+"','"+wheat+"','"+egg+"','"+milk+"','"+peanut+"','"+buck+"','"+shrimp+"','"+kani+"')";
			
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
	
}