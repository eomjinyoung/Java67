package step25;

/* 애노테이션 사용: 배열 속성 값 지정하기
 * 
 */

// 중괄호({})를 사용하여 배열 값을 설정한다.
/*
@MyAnnotation3(
    subjects={"국어","영어","수학"}, 
    scores={100,90,100})
*/

// 배열의 항목이 한 개일 때는 중괄호({})를 안 붙여도 된다.
//@MyAnnotation3(subjects={"국어"},scores={100}) //기본은 한 개라도 중괄호를 붙여야 한다.
@MyAnnotation3(subjects="국어",scores=100) // 한 개일 때 중괄호 생략가능.
public class MyObject3 {

}
















