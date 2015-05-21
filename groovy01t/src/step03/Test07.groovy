package step03

/* 실습 목표: 문자열 다루기 */

println "홍길동"
println '홍길동'
println "gradle은 'groovy'를 사용합니다."
println "gradle은 \"groovy\"를 사용합니다."
println 'gradle은 "groovy"를 사용합니다.'
println 'gradle은 \'groovy\'를 사용합니다.'
println (/ "groovy"는 'gradle'의 설정파일을 작성하는 전용언어로 사용된다./)

// 여러 줄의 문자열 표현
def s1 = """오호라...
야... 되는데?
헐...
"""
println s1

def s2 = '''오호라...
야... 되는데?
헐...
'''
println s2
println "-------------------------------------"
// 문자열 안에 변수의 값을 넣기 ==> GString
def hello = { name ->
  println "안녕하세요. ${name}님! 반갑습니다."
  println "안녕하세요. $name 님! 반갑습니다."
  println "안녕하세요. \$name 님! 반갑습니다."
}
hello "홍길동"
























