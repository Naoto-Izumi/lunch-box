package User.CommandFiles;

import java.util.List;
import Main.ApplicationController;
import Main.RequestContext;
import Main.ResponseContext;
import java.util.Map;
import Main.AbstractCommand;

import User.Beans.UserBox;
import User.JDBCFiles.UserData;

public class RegistUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		resc.setTarget("user/registuser");
		
		return resc;
	}
}