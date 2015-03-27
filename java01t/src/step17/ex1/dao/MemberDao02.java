package step17.ex1.dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import step17.ex1.domain.User;

// 데이터 저장과 읽기 관련 메서드 추가
// => User 인스턴스를 가지고 CSV 문자열을 만드는 코드를 User 클래스에 둔다.
// => CSV 문자열을 가지고 User 인스턴스를 만드는 코드를 User 클래스에 둔다.
// => 코드 개선 이점: 
//   MemberDao의 코드를 간결하게 유지한다.
//   User 정보를 다루는 코드는 User 클래스에 있는 것이 바람직하다. 유지보수에 좋다. 
public class MemberDao02 {
  ArrayList<User> users = new ArrayList<User>();
  
  // ArrayList에 보관된 정보를 파일로 출력한다.
  // => 파일 저장과 관련된 오류는 호출자에게 알려야 한다.
  public void save(File file) throws IOException {
    // 파일이 없으면 생성하고, 해당 파일이 있으면 기존 파일을 지우고 새로 만든다.
    FileWriter out = new FileWriter(file);
    
    for (User user : users) {
      out.write(user.toCSV() + "\n");
    }
    
    out.close();
  }
  
  // 파일에 저장된 데이터를 읽어, ArrayList에 보관한다.
  public void load(File file) throws IOException {
    StringBuffer buf = new StringBuffer();
    FileReader in = new FileReader(file);
    
    char[] temp = new char[1024];
    int len = 0;
    
    while ((len = in.read(temp)) != -1) {
      buf.append(temp, 0, len);
    }
    
    in.close();
    
    String data = buf.toString(); //buf : members.csv 파일 전체 내용일 들어 있음.
    String[] userList = data.split("\n"); // 줄 단위로 분리한다.

    for (String csvUserInfo : userList) { // 한 줄의 사용자 정보를 가져온다.
      // CSV 형식으로 된 문자열을 가지고 User 인스턴스를 생성한다.
      users.add(new User(csvUserInfo)); // User 인스턴스를 ArrayList에 추가한다.
    }
  }
  
  public void insert(final User user) {
    users.add(user);
  }

  public ArrayList<User> selectList() {
    return users;
  }

  public User select(int no) {
    return users.get(no);
  }

  public void delete(int no) {
    users.remove(no);
  }

  public void update(int no, User changedUser) {
    users.set(no,  changedUser);
  }

}











