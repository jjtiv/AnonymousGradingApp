plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.projectcmsc491"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.projectcmsc491"
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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {


    implementation("com.google.zxing:core:3.2.1")
    implementation("com.journeyapps:zxing-android-embedded:4.3.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.amplifyframework:core:1.6.2")
    implementation("com.amplifyframework:aws-datastore:2.16.0")
    implementation("com.amplifyframework:aws-auth-cognito:2.14.11")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.opencsv:opencsv:4.6")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs_nio:2.0.2")
}