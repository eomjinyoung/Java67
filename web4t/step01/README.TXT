[1단계: 그래들 프로젝트 준비]
1. 기본 구조로 폴더를 생성한다.
src / main
            / java        : 자바 소스 파일
            / resources   : xml, properties, txt 등의 일반 파일
            / webapp      : 웹 컨텐츠 관련 파일을 둔다. WebContent 폴더와 같은 역할.
            
    / test
            / java        : 단위 테스트(JUnit)를 위한 자바 소스 파일
            / resources   : 단위 테스트를 수행하는데 필요한 일반 파일
            
2. Gradle 플러그인을 사용할 수 있도록 프로젝트 설정
- 프로젝트에서 Gradle 플러그인의 도구를 사용하려면, .project의 <nature> 정보를 선언해야 한다.
- 구글에서 검색하여, Gradle 관련 nature 태그를 추가하라!
  검색어: eclipse gradle nature
<nature>org.springsource.ide.eclipse.gradle.core.nature</nature>
- nature?
  => 프로젝트에서 사용해야 하는 플러그인을 지정하는 태그이다.
         
3. gradle 설정 파일 생성
- build.gradle 설정 파일을 생성한다.
1) 빌드에 사용할 도구(플러그인)를 임포트 한다.
  apply "plugin": "플러그인이름"
  
2) 주요 플러그인 
  java          : 자바 관련 빌드 함수를 갖고 있다. 
  eclipse       : 이클립스 관련 파일을 생성하고 삭제하는 함수를 갖고 있다.
  war           : war 파일을 생성하는데 필요한 함수를 갖고 있다.
  eclipse-wtp   : 웹 애플리케이션 설정 파일을 생성하고 삭제하는 함수를 갖고 있다.
                  eclipse 플러그인을 포함한다.
4. Gradle 설정
1) 이클립스 관련 파일 생성하기
- .project 파일 
    이미 존재. 
    자바 관련 플러그인을 사용하도록 설정 정보를 추가해야 한다.
- .classpath
    존재하지 않는다.
    새로 생성해야 한다.
- .settings 폴더
    자바 프로그래밍 관련 설정 정보를 추가해야 한다.
- 방법?
    Gradle Build에서 이클립스 관련 파일을 생성하라고 명령을 내린다.
- Gradle 명령
    eclipseXXX 명령 : 이클립스 설정 파일 생성
    cleanEclipseXXX 명령 : 이클립스 설정 파일 제거
    
- Gradle 파일에 eclipse 플러그인을 추가한다.
    apply plugin: "eclipse"
    apply plugin: "java"

2) 자바 빌드 명령
- compileJava
  /src/main/java 폴더의 소스를 컴파일하여 
  /build/classes/main 폴더에 컴파일된 .class 파일을 놓는다.
  
- compileTestJava
  /src/test/java 폴더의 소스를 컴파일하여
  /build/classes/test 폴더에 컴파일된 .class 파일을 놓는다.      
                       
- processResources
  /src/main/resources ---> /build/resources/main

- processTestResources
  /src/test/resources ---> /build/resources/test
  
- clean
  /build 폴더를 삭제한다.

- classes
  compileJava, processResources 작업을 수행한다.

- testClasses
  classes, compileTestJava, processTestResources 작업을 수행한다.

- build
  자바 관련 모든 작업을 수행한다.
  작업 내용은 콘솔 창의 출력 내용을 확인하라!
  

5 웹 애플리케이션 빌드
1) 웹 애플리케이션 빌드 명령을 가져온다.
  apply plugin:"war"
  apply plugin:"eclipse-wtp" ---> "eclipse" 플러그인을 포함한다.
  
2) 이클립스 웹 애프리케이션 설정 파일을 추가해야 한다.
  clean   --> 기본의 build 폴더 삭제
  eclispe --> 이클립스 관련 모든 설정 파일 생성
              eclipse-wtp와 war 플러그인을 추가했기 때문에
              웹 애플리케이션 설정 파일도 함께 생성된다.
  build   --> 컴파일  

3) compileJava 관련 설정 추가
- build.gradle 파일에 다음 설정 메서드 호출한다.
  compileJava {...}

4) WTP Facet 관련 설정 변경
- build.gradle 파일에 다음 설정 메서드 호출한다.
  eclipse {
    wtp {
      facet {
        ...
      }
    }
  }

6. web3 프로젝트 소스를 web4로 옮긴다.
- 특히 dao 패키지에 있는 xml 파일은 resources 폴더로 옮겨라!

7. 의존 라이브러리 가져오기
- 의존 라이브러리를 가져올 서버를 지정한다.
  repositories {...}
- 라이브러리 지정
  dependencies {...}
  
8. 서버 실행 테스트  











