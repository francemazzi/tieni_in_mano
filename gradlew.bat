@echo off
set v=9.5.1
set d=%USERPROFILE%\.gradle\wrapper\dists\gradle-%v%-bin
set g=%d%\gradle-%v%\bin\gradle.bat
if not exist "%g%" powershell -NoProfile -ExecutionPolicy Bypass -Command "New-Item -ItemType Directory -Force '%d%' | Out-Null; Invoke-WebRequest 'https://services.gradle.org/distributions/gradle-%v%-bin.zip' -OutFile '%d%.zip'; Expand-Archive -Force '%d%.zip' '%d%'"
"%g%" %*
