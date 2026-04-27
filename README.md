# DictionaryApp

DictionaryApp is an Android dictionary application built with Kotlin and Java-based Android tooling. It searches word meanings, falls back to slang definitions when needed, supports translation, stores search history locally, and includes text-to-speech playback.

## Features

- Search English word definitions through DictionaryAPI
- Fallback slang lookup through Urban Dictionary
- Translation fallback through LibreTranslate
- Language selector for English, Hindi, French, Spanish, and German
- Text-to-speech support for searched words
- Local search history stored with Room
- Dedicated history screen with a RecyclerView adapter
- MVVM-style separation with repository, ViewModel, network, database, and UI layers
- ViewBinding-enabled Android UI

## Tech Stack

- Kotlin
- Android SDK
- AndroidX AppCompat and Material Components
- Retrofit and Gson
- Room database
- Lifecycle ViewModel and LiveData
- TextToSpeech API

## Project Structure

```text
app/src/main/java/com/example/dictionaryapp/
  data/model/              API response models
  data/repository/         Dictionary, slang, and translation lookup logic
  database/                Room database, DAO, and history entity
  network/                 Retrofit API interfaces and clients
  ui/                      Main and history screens
  utils/                   Language detection and text-to-speech helpers
  viewmodel/               Search ViewModel

app/src/main/res/
  layout/                  Main, history, and list item layouts
  drawable/                App icon assets
  values/                  Colors, strings, and themes
```

## Getting Started

1. Open the project in Android Studio.
2. Let Gradle sync the project dependencies.
3. Select an emulator or Android device running API 24 or newer.
4. Run the `app` configuration.

## Build from the Command Line

On Windows:

```powershell
.\gradlew.bat assembleDebug
```

On macOS or Linux:

```bash
./gradlew assembleDebug
```

The debug APK is generated under:

```text
app/build/outputs/apk/debug/
```

## External APIs

- DictionaryAPI: `https://api.dictionaryapi.dev/`
- Urban Dictionary API: `https://api.urbandictionary.com/`
- LibreTranslate: `https://libretranslate.de/`

## License

This repository is licensed under the GPL-3.0 license. See `LICENSE` for details.
