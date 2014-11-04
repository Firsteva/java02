package test09.commands;

import java.util.Map;

import test09.Command;
import test09.Score;
import test09.ScoreDao;
import test09.annotation.Component;

@Component("list")
public class ListCommand implements Command {
	
	ScoreDao scoreDao;

  public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}

	@Override
  public String getCommandInfo() {
    return "list";
  }

  @Override
  public void service(Map<String, Object> params) throws Exception {
  	// 이 메서드가 호출되기 전에 ScoreDao 의존 객체가 저장될 것이기 때문에
  	// 다음 코드는 제거한다.
    // ScoreDao scoreDao = (ScoreDao)params.get("scoreDao");
    int index = 0;
    for (Score score : scoreDao.getList()) {
      System.out.printf("%-3d %-10s %3d %3d %3d\n", 
          index, score.getName(), score.getKor(), 
          score.getEng(), score.getMath());
      index++;
    }
  }
}










