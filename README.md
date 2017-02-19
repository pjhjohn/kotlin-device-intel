# kotlin-android-widget

Simple Android Widget written in [**Kotlin**](https://kotlinlang.org/) in [**AndroidStudio**](https://developer.android.com/studio/index.html) for Multi-Device Testers to indicate Android Version and Device Name.  
This **README** will show step-by-step implementation following [**Official Kotlin Tutorials**](https://kotlinlang.org/docs/tutorials/kotlin-android.html) with proper references for anyone interested in Kotlin


### 1. [Install Kotlin Plugin](https://kotlinlang.org/docs/tutorials/kotlin-android.html#installing-the-kotlin-plugin) and [Create Java Android Project](https://kotlinlang.org/docs/tutorials/kotlin-android.html#creating-a-project)

1. In AndroidStudio, Go to **File > Settings > Plugins > Install JetBrains plugin…** and Search **Kotlin**

2. Install Plugin and Restart AndroidStudio

3. Go **File > New > New Project** and create new Java Android Project
  - Minimum SDK Version **21** for [Material Design](https://material.io/guidelines/)
  - No **AppCompat** to keep this project as simple as possible


### 2. [Convert Java Code to Kotlin, Configuring Project](https://kotlinlang.org/docs/tutorials/kotlin-android.html#configuring-kotlin-in-the-project)

Open **MainActivity.java**, and follow steps below:

1. Go to **Help > Find Action** `⇧⌘A` and select **Convert Java File to Kotlin File `⌥⇧⌘K`**

2. This will try to convert **MainActivity.java** to **MainActivity.kt**

3. By adding **.kt** file, AndroidStudio will trigger **Configure Kotlin in Project** Action as well and will automatically generate code for Kotlin configuration in AndroidStudio

You can change Kotlin Version by editing `ext.kotlin_version` in `$PROJECT_ROOT/build.gradle`


### Application Specification

- `minSdkVersion 21` for [Material Design](https://material.io/guidelines/) as default design set


### Miscellaneous

- Mac Unicode Keys
  - `⌃` Control
  - `⌥` Option / Alt
  - `⌘` Command / Cmd
  - `⇧` Super / Shift
