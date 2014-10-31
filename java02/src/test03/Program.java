package test03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Score implements Serializable {
  private static final long serialVersionUID = 1L;
  String name;
  int kor;
  int eng;
  int math;

  Score() {};

  Score(String n, int k, int e, int m) {
    name = n;
    kor = k;
    eng = e;
    math = m;   
  }
}

public class Program {
  static ArrayList<Score> list;
  static Scanner scanner = new Scanner(System.in);

  public static void help() {
    System.out
        .print("list\nview 인덱스\nadd 이름 국어 영어 수학\ndelete 인덱스\nupdate 인덱스\nexit\n");
  }

  public static void list() {

    for (int i = 0; i < list.size(); i++) {
      Score temp = list.get(i);
      System.out.println(i + " " + temp.name + " " + temp.kor + " " + temp.eng
          + " " + temp.math);
    }
  }

  public static void add(String name, String kor, String eng, String math) {
    System.out.println("저장되었습니다.");
    list.add(new Score(name, Integer.parseInt(kor), Integer.parseInt(eng),
        Integer.parseInt(math)));
  }

  public static void delete(String no) {
    int index = Integer.parseInt(no);

    if (index >= list.size()) {
      System.out.println("존재하지 않는 인덱스입니다.");
    } else {
      System.out.print(list.get(index).name + "의 성적을 삭제하시겠습니까?(y/n) ");
      String msg = scanner.nextLine();
      if (msg.equalsIgnoreCase("y")) {
        list.remove(index);
        System.out.println("삭제하였습니다.");
      } else if (msg.equalsIgnoreCase("n")) {
        System.out.println("삭제 취소하였습니다.");
      }
    }
  }

  public static void view(String no) {
    Score temp = list.get(Integer.parseInt(no));
    System.out.println("인덱스 : " + no);
    System.out.println("이름 : " + temp.name);
    System.out.println("국어 : " + temp.kor);
    System.out.println("영어 : " + temp.eng);
    System.out.println("수학 : " + temp.math);
    System.out.println("합계 : " + temp.kor + temp.eng + temp.math);
    System.out.println("평균 : " + (temp.kor + temp.eng + temp.math) / 3);
  }

  public static void update(String no) {
    Score temp = list.get(Integer.parseInt(no));
    String name, kor, eng, math;

    System.out.print("이름(" + temp.name + ")? ");
    name = scanner.nextLine();

    System.out.print("국어(" + temp.kor + ")? ");
    kor = scanner.nextLine();

    System.out.print("영어(" + temp.eng + ")? ");
    eng = scanner.nextLine();

    System.out.print("수학(" + temp.math + ")? ");
    math = scanner.nextLine();

    System.out.print("정말 변경하시겠습니까?(y/n) ");
    String msg = scanner.nextLine();

    if (msg.equalsIgnoreCase("n")) {
      System.out.println("변경 취소하였습니다.");
    } else if (msg.equalsIgnoreCase("y")) {
      if (!name.equals(""))
        temp.name = name;
      if (!kor.equals(""))
        temp.kor = Integer.parseInt(kor);
      if (!eng.equals(""))
        temp.eng = Integer.parseInt(eng);
      if (!math.equals(""))
        temp.math = Integer.parseInt(math);
     
      System.out.println("변경하였습니다.");
    }
  }

  public static void exit() throws IOException {
    FileOutputStream out = new FileOutputStream("score.dat");
    ObjectOutputStream out2 = new ObjectOutputStream(out);

    out2.writeObject(list);

    out2.close();
    out.close();

    System.exit(0);
  }

  public static void main(String[] args) throws IOException,
      ClassNotFoundException {
    try {
      list = new ArrayList<Score>();
      File in3 = new File("Score.dat");

      if (in3.isFile()) {
        FileInputStream in = new FileInputStream("Score.dat");
        ObjectInputStream in2 = new ObjectInputStream(in);

        list = (ArrayList<Score>) in2.readObject();
        
        in2.close();
        in.close();        
      }

      while (true) {
        System.out.print("명령> ");
        String order = scanner.nextLine();
        String[] temp = order.split(" ");

        switch (temp[0]) {
        case "help":
          help();
          break;
        case "list":
          list();
          break;
        case "view":
          view(temp[1]);
          break;
        case "add":
          add(temp[1], temp[2], temp[3], temp[4]);
          break;
        case "delete":
          delete(temp[1]);
          break;
        case "update":
          update(temp[1]);
          break;
        case "exit":
          exit();
        }
      }
    } catch (IOException ex) {
    } catch (ArrayIndexOutOfBoundsException ex) {
    	System.out.println("명령이 올바르지 않습니다.");
    }
  }
}