//注文を受付てorderTableにinsert
package Menu.JDBCFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import Menu.Beans.Product;


public class OrderInDao implements ProductsDao{
    public Product getProduct(String pid){return null;}
    public List getAllProducts(){return null;}
    public void addProduct(Product p){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","helshin","helshinbox");

            cn.setAutoCommit(false);

            Calendar cl = Calendar.getInstance();
        
            //SimpleDateFormatクラスでフォーマットパターンを設定する
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
            System.out.println(sdf.format(cl.getTime()));
            String da=sdf.format(cl.getTime());
            System.out.println(da+" "+p.getTime());
            String a1="insert into orderTable(or_id,or_user_id,or_type,OR_ADDRESS_ID,OR_DATE) values(sq_or_id.NEXTVAL,1,?,1,TO_DATE('";
             String a2=da+" "+p.getTime();
             String a3="','yy-MM-dd hh24:mi:ss'))";

            //or_user_idの挿入する値を変える
            // String sql="insert into orderTable(or_id,or_user_id,or_type,OR_ADDRESS_ID,OR_DATE)
            //  values(sq_or_id.NEXTVAL,1,?,1,TO_DATE('"+da+" "+p.getTime()+"','yy-MM-dd hh24:mi:ss'))";
            String sql=a1.concat(a2).concat(a3);
           
            System.out.println("p.getType()"+p.getType());
            System.out.println("p.getTime()"+p.getTime());

            st=cn.prepareStatement(sql);

            


            st.setString(1,p.getType());
            // st.setString(2,p.getAddress());
            //st.setString(2,da+" "+p.getTime());

            st.executeUpdate();

            //update文-----------------------------------------------

             //在庫減らす
            String upsql="UPDATE productTable SET pro_stock=pro_stock-? WHERE pro_id=?";

            st=cn.prepareStatement(upsql);

            
            // id=id.substring(5);

            String stock=p.getStock();
            String id=p.getNum();

            st.setInt(1,Integer.parseInt(stock));
            st.setInt(2,Integer.parseInt(id));




            st.executeUpdate();

            cn.commit();

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