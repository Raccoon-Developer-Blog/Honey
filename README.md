# 🍯 Honey - Local Honey & Beekeeper Discovery App

A modern Android application built with Jetpack Compose that connects users with local honey producers and beekeepers. Discover authentic, locally-sourced honey products and support your local beekeeping community.

## 🚀 Features

- **Guest Exploration**: Browse honey products without creating an account
- **User Authentication**: Secure sign-in and sign-up functionality
- **Local Discovery**: Find honey and beekeepers in your area
- **Order Management**: Place and track honey orders
- **Beekeeper Profiles**: Connect directly with local beekeepers
- **User Profiles**: Manage your account and preferences
- **Offer Details**: Tap any honey offer to see full details and pre-order
- **Pre-Order Flow**: Specify quantity, delivery method, and comment for pre-ordering honey

## 🏗️ Architecture

This project follows a **modular architecture** pattern with clean separation of concerns:

```
Honey/
├── app/                           # Main application module
├── modules/
│   ├── core/                      # Shared UI components, themes, utilities
│   ├── data/                      # Data layer, repositories, local storage
│   ├── domain/                    # Business logic, use cases, entities
│   ├── feature-auth/              # Authentication feature
│   ├── feature-market/            # Market/browsing feature
│   ├── feature-order/             # Order management & pre-order feature
│   ├── feature-beekeeper/         # Beekeeper profiles feature
│   └── feature-profile/           # User profile feature
└── docs/                          # Project documentation
```

## 🛠️ Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM with Clean Architecture
- **Dependency Injection**: Hilt
- **Database**: Room
- **Navigation**: Navigation Compose
- **Build System**: Gradle (Kotlin DSL)
- **Minimum SDK**: API 26 (Android 8.0)
- **Target SDK**: API 34 (Android 14)

## 📱 Screenshots & Navigation Flow

- **StartScreen**: Welcome, explore as guest, sign in/up
- **HomeScreen**: Map/List tabs, tap any offer to see details
- **OfferDetailScreen**: Full details, favorite, pre-order button
- **PreOrderScreen**: Enter quantity, delivery method, comment, confirm order

### Navigation Example
```
StartScreen
  └─(Explore as Guest)→ HomeScreen
      └─(Tap Offer)→ OfferDetailScreen
          └─(Pre-order)→ PreOrderScreen
```

## 🚀 Getting Started

### Prerequisites
- Android Studio Hedgehog (2023.1.1) or later
- JDK 17 or later
- Android SDK API 34
- Git

### Installation
1. **Clone the repository**
   ```bash
   git clone git@github.com:Raccoon-Developer-Blog/Honey.git
   cd Honey
   ```
2. **Open in Android Studio**
   - Open Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned Honey directory
   - Click "OK"
3. **Sync and Build**
   - Wait for Gradle sync to complete
   - Build the project: `Build > Make Project`
   - Run on device/emulator: `Run > Run 'app'`

### Build Commands
```bash
# Clean build
./gradlew clean
# Build debug APK
./gradlew assembleDebug
# Build release APK
./gradlew assembleRelease
# Run tests
./gradlew test
# Run instrumented tests
./gradlew connectedAndroidTest
```

## 🎨 UI/UX Design

- **Honey Theme**: Warm honey tones (#7A5F35, #A6D785)
- **Material 3**: Modern Material Design components
- **Custom Typography**: Optimized for readability
- **Responsive Layout**: Adapts to different screen sizes
- **Accessibility**: WCAG compliant design

## 📦 Dependencies

- **AndroidX Core**: 1.12.0
- **Compose BOM**: 2024.02.00
- **Compose Compiler**: 1.5.8
- **Navigation Compose**: 2.7.7
- **Hilt**: 2.50
- **Room**: 2.6.1
- **Gradle**: 9.0-milestone-1
- **Android Gradle Plugin**: 8.4.0
- **Kotlin**: 1.9.10

## 🧪 Testing

- **Unit Tests**: JUnit 4 for business logic
- **UI Tests**: Compose testing for UI components
- **Integration Tests**: End-to-end testing

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📞 Support

For support and questions:
- Create an issue on GitHub
- Contact the development team
- Check the documentation in the `docs/` folder

## 🗺️ Roadmap

- [ ] User authentication implementation
- [ ] Market browsing functionality
- [ ] Order management system
- [ ] Beekeeper profile features
- [ ] User profile management
- [ ] Push notifications
- [ ] Offline support
- [ ] Payment integration

## 🙏 Acknowledgments

- Local beekeeping communities
- Android development community
- Jetpack Compose team
- Material Design team

---

**Made with ❤️ by the Honey Development Team** 