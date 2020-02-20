package Menu.CommandFiles;
import Main.AbstractCommand;
import Main.RequestContext;
import Main.ResponseContext;

public class NetOrderCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();

		resc.setTarget("menu/NetOrder");

		return resc;
	}
}