package User.CommandFiles;

import java.util.List;
import User.JDBCFiles.UserQuery;
import User.JDBCFiles.ChangeUser;
import Kanrisya.AbstractCommand;
import Kanrisya.ResponseContext;
import Kanrisya.RequestContext;
import User.Beans.UserBean;
import Kanrisya.Beans.ProductBean;

//ユーザ情報を	更新
public class UUpdateCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		ProductBean pb = new ProductBean();
		//JDBCにユーザ情報を要求
		System.out.println("UUpdateCommand"+reqc.getId());
		
		UserBean ub = new UserBean();
		//ProductBean pb = new ProductBean();
		String radioseik = ((String[])reqc.getParameter("radioseik"))[0];//チェックボックスの値を受け取る 0or1
		ub.setSeik(radioseik);
		
		//System.out.println(radioseik);
		String seik;										//先に変数を作っておく
		if(radioseik.equals("0")){									//変更しないに✓しているかで分岐
			seik = reqc.getParameter("seik")[0];			//チェックを入れている場合　元のデータを受け取る
		}else{
			seik = reqc.getParameter("newseik")[0];			//そうでない場合　新しいのデータを受け取る
		}

		String radiomeik = ((String[])reqc.getParameter("radiomeik"))[0];
		ub.setMeik(radiomeik);
		
		String meik;										
		if(radiomeik.equals("0")){									
			meik = reqc.getParameter("meik")[0];			
		}else{
			meik = reqc.getParameter("newmeik")[0];			
		}

		String radioseih = ((String[])reqc.getParameter("radioseih"))[0];
		ub.setSeih(radioseih);
		
		String seih;										
		if(radioseih.equals("0")){									
			seih = reqc.getParameter("seih")[0];			
		}else{
			seih = reqc.getParameter("newseih")[0];			
		}
		
		String radiomeih = ((String[])reqc.getParameter("radiomeih"))[0];
		ub.setMeih(radiomeih);
		
		String meih;										
		if(radiomeih.equals("0")){									
			meih = reqc.getParameter("meih")[0];			
		}else{
			meih = reqc.getParameter("newmeih")[0];			
		}

		String radiosex = ((String[])reqc.getParameter("radiosex"))[0];
		ub.setSex(radiosex);
		
		String sex;										
		if(radiosex.equals("0")){								
			sex = reqc.getParameter("sex")[0];			
		}else{
			sex = reqc.getParameter("newsex")[0];			
		}

		String radiomail = ((String[])reqc.getParameter("radiomail"))[0];
		ub.setMail(radiomail);
		
		String mail;										
		if(radiomail.equals("0")){									
			mail = reqc.getParameter("mail")[0];			
		}else{
			mail = reqc.getParameter("newmail")[0];			
		}

		String radiopass = ((String[])reqc.getParameter("radiopass"))[0];
		ub.setPass(radiopass);
		
		String pass;										
		if(radiopass.equals("0")){									
			pass = reqc.getParameter("pass")[0];			
		}else{
			pass = reqc.getParameter("newpass")[0];			
		}

		String radiophone = ((String[])reqc.getParameter("radiophone"))[0];
		ub.setPhone(radiophone);
		
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
		resc.setTargetCommand("uuc");
		return resc;
		
	}
}