package test06.commands;

import java.util.ArrayList;
import java.util.Map;

import test06.Command;

public class TestCommand implements Command {

  @Override
  public String getCommandInfo() {
    return "test";
  }

  @Override
  public void service(Map<String, Object> params) throws Exception {
    @SuppressWarnings("unchecked")
    ArrayList<String> options = 
        (ArrayList<String>)params.get("options");
    
    String name = options.get(0);
    System.out.println(name + "님 안녕하셨어요?");
  }
}










