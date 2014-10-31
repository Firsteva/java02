package test07.commands;

import java.util.Map;

import test07.Command;
import test07.annotation.Component;

@Component("hello")
public class HelloCommand implements Command {

	@Override
	public String getCommandInfo() {
		return null;
	}
	@Override
	public void service(Map<String, Object> params) throws Exception {

	}

}
