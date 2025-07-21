# Quick Start Guide

## 🚀 Get Started in 3 Steps

### 1. Install JDK 8 or Higher
**Download from:** https://adoptium.net/temurin/releases/

Choose:
- **Version**: 8, 11, or 17 (LTS recommended)
- **Operating System**: Windows
- **Architecture**: x64
- **Package Type**: JDK

### 2. Set JAVA_HOME
After installation, set the environment variable:

**PowerShell:**
```powershell
$env:JAVA_HOME = "C:\Program Files\Eclipse Adoptium\jdk-8.0.392.8-hotspot"
```

**Command Prompt:**
```cmd
set JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-8.0.392.8-hotspot
```

**Note:** Adjust the path to match your actual JDK installation location.

### 3. Build the Project
```bash
# Run setup verification
setup.bat

# Or build directly
gradlew clean build
```

## ✅ Verification
Run these commands to verify your setup:
```bash
java -version    # Should show Java 8+
javac -version   # Should show Java compiler
gradlew --version # Should show Gradle 7.6.3
```

## 🛠️ Build Commands
```bash
build.bat clean    # Clean project
build.bat build    # Build project
build.bat debug    # Create debug APK
build.bat install  # Install on device
```

## 📱 Running the App
1. Connect Android device with USB debugging enabled
2. Run: `build.bat install`
3. Or open in Android Studio and click "Run"

## 🔧 Troubleshooting
- **"No Java compiler found"**: Install JDK (not just JRE)
- **"JAVA_HOME not set"**: Set the environment variable
- **Build fails**: Run `gradlew clean` first
- **Device not found**: Enable USB debugging in Developer Options

## 📁 Project Structure
```
honey/
├── app/                    # Main app module
├── gradle/                 # Gradle wrapper
├── build.bat              # Build script
├── setup.bat              # Setup script
├── README.md              # Detailed documentation
└── CONFIGURATION.md       # Configuration details
``` 