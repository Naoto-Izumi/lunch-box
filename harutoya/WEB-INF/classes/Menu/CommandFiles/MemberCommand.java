package Menu.CommandFiles;
import Main.AbstractCommand;
import Main.RequestContext;
import Main.ResponseContext;

public class MemberCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();

		resc.setTarget("member");

		return resc;
	}
}