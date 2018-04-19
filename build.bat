@echo off

rem ------------------------
rem build web app
rem ------------------------

set PIC_HOME=.\picenter\picweb
set AI_HOME=.\aicenter\aiweb

echo %CATALINA_HOME%

del /S/Q %CATALINA_HOME%\logs\*
del /S/Q %CATALINA_HOME%\temp\*
del /S/Q %CATALINA_HOME%\work\*

del /S/Q %CATALINA_HOME%\webapps\picweb.war
rd  /S/Q %CATALINA_HOME%\webapps\picweb
:delend

copy %PIC_HOME%\target\picweb.war %CATALINA_HOME%\webapps\
copy %AI_HOME%\target\aiweb.war %CATALINA_HOME%\webapps\

%CATALINA_HOME%\bin\startup.bat

:allend