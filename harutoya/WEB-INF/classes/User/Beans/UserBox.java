package User.Beans;

public class UserBox{
	private String lname;		//名前(上の方)
	private String fname;		//名前(下の方)
	private String lhname;		//名前(ふりがな(上の方))
	private String fhname;		//名前(ふりがな(下の方))
	private String telphone;	//電話番号
	private String mail;		//メールアドレス
	private String pass;		//パスワード
	private String address;		//住所
	private String sex;			//性別
	private String birth;		//誕生日
	
	/*セッター*/
	public void setLname(String lname){
		this.lname = lname;
	}
	public void setFname(String fname){
		this.fname = fname;
	}
	public void setLhname(String lhname){
		this.lhname = lhname;
	}
	public void setFhname(String fhname){
		this.fhname = fhname;
	}
	public void setTelphone(String telphone){
		this.telphone = telphone;
	}
	public void setMail(String mail){
		this.mail = mail;
	}
	public void setPass(String pass){
		this.pass = pass;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public void setBirth(String birth){
		this.birth = birth;
	}
	
	/*ゲッター*/
	public String getLname(){
		return lname;
	}
	public String getFname(){
		return fname;
	}
	public String getLhname(){
		return lhname;
	}
	public String getFhname(){
		return fhname;
	}
	public String getTelphone(){
		return telphone;
	}
	public String getMail(){
		return mail;
	}
	public String getPass(){
		return pass;
	}
	public String getAddress(){
		return address;
	}
	public String getSex(){
		return sex;
	}
	public String getBirth(){
		return birth;
	}
}
