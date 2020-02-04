package Kanrisya.Beans;
import java.io.Serializable;

public class LockUserBox implements Serializable{
	private String lname;		//ユーザー名
	private String id;			//ユーザーID
	private String mail;		//メールアドレス
	private String telphone;	//電話番号
	private String lid;			//名字(ふりがななし)
	
	/*セッター・ゲッター*/
	public String getLname(){
		return lname;
	}
	public void setLname(String lname){
		this.lname = lname;
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getMail(){
		return mail;
	}
	public void setMail(String mail){
		this.mail = mail;
	}
	public String getTelphone(){
		return telphone;
	}
	public void setTelphone(String telphone){
		this.telphone = telphone;
	}
	public String getLid(){
		return lid;
	}
	public void setLid(String lid){
		this.lid = lid;
	}
}
