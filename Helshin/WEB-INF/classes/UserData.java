import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import Bean.UserBox;

public class UserData{
	public static void main(String[] args){
		OracleUserData(new UserBox());
		
	}
	public static void OracleUserData(UserBox b){
		Statement st = null;
		ResultSet rs = null;
		
		Connection cn = new OracleConnector("helshin","helshinbox").getCn();
		String query = "INSERT INTO USERTABLE (lastname,firstname,slastname_hira,firstname_hira,phone,mail,password,address,sex,birthyear) VALUES("+b.getLname()+","+b.getFname()+","+b.getLhname()+","+b.getFhname()+","+b.getTelphone()+","+b.getMail()+","+b.getPass()+","+b.getAddress()+","+b.getSex()+","+b.getBirth()+")";
		try{
			st = cn.createStatement();
			rs = st.executeQuery(query);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}

