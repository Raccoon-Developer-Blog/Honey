Write-Host "Honey Android App Setup" -ForegroundColor Green
Write-Host "======================" -ForegroundColor Green

Write-Host ""
Write-Host "Checking Java installation..." -ForegroundColor Yellow
try {
    $javaVersion = java -version 2>&1
    Write-Host "Java found: $($javaVersion[0])" -ForegroundColor Green
} catch {
    Write-Host "ERROR: Java is not installed or not in PATH" -ForegroundColor Red
    Write-Host "Please install Java 8 or higher from https://adoptium.net/" -ForegroundColor Red
    Read-Host "Press Enter to exit"
    exit 1
}

Write-Host ""
Write-Host "Checking for JDK..." -ForegroundColor Yellow
try {
    $javacVersion = javac -version 2>&1
    Write-Host "JDK found: $javacVersion" -ForegroundColor Green
} catch {
    Write-Host "WARNING: JDK not found. Only JRE is installed." -ForegroundColor Yellow
    Write-Host "Please install JDK 8 or higher to compile the project." -ForegroundColor Yellow
    Write-Host "Download from: https://adoptium.net/" -ForegroundColor Yellow
    Write-Host ""
    Write-Host "After installing JDK, set JAVA_HOME environment variable:" -ForegroundColor Yellow
    Write-Host '$env:JAVA_HOME = "C:\Program Files\Java\jdk-8"' -ForegroundColor Cyan
    Read-Host "Press Enter to exit"
    exit 1
}

Write-Host ""
Write-Host "Java setup looks good!" -ForegroundColor Green
Write-Host ""
Write-Host "Building project..." -ForegroundColor Yellow

try {
    & .\gradlew clean build
    if ($LASTEXITCODE -eq 0) {
        Write-Host ""
        Write-Host "Build successful! You can now:" -ForegroundColor Green
        Write-Host "- Open the project in Android Studio" -ForegroundColor White
        Write-Host "- Run: gradlew installDebug (with device connected)" -ForegroundColor White
        Write-Host "- Run: gradlew assembleDebug (to create APK)" -ForegroundColor White
    } else {
        Write-Host ""
        Write-Host "Build failed. Check the error messages above." -ForegroundColor Red
    }
} catch {
    Write-Host ""
    Write-Host "Build failed with error: $($_.Exception.Message)" -ForegroundColor Red
}

Read-Host "Press Enter to exit" 