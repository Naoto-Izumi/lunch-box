import java.util.List;
import JDBCFiles.UserQuery;
import JDBCFiles.ChangeUser;
import Basic.AbstractCommand;
import Basic.ResponseContext;
import Basic.RequestContext;
import Beans.ProductBean;


//ユーザ情報を	更新
public class UUpdateCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		//JDBCにユーザ情報を要求
		System.out.println("UUpdateCommand"+reqc.getId());
		

		String radioseik = reqc.getParameter("radioseik")[0];//チェックボックスの値を受け取る 0or1
		//System.out.println(radioseik);
		String seik;										//先に変数を作っておく
		if(radioseik.equals("0")){									//変更しないに✓しているかで分岐
			seik = reqc.getParameter("seik")[0];			//チェックを入れている場合　元のデータを受け取る
		}else{
			seik = reqc.getParameter("newseik")[0];			//そうでない場合　新しいのデータを受け取る
		}

		String radiomeik = reqc.getParameter("radiomeik")[0];
		String meik;										
		if(radiomeik.equals("0")){									
			meik = reqc.getParameter("meik")[0];			
		}else{
			meik = reqc.getParameter("newmeik")[0];			
		}

		String radioseih = reqc.getParameter("radioseih")[0];
		String seih;										
		if(radioseih.equals("0")){									
			seih = reqc.getParameter("seih")[0];			
		}else{
			seih = reqc.getParameter("newseih")[0];			
		}
		
		String radiomeih = reqc.getParameter("radiomeih")[0];
		String meih;										
		if(radiomeih.equals("0")){									
			meih = reqc.getParameter("meih")[0];			
		}else{
			meih = reqc.getParameter("newmeih")[0];			
		}

		String radiosex = reqc.getParameter("radiosex")[0];
		String sex;										
		if(radiosex.equals("0")){								
			sex = reqc.getParameter("sex")[0];			
		}else{
			sex = reqc.getParameter("newsex")[0];			
		}

		String radiomail = reqc.getParameter("radiomail")[0];
		String mail;										
		if(radiomail.equals("0")){									
			mail = reqc.getParameter("mail")[0];			
		}else{
			mail = reqc.getParameter("newmail")[0];			
		}

		String radiopass = reqc.getParameter("radiopass")[0];
		String pass;										
		if(radiopass.equals("0")){									
			pass = reqc.getParameter("pass")[0];			
		}else{
			pass = reqc.getParameter("newpass")[0];			
		}

		String radiophone = reqc.getParameter("radiophone")[0];
		String phone;										
		if(radiophone.equals("0")){								
			phone = reqc.getParameter("phone")[0];			
		}else{
			phone = reqc.getParameter("newphone")[0];			
		}

		

		System.out.println(reqc.getId()+","+seik+","+meik+","+seih+","+meih+","+sex+","+mail+","+pass+","+phone);
		String url = ChangeUser.updateUser(reqc.getId(),seik,meik,seih,meih,sex,mail,pass,phone);
		//List ps = UserQuery.getUser(reqc.getId());
		//resc.setResult(ps);
		resc.setTarget("userinfo");
		return resc;
		
	}
}