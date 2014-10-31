package test05.commands;

import java.util.ArrayList;
import java.util.Map;

import test06.Command;
import test06.Score;
import test06.ScoreDao;

public class AddCommand implements Command {

  @Override
  public String getCommandInfo() {
    return "add";
  }

  @Override
  public void service(Map<String, Object> params) throws Exception {
    ScoreDao scoreDao = (ScoreDao)params.get("scoreDao");
    
    @SuppressWarnings("unchecked")
    ArrayList<String> options = 
        (ArrayList<String>)params.get("options");
    
    Score score = new Score(options.get(0), 
        Integer.parseInt(options.get(1)), 
        Integer.parseInt(options.get(2)), 
        Integer.parseInt(options.get(3)));
    
    scoreDao.add(score);
    System.out.println("저장하였습니다.");
  }
}










