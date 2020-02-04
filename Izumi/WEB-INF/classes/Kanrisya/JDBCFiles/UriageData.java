package Kanrisya.JDBCFiles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.List;
import java.util.ArrayList;

//import Kanrisya.Uriage.Beans.PrintWriter;
import Kanrisya.Beans.UriageBox;

public class UriageData{
	/*public static void main(String[] args){
		UriageBox u = new UriageBox();	//UriageBoxクラスを呼び出す。
		u.setYear("2019");	//年
		u.setMonth("01");	//月
		
		u.setName("とんかつ");	//商品名
		u.setCount("1");		//カウント数
		
		OracleUriageData(u);	//OracleUriageData()メソッドを転送
	}*/
	public static List OracleUriageData(UriageBox ub){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		//パスワードを指定
		//Connection cn = new OracleConnector("helshin","helshinbox").getCn();
		
		//年と月を絞り込む。
		//String d = ub.getYear()+"-"+ub.getMonth()+"-01";
		
		//表示したいSELECT文(１行にしないとできません)
		/*String q = 
			"SELECT p.pro_name ,SUM(s.sp_count) as 売り上げ FROM  specificationTable s JOIN orderTable o ON s.sp_or_id = o.or_id JOIN productTable p ON s.sp_pro_id = p.pro_id WHERE trunc(o.or_date,'mm') = TO_DATE('"+d+"','YYYY-MM-DD') GROUP BY p.pro_name";
		*/
		//List型でセットする。
		ArrayList<UriageBox>uub = new ArrayList<UriageBox>();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","helshin","helshinbox");
			cn.setAutoCommit(false);
			String d = ub.getYear()+"-"+ub.getMonth()+"-01";
			String q = 
			"SELECT p.pro_name ,SUM(s.sp_count) as 売り上げ FROM  specificationTable s JOIN orderTable o ON s.sp_or_id = o.or_id JOIN productTable p ON s.sp_pro_id = p.pro_id WHERE trunc(o.or_date,'mm') = TO_DATE('"+d+"','YYYY-MM-DD') GROUP BY p.pro_name";
	
			//Statementの変数でConnectionのcreateStatement()メソッドを呼び出す。
			st = cn.prepareStatement(q);
			
			//SELECT命令を実行。
			rs = st.executeQuery();
			
			while(rs.next()){
				UriageBox uu = new UriageBox();		//UserBoxクラスをインスタンス化する。
				
				uu.setName(rs.getString(1));	//Name列をセットする。
				uu.setCount(rs.getString(2));	//Count列をセットする。
				
				System.out.println(rs.getString(1));	//Name列を表示する。
				System.out.println(rs.getString(2));	//Count列を表示する。
				
				uub.add(uu);	//UserBoxの変数で各列を追加する。
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
		return uub;
	}
}
