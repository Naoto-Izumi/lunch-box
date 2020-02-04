package Kanrisya.CommandFiles;

import java.util.Map;
import Kanrisya.ResponseContext;
import Kanrisya.AbstractCommand;

public class InputStoreCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
	
		resc.setTarget("kanrisya/product");	//jspを転送
		
		return resc;
	}
}

