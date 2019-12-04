package Kanrisya;
import java.util.Map;

public abstract class AbstractCommand{
	private Map parameters;
	private Object result;
	public void init(Map parameters){
		this.parameters = parameters;
	}
	public Object getResult(){
		return result;
	}
	public void setResult(Object data){
		this.result = data;
	}
	public Map getParameters(){
		return parameters;
	}
	public abstract String execute();	//AddProductCommandクラスやInputProductCommandクラスやGetProductsCommandクラスに継承する。
}
