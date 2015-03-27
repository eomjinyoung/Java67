package step17.ex1.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import step17.ex1.domain.User;

// DataOutputStream/DataInputStream을 사용하여 데이터를 저장하고 읽기
public class MemberDao {
  ArrayList<User> users = new ArrayList<User>();
  
  // DataOutputStream 사용하여 사용자 정보를 바이너리 형식으로 출력한다.
  public void save(File file) throws IOException {
    DataOutputStream out = 
        new DataOutputStream(
            new BufferedOutputStream(
                new FileOutputStream(file)));
    
    // 사용자 정보를 출력하기 전에 사용자 수를 먼저 출력한다.
    out.writeInt(users.size());
    
    // ArrayList에 보관된 사용자 정보를 반복해서 출력한다.
    for (User user : users) {
      out.writeUTF(user.getName());
      out.writeUTF(user.getEmail());
      out.writeUTF(user.getTel());
      out.writeUTF(user.getHomepage());
      out.writeUTF(user.getTwitter());
    } 
    
    out.close();
  }
  
  // DataInputStream을 사용하여 바이너리 형식의 데이터를 읽어서, ArrayList에 보관한다.
  public void load(File file) throws IOException {
    DataInputStream in = 
        new DataInputStream(
            new BufferedInputStream(
                new FileInputStream(file)));

    // 첫 4바이트를 읽는다. 사용자 수.
    int len = in.readInt();
    
    User user = null;
    // 사용자 수만큼 반복하여 데이터를 읽는다. 
    for (int i = 0; i < len; i++) {
      user = new User();
      user.setName(in.readUTF());
      user.setEmail(in.readUTF());
      user.setTel(in.readUTF());
      user.setHomepage(in.readUTF());
      user.setTwitter(in.readUTF());
      
      users.add(user); // 파일로부터 읽은 한 명의 사용자 정보를 ArrayList에 보관한다.
    }
    
    in.close();
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











