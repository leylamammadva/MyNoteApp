# MyNoteApp
MyNoteApp is a clean and modular Android note-taking application built using **Kotlin** and follows the **MVVM architecture pattern**. It allows users to create, update, view, and delete notes with a user-friendly interface.

## Features
- Create and save new notes
- Edit and delete existing notes
- List all notes using RecyclerView
- Navigate between fragments using Navigation Component
- Modular codebase with separation of concerns

## Architecture
This app uses the **MVVM (Model-View-ViewModel)** pattern with the following layers:

- **Model**: Data classes and Room database
- **ViewModel**: Manages UI-related data in a lifecycle-conscious way
- **View (Fragments/Activity)**: Displays data to users and handles UI events
- **Repository**: Abstracts access to multiple data sources

## 🧩 Tech Stack

- **Kotlin**
- **Room** (for local database)
- **LiveData** and **ViewModel** (for lifecycle-aware data handling)
- **Navigation Component**
- **RecyclerView**
- **Jetpack Architecture Components**

