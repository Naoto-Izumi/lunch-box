package Kanrisya.Lock.CommandFiles;

import Kanrisya.Lock.Main.RequestContext;
import Kanrisya.Lock.Main.ResponseContext;

public abstract class AbstractCommand{
	//RequestContextを格納するインスタンス変数
	private RequestContext reqContext;
	
	//もともとはセッターです。
	public void init(RequestContext reqc){
		reqContext = reqc;
	}
	public RequestContext getRequestContext(){
		return reqContext;
	}
	
	//具象クラスにResponseContext型のexecute()メソッドをオーバーライドする。
	public abstract ResponseContext execute(ResponseContext resc);
}
