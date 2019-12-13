package Kanrisya.Lock;
import javax.servlet.http.HttpServletResponse;

public class WebResponseContext implements ResponseContext{
	
	/*フィールド*/
	private Object result;	//結果
	private String target;	//jspの場所
	
	//インターフェイスの実装クラスのインスタンスを格納
	private HttpServletResponse response;
	
	//コンストラクタ
	public WebResponseContext(){}		
	/*セッター・ゲッター*/
	public void setTarget(String transferInfo){
		
		//jspを決定する。
		target="WEB-INF/jsp/"+transferInfo+".jsp";	//サーブレットパスを取得
	}
	public String getTarget(){
		return target;
	}
	public void setResult(Object bean){
		result = bean;
	}
	public Object getResult(){
		return result;
	}
	public Object getResponse(){
		return response;
	}
	public void setResponse(Object obj){
		response = (HttpServletResponse)obj;
	}
}
