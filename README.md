## Welcome to the Android JetPack learning

## Technologies Used

 - Kotlin Programming Language
 - Androidx archifects
 - Material design guidlines
 - ConstraintLayout
 
 ## Architectual Components
 
  - MVVM code pattern
  - Model View with live data API
 
 ```
     implementation 'androidx.lifecycle:lifecycle-extensions:2.1.0'
 ```
 
 ## Dependancy Injection
 
 For batter inversion of control and acheive batter testing, Dagger 2 is ussed for dependacy injection.
 
```
    implementation 'com.google.dagger:dagger:2.16'
    kapt 'com.google.dagger:dagger-compiler:2.16'
    implementation 'com.google.dagger:dagger-android:2.16'
    implementation 'com.google.dagger:dagger-android-support:2.16'
    kapt 'com.google.dagger:dagger-android-processor:2.16'
```

## Network libraries

```
    implementation 'com.squareup.retrofit2:retrofit:2.6.2'
    implementation 'com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
    implementation "com.squareup.okhttp3:logging-interceptor:3.12.2"
    implementation 'com.google.code.gson:gson:2.8.5'

```

## Reactive Paradigm

```
    implementation 'io.reactivex:rxkotlin:1.0.0'
    implementation 'io.reactivex.rxjava2:rxandroid:2.1.0'
```    

## Unit test

```
    // test dependencies
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test:runner:1.2.0'
    testImplementation "android.arch.core:core-testing:1.1.1"
    // Mockito
    testImplementation 'com.nhaarman.mockitokotlin2:mockito-kotlin:2.0.0-RC3'
    testImplementation 'org.mockito:mockito-inline:2.8.47'
```    
    
