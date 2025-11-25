plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.plugin)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp) // <-- Add this line

    // id("kotlin-kapt") // For Kotlin. Replace with id("com.google.devtools.ksp") if using KSP
    //alias(libs.plugins.ksp)
}

android {
    namespace = "me.rohinee.todo"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "me.rohinee.todo"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.runtime)
    implementation(libs.material) // Add this line

    implementation(libs.androidx.material3)
    implementation(libs.androidx.foundation.layout)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.compiler)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.hilt.navigation.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

// Core Hilt dependencies
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler) // Or ksp(libs.hilt.compiler) if using KSP

    // For instrumentation tests
    androidTestImplementation(libs.hilt.android.testing)
    kspAndroidTest(libs.hilt.compiler) // Or kspTest(libs.hilt.compiler) if using KSP

    // For local unit tests
    testImplementation(libs.hilt.android.testing)
    kspTest(libs.hilt.compiler) // Or kspTest(libs.hilt.compiler) if using KSP

    implementation(libs.retrofit)
    implementation(libs.converter.gson)


    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
   // ksp(libs.androidx.room.compiler)



    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler) // Use ksp instead of kapt
// for annotation processing
    implementation(libs.hilt.android)
   // ksp(libs.hilt.compiler) // Use ksp instead of kapt
}
