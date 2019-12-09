import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import Bean.*;
import java.sql.*;
import java.util.ArrayList;
public class TestServlet extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res)
    throws IOException,ServletException{
        String name=req.getParameter("name");
        ArrayList<CustomBentoBean> ar =new ArrayList<>();
        ArrayList<CustomBentoBean> ar1 =new ArrayList<>();

        String sql ="select * from product";

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                CustomBentoBean cb = new CustomBentoBean();
                cb.setCount(rs.getInt(1));
                cb.setName(rs.getString(2));
                cb.setType(rs.getString(3));
                ar.add(cb);
            }

            String sql1="update product set count = (count -1) where name ='"+name+"'";
            int i = st.executeUpdate(sql);

            rs = st.executeQuery(sql);
            while(rs.next()){
                CustomBentoBean cb = new CustomBentoBean();
                cb.setCount(rs.getInt(1));
                cb.setName(rs.getString(2));
                cb.setType(rs.getString(3));
                ar1.add(cb);
            }

            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        req.setAttribute("tableBefore",ar);
        req.setAttribute("tableAfter",ar1);

        RequestDispatcher dis = req.getRequestDispatcher("/test.jsp");
        dis.forward(req,res);
    }
}