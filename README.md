# PalindromeApp - Suitmedia Mobile Developer Intern Test

This is a submission for the **Magang Berdampak 2025 - Mobile Developer Intern** at **Suitmedia**. The application is built using **Android Native (Kotlin + XML)** following the provided specifications.

## 📲 APK Download

You can download and try the app from the following link:

👉 [Download APK](https://drive.google.com/drive/folders/1fFPD3F7SkrCq680gX8Q9PSMHkX2fe0mm?usp=sharing)

## 🌟 Key Advantages

- ✅ Supports **Dark Mode** and **Light Mode** automatically based on system theme.
- ✅ Clean MVVM architecture with modular structure.
- ✅ Responsive and user-friendly UI.
- ✅ Simple data passing between screens.
- ✅ Support responsive UI (Using Constraint and max-width).


## 📱 Features

### First Screen
- Two input fields:
  - Name input
  - Sentence input to check for palindrome
- Button **Check**: Displays a dialog stating whether the sentence is a palindrome.
- Button **Next**: Navigates to the second screen.
<p align="center">
  <img src="https://github.com/user-attachments/assets/dec1aaad-b1d5-4e89-ae4a-530073d6cd62" width="300" />
  <img src="https://github.com/user-attachments/assets/1d93d23c-e7c9-40ee-a8ca-3d59f113efd6" width="300" />
</p>




### Second Screen
- Displays a static "Welcome" label.
- Dynamically shows:
  - Name from the first screen
  - Selected user's name (from the third screen)
- Button **Choose a User** to navigate to the third screen.
<p align="center">
  <img src="https://github.com/user-attachments/assets/405a0eaf-6ff9-490a-9f61-1f9ae70a7133" width="300" />
  <img src="https://github.com/user-attachments/assets/d51abffd-208c-4c91-8925-8b55e07ff73d" width="300" />
</p>




### Third Screen
- Displays a paginated and refreshable list of users from [reqres.in](https://reqres.in/).
- Supports:
  - Pull to refresh
  - Infinite scrolling / pagination
  - Empty state if no data
- When a user is selected, their name is passed back and shown on the second screen.
<p align="center">
  <img src="https://github.com/user-attachments/assets/e3e98ba6-6d66-4121-b16b-71ae35e29456" width="300" />
  <img src="https://github.com/user-attachments/assets/cda054e3-7d07-4507-8f92-c071c39975c1" width="300" />
</p>


## 🎬 This is the demo in light mode
[Watch the demo video on Google Drive](https://drive.google.com/file/d/1oHw_9y3T-DSeIkIUx2PuHTFiZUBS1lQg/view?usp=drive_link)



## 🔧 Tech Stack

- Kotlin
- MVVM architecture
- Retrofit for networking
- Glide for image loading
- ViewModel + LiveData
- RecyclerView
- SwipeRefreshLayout

## 🧪 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/xturus138/PalindromeAppSuitmedia.git

2. Open the project in Android Studio (Use meerkat and above).

3. Build & Run:
   ```bash
   Minimum SDK: 21
   Target SDK: 34

4. Ensure an emulator or device is running (try using android 14)

##📃 License
This project is for recruitment test purposes only.

##📂 Folder Structure
   ```bash
  app/
  ├── manifests/
  │   └── AndroidManifest.xml
  ├── src/
  │   └── main/
  │       ├── kotlin/
  │       │   └── com/
  │       │       └── suitmedia/
  │       │           └── palindromeapp/
  │       │               ├── data/
  │       │               │   ├── model/           # Data models
  │       │               │   ├── repository/      # API handling
  │       │               │── di
  │       │               ├── ui/
  │       │               │   ├── firstScreen/     # First screen logic & UI
  │       │               │   ├── secondScreen/    # Second screen logic & UI
  │       │               │   └── thirdScreen/     # Third screen logic & UI (includes UserAdapter)
  │       │               └── MainActivity.kt      # Main Activity of the application
  │       └── res/
  │           ├── drawable/
  │           ├── font/
  │           ├── layout/
  │           ├── mipmap/
  │           ├── values/
  │           └── xml/



