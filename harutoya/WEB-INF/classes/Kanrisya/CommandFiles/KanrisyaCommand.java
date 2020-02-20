package Kanrisya.CommandFiles;

import java.util.Map;
import Main.ResponseContext;
import Main.AbstractCommand;

public class KanrisyaCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
	
		resc.setTarget("kanrisya/user");	//jspを転送
		
		return resc;
	}
}

