object Config {
    const val applicationId = "com.zbistapp.translator"
    const val compileSdk = 31
    const val minSdk = 23
    const val targetSdk = 31
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {

    // Design
    const val appcompat = "1.4.0"
    const val material = "1.4.0"

    // Kotlin
    const val coreKtx = "1.7.0"
    const val coroutines = "1.5.2"

    // Retrofit
    const val retrofit = "2.9.0"
    const val retrofitCoroutinesAdapter = "0.9.2"

    // Koin
    const val koin = "3.1.3"

    // Room
    const val room = "2.3.0"

    // ViewBindingPropertyDelegate
    const val viewBindingPropertyDelegate = "1.5.0-beta01"

    // Test
    const val jUnit = "4.+"
    const val espressoCore = "3.4.0"
}

object Design {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
}

object Kotlin {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitCoroutinesAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutinesAdapter}"
}

object Koin {
    const val koin = "io.insert-koin:koin-core:${Versions.koin}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
    const val koinCompat = "io.insert-koin:koin-android-compat:${Versions.koin}"
}

object Room {
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
}

object ViewBindingPropertyDelegate {
    const val viewBindingPropertyDelegate =
        "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${Versions.viewBindingPropertyDelegate}"
}

object Testing {
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}