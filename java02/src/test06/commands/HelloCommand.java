package test06.commands;

import java.util.Map;

import test06.Command;

public class HelloCommand implements Command {

	@Override
	public String getCommandInfo() {
		return null;
	}
	@Override
	public void service(Map<String, Object> params) throws Exception {

	}

}
