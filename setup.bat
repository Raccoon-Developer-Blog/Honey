@echo off
echo Honey Android App Setup
echo ======================

echo.
echo Checking Java installation...
java -version
if %errorlevel% neq 0 (
    echo ERROR: Java is not installed or not in PATH
    echo Please install Java 8 or higher from https://adoptium.net/
    pause
    exit /b 1
)

echo.
echo Checking for JDK...
javac -version
if %errorlevel% neq 0 (
    echo WARNING: JDK not found. Only JRE is installed.
    echo Please install JDK 8 or higher to compile the project.
    echo Download from: https://adoptium.net/
    echo.
    echo After installing JDK, set JAVA_HOME environment variable:
    echo set JAVA_HOME=C:\Program Files\Java\jdk-8
    pause
    exit /b 1
)

echo.
echo Java setup looks good!
echo.
echo Building project...
call gradlew clean build

if %errorlevel% equ 0 (
    echo.
    echo Build successful! You can now:
    echo - Open the project in Android Studio
    echo - Run: gradlew installDebug (with device connected)
    echo - Run: gradlew assembleDebug (to create APK)
) else (
    echo.
    echo Build failed. Check the error messages above.
)

pause 