# kotlin-device-intel

[![playstore](https://img.shields.io/badge/playstore-device--intel-brightgreen.svg?style=flat-square)](https://play.google.com/store/apps/details?id=io.pjhjohn.kotlin.deviceintel) [![minSdkVersion](https://img.shields.io/badge/minSdkVersion-21-blue.svg?style=flat-square)](#)

Simple Android Widget written in [**Kotlin**](https://kotlinlang.org/) in [**AndroidStudio**](https://developer.android.com/studio/index.html) for Multi-Device Testers to indicate Android Version and Device Name. This **README** will show step-by-step implementation following [**Official Kotlin Tutorials**](https://kotlinlang.org/docs/tutorials/kotlin-android.html) with proper references for anyone interested in Kotlin


### 1. [Install Kotlin Plugin](https://kotlinlang.org/docs/tutorials/kotlin-android.html#installing-the-kotlin-plugin) and [Create Java Android Project](https://kotlinlang.org/docs/tutorials/kotlin-android.html#creating-a-project) [`0626ddd`](https://github.com/pjhjohn/kotlin-device-intel/commit/0626ddd95c8a4283e01e8f3cdef87cf91f554f63)

1. In AndroidStudio, Go to **File > Settings > Plugins > Install JetBrains plugin…** and Search **Kotlin**

2. Install Plugin and Restart AndroidStudio

3. Go **File > New > New Project** and create new Java Android Project
  - Minimum SDK Version **21** for [Material Design](https://material.io/guidelines/)
  - No **AppCompat** to keep this project as simple as possible


### 2. [Convert Java Code to Kotlin, Configuring Project](https://kotlinlang.org/docs/tutorials/kotlin-android.html#configuring-kotlin-in-the-project) [`0cb47d3`](https://github.com/pjhjohn/kotlin-device-intel/commit/0cb47d3dd22782978093ab8b6cdafcca824a8865)

Open **MainActivity.java**, and follow steps below:

1. Go to **Help > Find Action** `⇧⌘A` and select **Convert Java File to Kotlin File `⌥⇧⌘K`**

2. This will try to convert **MainActivity.java** to **MainActivity.kt**

3. By adding **.kt** file, AndroidStudio will trigger **Configure Kotlin in Project** Action as well and will automatically generate code for Kotlin configuration in AndroidStudio

You can change Kotlin Version by editing `ext.kotlin_version` in `$PROJECT_ROOT/build.gradle`


### 3. Simple Dashboard in Activity using [Kotlin Android Extensions](https://kotlinlang.org/docs/tutorials/android-plugin.html) [`04695ae`](https://github.com/pjhjohn/kotlin-device-intel/commit/04695aedcc5d28c3bc1f30be14fc92324b0b63ef)

Since building an Android Widget directly in Kotlin is a bit overdo as a start, in-Activity implementation will be a good bridge for adaptation to Kotlin. View inflation and binding will be supported through Kotlin Android Extensions.

1. Configure Kotlin Android Extensions for View Binding

  In `build.gradle`, add plugin **kotlin-android-extensions** in addition to **kotlin-android** plugin

  ```groovy
  apply plugin: 'kotlin-android'
  apply plugin: 'kotlin-android-extensions'
  ```

  In **MainActivity.kt**, `import` layout widget properties

  ```kotlin
  import kotlinx.android.synthetic.main.<layout>.*
  ```

  Since `<layout>` references xml file under **src/main/res/layout**, views under `activity_main.xml` can be imported with following import statement:

  ```kotlin
  import kotlinx.android.synthetic.main.activity_main.*
  ```

2. You can easily set strings through value assign instead of old `.setText` function call

  ```xml
  <!-- For This TextView... -->
  <TextView android:id="@+id/device_sdk_version" ... />
  ```

  ```java
  /* Java */
  TextView textview = (TextView) this.findViewById(R.id.device_sdk_version);
  textview.setText("API " + Build.VERSION.SDK_INT);
  ```

  ```kotlin
  /* Kotlin */
  device_sdk_version.text = "API ${Build.VERSION.SDK_INT}"
  ```

**NOTE**

AndroidStudio Replaces `.` in Android Resource IDs with `_` for readability and convenience. However, Kotlin Android Extensions cannot recognize this. **You must concatenate words in `android:id` using `_` to avoid this issue**.


### 4. Implement DeviceIntel Widget [`95531bb`](https://github.com/pjhjohn/kotlin-device-intel/commit/95531bbaae84a17a6592f2e28de5a64cd9df5a32)

Since the purpose of this application is quite text-based, we recycle activity_main.xml for the widget as well. In this step, we setup widget configurations in `AndroidManifest.xml`.

**NOTE**

Kotlin always generates method stub with following body:

```kotlin
throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
```

However, this is quite not straightforward. For the time being, auto-generated method stub is better when creating with **java** and **Convert Java File to Kotlin File**.


### 5. Improve DeviceIntel Widget [`0ad09e9`](https://github.com/pjhjohn/kotlin-device-intel/commit/0ad09e98dc536b29907736df4055013f564ca622)

- Separate layout `deviceintel_widget.xml` from `activity_main.xml`
- Widget Preview Image for Widget Selection View
- Unified TextView Style with style defined in `styles.xml`
- Use `.capitalize()` instead of `.toUpperCase` for device brand string


### References

- [Getting Started with Android and Kotlin](https://kotlinlang.org/docs/tutorials/kotlin-android.html) : Official Kotlin Tutorial using AndroidStudio
- [Kotlin Koans](https://kotlinlang.org/docs/tutorials/koans.html) : Official Kotlin Exercises with failing UnitTest at first. Code to pass! You can play with [Koans Online](http://try.kotlinlang.org/#/Kotlin%20Koans/Introduction/Hello,%20world!/Task.kt) as well.


### Miscellaneous

- Mac Unicode Keys
  - `⌃` Control
  - `⌥` Option / Alt
  - `⌘` Command / Cmd
  - `⇧` Super / Shift
