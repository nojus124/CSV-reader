
# Made by Nojus Petrauskas
# Using REACT, SPRING BOOT(GRADLE - GROOVY), H2
Reads data and imports it in H2 database, then every time you add something it stays in local server storage database.

# FrontEnd start:
```
npm install
npm start
```

# BackEnd server start

Make sure you have Java 17 jdk.
Be in main folder where build.gadle file is.
Open cmd.exe in that folder.

# To Run it.

Use command:
```
gradlew -Dorg.gradle.java.home="C:\\PATH\\TO\\jdk-17" bootRun
```

# To Build
```
gradlew -Dorg.gradle.java.home="C:\\PATH\\TO\\jdk-17" build
```
 Built program will be in build/libs.

# IMPORTANT !!!
```
CHANGE java 17 jdk PATH "C:\\PATH\\TO\\".
import file type .csv
```
![image](https://user-images.githubusercontent.com/46402646/213421780-39cfe62f-1be0-4b25-96ab-e3c9395ff7d2.png)
# Program example
![image](https://user-images.githubusercontent.com/46402646/213419337-488b6eb8-7439-4784-99b5-0ca12af26ba2.png)
