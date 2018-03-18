FROM base_server:latest

SHELL ["powershell", "-Command", "$ErrorActionPreference = 'Stop'; $ProgressPreference = 'SilentlyContinue';"]

ADD https://bitbucket.org/ariya/phantomjs/downloads/phantomjs-1.9.7-windows.zip C:/SoftDesarrollo/SeleniumWebdriver/phantomjs-1_9_7-windows.zip 

ADD https://selenium-release.storage.googleapis.com/3.7/selenium-server-standalone-3.7.1.jar C:/selenium-server-standalone-3_7_1.jar 

RUN java -version

RUN Expand-Archive C:/SoftDesarrollo/SeleniumWebdriver/phantomjs-1_9_7-windows.zip  -DestinationPath C:/SoftDesarrollo/SeleniumWebdriver ;

RUN Get-Package

RUN Set-Location -Path C:/SoftDesarrollo/SeleniumWebdriver/phantomjs-1.9.7-windows/

EXPOSE 8083

ENTRYPOINT $hostname =  hostname ; \
	$ipV4 = Test-Connection -ComputerName $hostname -Count 1 | Select -ExpandProperty IPv4Address ; \
	$ip= $ipv4.IPAddressToString ; \
	$ip= $ip+":8083" ; \
	C:/SoftDesarrollo/SeleniumWebdriver/phantomjs-1.9.7-windows/phantomjs --webdriver=$ip --webdriver-selenium-grid-hub=http://192.168.43.247:4444

