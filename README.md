If using tomcat 10.x you have two options:
- checkout to jakarta-update branch -> imports changed from javax to jakarta
- stay on this branch and change the output folder in the pom. You have to create, in the tomcat root folder, a folder named [webapps-java](https://tomcat.apache.org/migration-10.html) and change the output folder of the build, setting this folder instead of "webapps"
