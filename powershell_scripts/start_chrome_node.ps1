# Run as ADMIN
java -version
cd C:\SoftDesarrollo\powershell_scripts
java '-Dwebdriver.chrome.driver=C:\\SoftDesarrollo\\SeleniumWebdriver\\chromedriver.exe' -jar C:\\SoftDesarrollo\\SeleniumGrid\selenium-server-standalone-3.7.1.jar -role node -hub http://192.168.43.247:4444/grid/register -browser "browserName=chrome,platform=WINDOWS,maxInstances=1"
