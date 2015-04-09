package step21.ex3;

import step21.ex3.Category;

// 실습 목표: 이너 클래스를 이용하여 상수 값을 정의한 작은 클래스 관리
// 
public class Test2 {

  public static void main(String[] args) {
    int 분류 = Category.beauty.RING;
    int 분류2 = Category.movie.EROTIC;
    int 분류3 = Category.book.FICTION;
    int 분류4 = Category.electronic.tv.samsung.STVQHD;

  }

}
