@echo off

rem ------------------------
rem build picenter web app
rem ------------------------

set WORK_HOME=E:\workspace\HubGitSpace\mithri-mn\picenter\picweb
set TOMCAT_HOME=E:\programTools\apache\apache-tomcat-7.0.78

rem mvn clean install -Dmaven.test.skip=true

del /S/Q %TOMCAT_HOME%\logs\*
del /S/Q %TOMCAT_HOME%\temp\*
del /S/Q %TOMCAT_HOME%\work\*

del /S/Q %TOMCAT_HOME%\webapps\picweb.war
rd  /S/Q %TOMCAT_HOME%\webapps\picweb
:delend

copy %WORK_HOME%\target\picweb.war %TOMCAT_HOME%\webapps\

%TOMCAT_HOME%\bin\startup.bat

:allend