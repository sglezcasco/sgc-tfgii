# Run as ADMIN
#GeckoDriver
mkdir "C:/SoftDesarrollo/SeleniumWebdriver2"
Invoke-WebRequest "https://bitbucket.org/ariya/phantomjs/downloads/phantomjs-1.9.7-windows.zip" -OutFile "C:/SoftDesarrollo/SeleniumWebdriver2/phantomjs-1_9_7-windows.zip" ;
Expand-Archive "C:/SoftDesarrollo/SeleniumWebdriver2/phantomjs-1_9_7-windows.zip"  -DestinationPath "C:/SoftDesarrollo/SeleniumWebdriver2" ;  
