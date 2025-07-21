# Honey App API Documentation

## Overview
The Honey app is a modular Android application built with Jetpack Compose that connects local honey producers with consumers.

## Architecture

### Module Structure
- **app**: Main application module
- **core**: Shared UI components, themes, and utilities
- **data**: Data layer with repositories and data sources
- **domain**: Business logic and use cases
- **feature-***: Feature-specific modules

### Key Features
- **Authentication**: User registration and login
- **Market**: Browse and search honey products
- **Orders**: Manage shopping cart and orders
- **Beekeeper**: Beekeeper-specific features
- **Profile**: User profile management

## Navigation
The app uses Jetpack Navigation Compose for screen navigation between features.

## Dependencies
- **Jetpack Compose**: UI framework
- **Navigation Compose**: Navigation
- **Room**: Local database
- **Coroutines**: Asynchronous programming
- **Material 3**: Design system

## Build Configuration
- **Minimum SDK**: 26 (Android 8.0)
- **Target SDK**: 34 (Android 14)
- **Kotlin**: 1.9.10
- **Compose Compiler**: 1.5.3 