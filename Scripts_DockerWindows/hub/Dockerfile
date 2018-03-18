FROM base_server:latest

SHELL ["powershell", "-Command", "$ErrorActionPreference = 'Stop'; $ProgressPreference = 'SilentlyContinue';"]

RUN Invoke-WebRequest $('https://selenium-release.storage.googleapis.com/3.7/selenium-server-standalone-3.7.1.jar') -OutFile 'C:/selenium-server-standalone-3_7_1.jar' -UseBasicParsing ; 

RUN java -version

RUN cd C:/

RUN dir 

EXPOSE 4444

ENTRYPOINT java -jar c:\\selenium-server-standalone-3_7_1.jar -role hub -port 4444
