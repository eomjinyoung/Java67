package step01;

public class Test04ex1 {

  public static void main(String[] args) {
    //1) 책 정보에 대한 자료형을 정의하라! 자료형 이름은 "Book"
    //자료형에 들어갈 항목은: 페이지수, 너비, 높이, 출판년도 
    class Book {
      short page;
      short width;
      short height;
      short year;
    }
    
    //2) 메모리를 준비하여, 다음 두 권의 책 정보를 저장하라.
    //- 200페이지, 20cm, 30cm, 2015년
    //- 800페이지, 25cm, 37cm, 2014년
    Book b1 = new Book();
    Book b2 = new Book();
    
    b1.page = 200;
    b1.width = 20;
    b1.height = 30;
    b1.year = 2015;
    
    b2.page = 800;
    b2.width = 25;
    b2.height = 37;
    b2.year = 2014;
        
    //3) 첫번째 책의 정보를 출력하라!
    System.out.println(b1.page);
    System.out.println(b1.width);
    System.out.println(b1.height);
    System.out.println(b1.year);
  }

}








