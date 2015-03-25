package step17.ex1.dao;

import java.util.ArrayList;

import step17.ex1.domain.User;

//자바 컬렉션 API 적용
//=> ArrayList를 사용하여 사용자 목록을 다룬다.
public class MemberDao {
  ArrayList<User> users = new ArrayList<User>();
  
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











