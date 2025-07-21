@echo off
echo Honey Android Build Script
echo ========================

if "%1"=="clean" (
    echo Cleaning project...
    call gradlew clean
    goto :end
)

if "%1"=="build" (
    echo Building project...
    call gradlew build
    goto :end
)

if "%1"=="debug" (
    echo Building debug APK...
    call gradlew assembleDebug
    goto :end
)

if "%1"=="release" (
    echo Building release APK...
    call gradlew assembleRelease
    goto :end
)

if "%1"=="install" (
    echo Installing debug APK...
    call gradlew installDebug
    goto :end
)

if "%1"=="test" (
    echo Running tests...
    call gradlew test
    goto :end
)

echo Usage: build.bat [clean^|build^|debug^|release^|install^|test]
echo.
echo Commands:
echo   clean   - Clean the project
echo   build   - Build the project
echo   debug   - Build debug APK
echo   release - Build release APK
echo   install - Install debug APK on device
echo   test    - Run unit tests

:end
pause 