[그래들 프로젝트 준비]
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
- 1) 빌드에 사용할 도구(플러그인)를 임포트 한다.
  apply "plugin": "플러그인이름"
  
- 2) 주요 플러그인 
  java          : 자바 관련 빌드 함수를 갖고 있다. 
  eclipse       : 이클립스 관련 파일을 생성하고 삭제하는 함수를 갖고 있다.
  war           : war 파일을 생성하는데 필요한 함수를 갖고 있다.
  eclipse-wtp   : 웹 애플리케이션 설정 파일을 생성하고 삭제하는 함수를 갖고 있다.
                  eclipse 플러그인을 포함한다.
                  

















