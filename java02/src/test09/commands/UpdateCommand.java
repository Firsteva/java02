package test09.commands;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import test09.Command;
import test09.Score;
import test09.ScoreDao;
import test09.annotation.Component;

@Component("update")
public class UpdateCommand implements Command {
	
	ScoreDao scoreDao;
	Scanner scanner;

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

  public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}

  @Override
  public String getCommandInfo() {
    return "update";
  }

  @Override
  public void service(Map<String, Object> params) throws Exception {
    
    @SuppressWarnings("unchecked")
    ArrayList<String> options = 
        (ArrayList<String>)params.get("options");
    
    int index = Integer.parseInt(options.get(0));
    Score score = scoreDao.getData(index);
    if (score == null) {
      System.out.println("해당 인덱스의 성적 정보를 찾을 수 없습니다.");
      return;
    }
    
    Score tempScore = score.clone();
    
    String text = null;
    System.out.printf("이름(%s):", score.getName());
    text = scanner.nextLine();
    if (text.length() > 0)
      tempScore.setName(text);
    
    System.out.printf("국어(%d):", score.getKor());
    text = scanner.nextLine();
    if (text.length() > 0)
      tempScore.setKor(Integer.parseInt(text));
    
    System.out.printf("영어(%d):", score.getEng());
    text = scanner.nextLine();
    if (text.length() > 0)
      tempScore.setEng(Integer.parseInt(text)); 
    
    System.out.printf("수학(%d):", score.getMath());
    text = scanner.nextLine();
    if (text.length() > 0)
      tempScore.setMath(Integer.parseInt(text));
    
    System.out.print("정말 변경하시겠습니까?(y/n)");
    if (scanner.nextLine().equalsIgnoreCase("y")) {
      scoreDao.change(index, tempScore);
      System.out.println("변경하였습니다.");
    } else {
      System.out.println("변경 취소하였습니다.");
    }
  }
}










