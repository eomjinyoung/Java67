package step03

/* 실습 목표: 리스트와 맵 다루기 */

scores = [100, 90, 80, 70]    // ArrayList 객체를 생성한다.
println scores[2]  // 값을 꺼낼 때는 배열처럼 꺼내면 된다.
println scores.get(2)  // 자바 문법으로 명확히 값을 꺼낼 수 있다.
println scores.size()
println scores.getClass()

names = [] // 빈 리스트 생성하기
names[0] = "홍길동"
println names[0]

names.add("우헤헤")
println names[1]
println "---------------------------------------"

// 맵 다루기
scoreMap = ["kor": 100, "eng": 80, "math": 60]
scoreMap["sci"] = 70
scoreMap.soc = 90

println scoreMap["kor"]
println scoreMap.eng
println scoreMap.get("math")
println scoreMap.sci
println scoreMap["soc"]
println scoreMap.getClass()

// 빈 맵 만들기
emptyMap = [:]






