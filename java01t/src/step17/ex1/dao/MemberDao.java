package step17.ex1.dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import step17.ex1.domain.User;

// 데이터 저장과 읽기 관련 메서드 추가
public class MemberDao {
  ArrayList<User> users = new ArrayList<User>();
  
  // ArrayList에 보관된 정보를 파일로 출력한다.
  // => 파일 저장과 관련된 오류는 호출자에게 알려야 한다.
  public void save(File file) throws IOException {
    // 파일이 없으면 생성하고, 해당 파일이 있으면 기존 파일을 지우고 새로 만든다.
    FileWriter out = new FileWriter(file);
    
    String csv = null;
    for (User user : users) {
      csv = user.getName() + "," + user.getEmail() + "," +
            user.getTel() + "," + user.getHomepage() + "," +
            user.getTwitter() + "\n";
      out.write(csv);
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
    
    System.out.println(buf);
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











