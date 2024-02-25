plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.mvvm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mvvm"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //by viewModels()
    implementation("androidx.fragment:fragment-ktx:1.1.0")
    //ViewModels delegation extentensions for activity
    implementation("androidx.activity:activity-ktx:1.3.1")

    //room
    implementation("androidx.room:room-runtime:2.5.0")
    ksp("androidx.room:room-compiler:2.5.0")
    implementation("androidx.room:room-rxjava3:2.5.0")

    //RxAndroid 3
    implementation("io.reactivex.rxjava3:rxandroid:3.0.2")
    implementation("io.reactivex.rxjava3:rxjava:3.1.5")

    //hilt
    implementation("com.google.dagger:hilt-android:2.44")
    ksp("com.google.dagger:hilt-android-compiler:2.44")

    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01")
    ksp("androidx.hilt:hilt-compiler:1.0.0-alpha01")

    //viewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")

    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0-rc01")
    annotationProcessor("androidx.lifecycle:lifecycle-compiler:2.2.0-rc01")
}