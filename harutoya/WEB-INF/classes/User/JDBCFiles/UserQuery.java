package User.JDBCFiles;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import User.Beans.UserBean;

public class UserQuery{
	
	public static List getUser(String id){
		Connection cn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		System.out.println(id);
		ArrayList<UserBean> user=new ArrayList<UserBean>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","helshin","helshinbox");
			cn.setAutoCommit(false);
			String sql="select user_lastname,user_firstname,user_lastname_hira,user_firstname_hira,user_sex,user_mail,user_pass,user_phone,user_birthday from userTable where user_id = '"+id+"'";
			st=cn.prepareStatement(sql);
			rs=st.executeQuery();
			System.out.println("resultSet"+rs);
			while(rs.next()){
				UserBean s=new UserBean();

				s.setSeik(rs.getString(1));
				s.setMeik(rs.getString(2));
				s.setSeih(rs.getString(3));
				s.setMeih(rs.getString(4));
				s.setSex(rs.getString(5));
				s.setMail(rs.getString(6));
				s.setPass(rs.getString(7));
				s.setPhone(rs.getString(8));
				System.out.println("UserQuery姓漢字"+rs.getString(1));
				//s.setBirth(rs.getInt(9));


				user.add(s);
			}
			cn.commit();
		}catch(ClassNotFoundException e){
			System.out.println("ClassNotFoundex");
			e.printStackTrace();	
		}catch(SQLException e){
			System.out.println("SQLex");
			try{
				cn.rollback();
			}catch(SQLException e2){
				System.out.println("SQLex");
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
				System.out.println("SQLex");
				e2.printStackTrace();
			}finally{
				try{
					if(cn!=null){
						cn.close();
					}
				}catch(SQLException e3){
					System.out.println("SQLex");
					e3.printStackTrace();
				}
			}

		}
		return user;
	}
}
