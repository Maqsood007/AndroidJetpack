**Create New Project With AndroidX support**

Android Studio 3.3 has built in feature to create a new project with Androidx libraries support.


1 - Start a new Android Studio Project.

2 - Select an Empty Activity or what ever a template you want.

3 - In the bottom of **Configure your Project** screen, Check the option **Use AndroidX artifacts**.

4 - Click **Finish**

5 - This will add these two lines of code to your

**android.useAndroidX=true**

**android.enableJetifier=true**


**Manulay configure existing project with Androidx libraries support**

1 - Just add these two lines of code to your **gradle.properties**

**android.useAndroidX=true**

**android.enableJetifier=true**

2 - Go to refractor and Click Convert to AndroidX

If you have any Maven dependencies that have not been migrated to the AndroidX namespace, the Android Studio build system also migrates those dependencies for you when you set the following two flags to true in your gradle.properties file:

To migrate an existing project that does not use any third-party libraries with dependencies that need converting, you can set the android.useAndroidX flag to true and the android.enableJetifier flag to false.

https://developer.android.com/jetpack/androidx/migrate
