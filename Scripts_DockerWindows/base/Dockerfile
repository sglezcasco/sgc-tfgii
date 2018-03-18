FROM microsoft/windowsservercore:latest

SHELL ["powershell", "-Command", "$ErrorActionPreference = 'Stop'; $ProgressPreference = 'SilentlyContinue';"]

ENV JAVA_VERSION 8.27.0.7-jdk8.0.162
ENV JAVA_HOME C:\\zulu${JAVA_VERSION}-win_x64

RUN Invoke-WebRequest $('https://cdn.azul.com/zulu/bin/zulu{0}-win_x64.zip' -f $env:JAVA_VERSION) -OutFile 'openjdk.zip' -UseBasicParsing ; \
    Expand-Archive C:\openjdk.zip  -DestinationPath C:\ ; \
    $env:PATH = '{0}\bin;{1}' -f $env:JAVA_HOME, $env:PATH ; \
    Set-ItemProperty -Path 'HKLM:\SYSTEM\CurrentControlSet\Control\Session Manager\Environment\' -Name Path -Value $env:PATH ; 
	