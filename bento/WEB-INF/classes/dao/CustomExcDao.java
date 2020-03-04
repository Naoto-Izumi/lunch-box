package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import Bean.Product;

public  class CustomExcDao{
    private String id;
    private String type;
    public boolean getProduct(String _id,String _type){
        id=_id;
        type=_type;
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        boolean judge=false;

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            cn=DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl","info","pro"
            );

            cn.setAutoCommit(false);

            String sql="select count(*) from productTable　where pro_id = ? AND pro_type = ?";

            //PreparedStatementインターフェイスを実装するクラスをインスタンス化する
			st=cn.prepareStatement(sql);

            st.setString(1,id);
            st.setString(2,type);

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			rs=st.executeQuery();


            System.out.println("no"+rs.getString(1));
            int  count = rs.getInt(1);

            

            if(count==0){
                judge = true;  
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
        return judge;
    }

}