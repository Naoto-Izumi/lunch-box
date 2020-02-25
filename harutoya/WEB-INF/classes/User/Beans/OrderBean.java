package User.Beans;

public class OrderBean{
	private String odate;
	private String sproid;
	private String scount;
	private String pid;

	public void setOdate(String odate){
		this.odate = odate;
	}
	public void setSproid(String sproid){
		this.sproid = sproid;
	}
	public void setScount(String scount){
		this.scount = scount;
	}
	public void setPid(String pid){
		this.pid = pid;
	}

	public String getOdate(){
		return odate;
	}
	public String getSproid(){
		return sproid;
	}
	public String getScount(){
		return scount;
	}
	public String getPid(){
		return pid;
	}

}
