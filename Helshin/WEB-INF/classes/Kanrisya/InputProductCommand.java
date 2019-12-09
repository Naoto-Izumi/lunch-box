package Kanrisya;
import java.util.Map;

public class InputProductCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
	
		resc.setTarget("kanrisya/kanrisya");
		
		return resc;
	}
}

