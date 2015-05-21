[윈도우 터미널에서 그루비 실행환경 설정하기]
- 그루비로 만든 자바 클래스를 실행하기 전에 groovy.bat 파일을 실행하여
  자바 클래스 경로에 그루비 라이브러리 파일을 추가한다.
  
  
[맥 터미털에서 그루비 실행환경 설정하기]
- .bash_profile 파일에 다음의 환경 변수를 추가하고 터미널을 다시 실행한다.
- 물론 실제 경로는 사용자 환경에 따라 맞춘다.
예)
export GROOVY_HOME=/Users/eomjinyoung/bit/eclipse/plugins/org.codehaus.groovy_2.3.10.xx-201502281941-e44
export CLASSPATH=$GROOVY_HOME/lib/groovy-all-2.3.10.jar:$CLASSPATH
   
[Groovy 클래스 실행하기]
- Groovy 컴파일러가 생성한 .class 파일은 

windows: java -cp .\bin;%CLASSPATH% step01.Test01
unix: java -cp ./bin:$CLASSPATH step01.Test01







  
 