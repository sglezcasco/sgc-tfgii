# Run as ADMIN

#ChromeDriver

mkdir "C:/SoftDesarrollo/SeleniumWebdriver"
Invoke-WebRequest "chromedriver.storage.googleapis.com/2.33/chromedriver_win32.zip" -OutFile "C:/SoftDesarrollo/SeleniumWebdriver/chromedriver_win32.zip" ;
Expand-Archive "C:/SoftDesarrollo/SeleniumWebdriver/chromedriver_win32.zip"  -DestinationPath "C:/SoftDesarrollo/SeleniumWebdriver" ;  

#Chrome
Invoke-WebRequest "http://dl.google.com/chrome/install/375.126/chrome_installer.exe"  -OutFile "C:/SoftDesarrollo/chrome_installer.exe" 

# Start the installation
Start-Process -FilePath "C:/SoftDesarrollo/chrome_installer.exe"  -Args "/silent /install" -Wait; 