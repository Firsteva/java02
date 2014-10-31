package test07.commands;

import java.util.Map;

import test07.Command;
import test07.ScoreDao;
import test07.annotation.Component;

@Component("exit")
public class ExitCommand implements Command {

  @Override
  public String getCommandInfo() {
    return "exit";
  }

  @Override
  public void service(Map<String, Object> params) throws Exception {
    try {
      ScoreDao scoreDao = (ScoreDao)params.get("scoreDao");
      scoreDao.save();
    } catch (Exception e) {
      System.out.println("데이터 저장 중 오류가 발생했습니다.");
    }
  }
}










