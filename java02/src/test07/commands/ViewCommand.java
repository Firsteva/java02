package test07.commands;

import java.util.ArrayList;
import java.util.Map;

import test07.Command;
import test07.Score;
import test07.ScoreDao;
import test07.annotation.Component;

@Component("view")
public class ViewCommand implements Command {

  @Override
  public String getCommandInfo() {
    return "view";
  }

  @Override
  public void service(Map<String, Object> params) throws Exception {
    ScoreDao scoreDao = (ScoreDao)params.get("scoreDao");
    
    @SuppressWarnings("unchecked")
    ArrayList<String> options = 
        (ArrayList<String>)params.get("options");
    
    int index = Integer.parseInt(options.get(0));
    
    Score score = scoreDao.getData(index);
    if (score == null) {
      System.out.println("해당 인덱스의 성적 정보를 찾을 수 없습니다.");
      return;
    }
    
    System.out.println("인덱스: " + index);
    System.out.println("이름: " + score.getName());
    System.out.println("국어: " + score.getKor());
    System.out.println("영어: " + score.getEng());
    System.out.println("수학: " + score.getMath());
    System.out.println("총점: " + score.getSum());
    System.out.println("평균: " + score.getAverage());
  }
}










