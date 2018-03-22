# Run as ADMIN
$JAVA_VERSION="8.27.0.7-jdk8.0.162"
echo $JAVA_VERSION
$JAVA_HOME="C:\\zulu${JAVA_VERSION}-win_x64"
echo $JAVA_HOME

#Download and unzip JAVA
Invoke-WebRequest "https://cdn.azul.com/zulu/bin/zulu$JAVA_VERSION-win_x64.zip"  -OutFile "C:\SoftDesarrollo\openjdk.zip" -UseBasicParsing  
Expand-Archive C:\SoftDesarrollo\openjdk.zip  -DestinationPath C:\SoftDesarrollo ; 

$PATH = "$JAVA_HOME\bin;$PATH" ; 
echo $PATH ;

#PATHS
$oldPath=(Get-ItemProperty -Path 'Registry::HKEY_LOCAL_MACHINE\System\CurrentControlSet\Control\Session Manager\Environment' -Name PATH).Path
echo $oldPath;
$newPath=$oldPath+’;'+$PATH
echo $newPath;
Set-ItemProperty -Path 'Registry::HKEY_LOCAL_MACHINE\System\CurrentControlSet\Control\Session Manager\Environment' -Name PATH –Value $newPath 

# TO verify java -version (needs exit session)