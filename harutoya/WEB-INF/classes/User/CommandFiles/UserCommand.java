package User.CommandFiles;

import java.util.List;
import Main.ApplicationController;
import Main.RequestContext;
import Main.ResponseContext;
import java.util.Map;
import Main.AbstractCommand;

import User.Beans.UserBox;
import User.JDBCFiles.UserData;

public class UserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		UserBox ubox = new UserBox();
		String lname = ((String[])reqc.getParameter("lastname"))[0];			//名前(上の名前)
		ubox.setLname(lname);
		
		String fname = ((String[])reqc.getParameter("firstname"))[0];			//名前(下の名前)
		ubox.setFname(fname);			
		
		String lhname = ((String[])reqc.getParameter("lastname_hira"))[0];		//名前(上の名前(ふりがな))
		ubox.setLhname(lhname);
		
		String fhname = ((String[])reqc.getParameter("firstname_hira"))[0];		//名前(下の名前(ふりがな))
		ubox.setFhname(fhname);
		
		String telphone = ((String[])reqc.getParameter("phone"))[0];			//電話番号
		ubox.setTelphone(telphone);
			
		String mail = ((String[])reqc.getParameter("mail"))[0];					//メールアドレス
		ubox.setMail(mail);
			
		String pass = ((String[])reqc.getParameter("password"))[0];				//パスワード
		ubox.setPass(pass);			
		
		String address = ((String[])reqc.getParameter("address"))[0];			//住所
		ubox.setAddress(address);
			
		String sex = ((String[])reqc.getParameter("sex"))[0];					//性別
		ubox.setSex(sex);
			
		String birth = ((String[])reqc.getParameter("birthyear"))[0];			//誕生日
		ubox.setBirth(birth);

		List udata = UserData.OracleUserData(ubox);
		
		resc.setResult(udata);
		resc.setTargetCommand("user");
		resc.setTarget("user/registuser");
		
		return resc;
	}
}
