package Bean;

public class UserBox{
	private String lname;
	private String fname;
	private String lhname;
	private String fhname;
	private String telphone;
	private String mail;
	private String pass;
	private String address;
	private String sex;
	private String birth;
	
	/*public UserBox(String lname,String fname,String lhname,String fhname,String telphone,String mail,String pass,String address,String sex,String tableName){
		this.lname = lname;
		this.fname = fname;
		this.lhname = lhname;
		this.fhname = fhname;
		this.telphone = telphone;
		this.mail = mail;
		this.pass = pass;
		this.address = address;
		this.sex = sex;
		this.birth = birth;
		String query = "INSERT" +TableName;
	}*/
	
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
