1. write code
2. build using command: mvn clean install -DskipTests
3. copy .war file from target to webapps directory of tomcat. (always clean webapps directory before moving war file)
4. start the server from bin/ using command: catalina.bat run
5. keep repeat same from step 1 whenever you have code change