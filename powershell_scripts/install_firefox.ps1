# Run as ADMIN

#GeckoDriver
mkdir "C:/SoftDesarrollo/SeleniumWebdriver"
Invoke-WebRequest "https://github.com/mozilla/geckodriver/releases/download/v0.19.0/geckodriver-v0.19.0-win64.zip" -OutFile "C:/SoftDesarrollo/SeleniumWebdriver/geckodriver-v0_19_0-win64.zip" ;
Expand-Archive "C:/SoftDesarrollo/SeleniumWebdriver/geckodriver-v0.19.0-win64.zip"  -DestinationPath "C:/SoftDesarrollo/SeleniumWebdriver" ;  

#Firefox 57
Invoke-WebRequest "https://ftp.mozilla.org/pub/firefox/releases/57.0/win64/es-ES/Firefox%20Setup%2057.0.exe"  -OutFile "C:/SoftDesarrollo/FirefoxSetup_57_0.exe" -UseBasicParsing  

# Start the installation
Start-Process -FilePath "C:/SoftDesarrollo/FirefoxSetup_57_0.exe" -ArgumentList "/S" -Wait; 


