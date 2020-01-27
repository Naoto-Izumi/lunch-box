package Bean;

import java.io.Serializable;

public class CustomBentoBean implements Serializable{
	

	private String _syusyoku;
	private String _syusai;
	private String _huku1;
	private String _huku2;
	

	public CustomBentoBean(){
		//引数のないコンストラクタ
	}
	
	public void setSyusyoku(String syusyoku){
		_syusyoku=syusyoku;
	}
	public String getSyusyoku(){
		return _syusyoku;
	}

	public void setSyusai(String syusai){
		_syusai=syusai;
	}
	
	public String getSyusai(){
		return _syusai;
	}
	
	public void setHuku1(String huku1){
		_huku1=huku1;
	}
	
	public String getHuku1(){
		return _huku1;
	}

	public void setHuku2(String huku2){
		_huku2=huku2;
	}
	
	public String getHuku2(){
		return _huku2;
	}

	
}