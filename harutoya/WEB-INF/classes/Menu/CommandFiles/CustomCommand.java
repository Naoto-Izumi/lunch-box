package Menu.CommandFiles;

import java.io.IOException;

import Main.AbstractCommand;
import Main.RequestContext;
import Main.ResponseContext;
import javax.servlet.http.HttpSession;
import java.util.*;

import Menu.JDBCFiles.MenuDao;

public class CustomCommand extends AbstractCommand{
public ResponseContext execute(ResponseContext resc){
        RequestContext reqc = getRequestContext();

		resc.setTarget("menu/custom");
		
		return resc;

	}
}