package Main.CommandFiles;

import java.util.Map;
import Main.ResponseContext;
import Main.AbstractCommand;

public class StartTopCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
	
		resc.setTarget("test");	//jspを転送
		
		return resc;
	}
}
