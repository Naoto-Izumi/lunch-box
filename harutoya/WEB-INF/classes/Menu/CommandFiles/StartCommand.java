package Menu.CommandFiles;
import Main.AbstractCommand;
import Main.RequestContext;
import Main.ResponseContext;

public class StartCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();

		resc.setTarget("menu/top");

		return resc;
	}
}