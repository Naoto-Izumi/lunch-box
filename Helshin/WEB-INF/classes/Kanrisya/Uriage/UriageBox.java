package Kanrisya.Uriage;

public class UriageBox{
	private String year;	//年
	private String month;	//月
	private String count;	//カウント数
	private String name;	//商品名
	
	/*ゲッター*/
	public String getYear(){
		return year;
	}
	public String getMonth(){
		return month;
	}
	public String getCount(){
		return count;
	}
	public String getName(){
		return name;
	}
	
	/*セッター*/
	public void setName(String name){
		this.name = name;
	}
	public void setYear(String year){
		this.year = year;
	}
	public void setCount(String count){
		this.count = count;
	}
	public void setMonth(String month){
		this.month = month;
	}
}
