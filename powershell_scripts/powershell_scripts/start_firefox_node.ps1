# Run as ADMIN
java -version
cd C:\Users\sergiog\Desktop\powershell_scripts
java '-Dwebdriver.gecko.driver=C:\\SoftDesarrollo\\SeleniumWebdriver\\geckodriver.exe' -jar C:\\SoftDesarrollo\\SeleniumGrid\selenium-server-standalone-3.7.1.jar -role node -hub http://192.168.43.247:4444/grid/register -browser "browserName=firefox,platform=WINDOWS,maxInstances=1"
