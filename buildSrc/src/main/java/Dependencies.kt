object ApplicationId {
    val id = "com.example.weatherapp"
}

object Modules {
    val app = ":app"
    val navigation = ":navigation"
    val common = ":common"
    val dataLocal = ":data:local"
    val dataRemote = ":data:remote"
    val dataModel = ":data:model"
    val dataRepository = ":data:repository"
    val featureHome = ":features:home"
    val featureDetail = ":features:detail"
    val featureCurrent = ":features:current"
}

object Releases {
    val versionCode = 1
    val versionName = "1.0"
}

object Versions {
    val kotlin = "1.4.20"
    val gradle = "4.2.1"
    val compileSdk = 30
    val minSdk = 21
    val targetSdk = 30
    val appCompat = "1.3.0"
    val coreKtx = "1.5.0"
    val constraintLayout = "2.0.4"
    //test
    val junit = "4.12"
    val androidTestRunner = "1.1.2-alpha02"
    val espressoCore = "3.2.0-alpha02"
    //retrofit
    val retrofit = "2.5.0"
    val retrofitCoroutines = "0.9.2"
    val retrofitGson = "2.4.0"
    val gson = "2.8.5"
    val okHttp = "3.12.1"

    val coroutines = "1.1.1"
    val koin = "1.0.2"
    val timber = "4.7.1"
    val lifecycle = "2.2.0"
    val nav = "2.3.5"
    val room = "2.4.0-alpha02"
    val recyclerview = "1.0.0"
    val safeArgs = "2.3.5"
    val glide = "4.9.0"
    val mockwebserver = "2.7.5"
    val archCoreTest = "2.0.0"
    val androidJunit = "1.1.0"
    val mockk = "1.9.2"
    val fragmentTest = "1.1.0-alpha06"
    val databinding = "3.3.2"
}

object Libraries {
    // KOIN
    val koin = "org.koin:koin-android:${Versions.koin}"
    val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"
    // ROOM
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    val roomRunTime = "androidx.room:room-runtime:${Versions.room}"
    val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    // RETROFIT
    val retrofitCoroutineAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutines}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
    val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    // GLIDE
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    //Dagger - Hilt

    val hilt = "com.google.dagger:hilt-android:2.28.3-alpha"
    val hiltAndroidCompiler= "com.google.dagger:hilt-android-compiler:2.28.3-alpha"
    val hiltViewmodel= "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02"
    val hiltCompiler= "androidx.hilt:hilt-compiler:1.0.0-alpha02"

    val retrofitAdapterRxJava2 = "com.squareup.retrofit2:adapter-rxjava2:2.9.0"
    val myRxJava2 = "io.reactivex.rxjava2:rxjava:2.2.19"
    val myRxJava2ToRx3 = "com.github.akarnokd:rxjava3-bridge:3.0.0"
    val myRxJava2IoReactive = "io.reactivex.rxjava2:rxandroid:2.1.1"

}

object KotlinLibraries {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val kotlinCoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}

object AndroidLibraries {
    // KOTLIN
    val kotlinCoroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    // ANDROID
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"
    val navigationFrag = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
}
const val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.21"

const val okHttp = "com.squareup.okhttp3:okhttp:$4.7.2"

const val appStartUp = "androidx.startup:startup-runtime:1.0.0"

object LeakCanary {
    private const val version = "2.4"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:$version"
    const val plumber = "com.squareup.leakcanary:plumber-android:$version"
}

object Coroutines {
    internal const val coroutineVersion = "1.4.2"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion"
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion"
}

object Glide {
    private const val glideVersion = "4.11.0"
    const val core = "com.github.bumptech.glide:glide:$glideVersion"
    const val compiler = "com.github.bumptech.glide:compiler:$glideVersion"
    const val recyclerView = "com.github.bumptech.glide:recyclerview-integration:$glideVersion"

}

object AndroidX {
    const val appCompat = "androidx.appcompat:appcompat:1.2.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"

    object Ktx {
        const val core = "androidx.core:core-ktx:1.3.2"
        const val fragment = "androidx.fragment:fragment-ktx:$1.2.5"
        const val activity = "androidx.activity:activity-ktx:1.1.0"
    }

    object LifeCycle {
        private const val lifeCycleVersion = "2.2.0"
        const val runtime =  "androidx.lifecycle:lifecycle-runtime-ktx:$lifeCycleVersion"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$lifeCycleVersion"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifeCycleVersion"
        const val test = "androidx.arch.core:core-testing:$lifeCycleVersion"
    }

    object Room {
        internal const val version = "2.2.6"

        const val core = "androidx.room:room-runtime:$version"
        const val processor = "androidx.room:room-compiler:$version"
        const val ktx = "androidx.room:room-ktx:$version"

    }

    object Navigation {
        internal const val version = "2.3.2"

        const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
        const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
        const val dynamicFeature =
            "androidx.navigation:navigation-dynamic-features-fragment:$version"
    }

    object WorkManager {
        internal const val version = "2.4.0"

        const val coreKtx = "androidx.work:work-runtime-ktx:$version"
    }
}

object Dagger {
    private const val daggerVersion = "2.30.1"
    const val core = "com.google.dagger:dagger:$daggerVersion"
    const val compiler = "com.google.dagger:dagger-compiler:$daggerVersion"

    object Hilt {
        private const val jetPackVersion = "1.0.0-alpha02"
        private const val version = "2.31-alpha"

        const val android = "com.google.dagger:hilt-android:$version"
        const val core = "com.google.dagger:hilt-core:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:$version"
        const val jetPack = "androidx.hilt:hilt-lifecycle-viewmodel:$jetPackVersion"
        const val jetPackCompiler = "androidx.hilt:hilt-compiler:$jetPackVersion"
    }
}

object Stetho {
    private const val stethoVersion = "1.5.1"
    const val stetho = "com.facebook.stetho:stetho:$stethoVersion"
    const val stethoOk = "com.facebook.stetho:stetho-okhttp3:$stethoVersion"
}

object Retrofit {
    private const val retrofitVersion = "2.9.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
    const val rxAdapter = "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion"
}

object Moshi {
    private const val moshiVersion = "1.9.3"
    const val core = "com.squareup.moshi:moshi:$moshiVersion"
    const val codeGen = "com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion"
}
object TestLibraries {
    // ANDROID TEST
    val androidTestRunner = "androidx.test:runner:${Versions.androidTestRunner}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espressoCore}"
    val archCoreTest = "androidx.arch.core:core-testing:${Versions.archCoreTest}"
    val junit = "androidx.test.ext:junit:${Versions.androidJunit}"
    val fragmentNav = "androidx.fragment:fragment-testing:${Versions.fragmentTest}"
    // KOIN
    val koin = "org.koin:koin-test:${Versions.koin}"
    // MOCK WEBSERVER
    val mockWebServer = "com.squareup.okhttp:mockwebserver:${Versions.mockwebserver}"
    // MOCK
    val mockkAndroid = "io.mockk:mockk-android:${Versions.mockk}"
    val mockk = "io.mockk:mockk:${Versions.mockk}"
    // COROUTINE
    val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    // DATA BINDING
    val databinding = "androidx.databinding:databinding-compiler:${Versions.databinding}"
}




const val stdlibJdk82 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.21"

const val okHttp2 = "com.squareup.okhttp3:okhttp:$4.7.2"

const val appStartUp2 = "androidx.startup:startup-runtime:1.0.0"

object LeakCanary2 {
    private const val version = "2.4"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:$version"
    const val plumber = "com.squareup.leakcanary:plumber-android:$version"
}

object Coroutines2 {
    internal const val coroutineVersion = "1.4.2"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion"
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion"
}

object Glide2 {
    private const val glideVersion = "4.11.0"
    const val core = "com.github.bumptech.glide:glide:$glideVersion"
    const val compiler = "com.github.bumptech.glide:compiler:$glideVersion"
    const val recyclerView = "com.github.bumptech.glide:recyclerview-integration:$glideVersion"

}

object AndroidX2 {
    const val appCompat = "androidx.appcompat:appcompat:1.2.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"

    object Ktx {
        const val core = "androidx.core:core-ktx:1.3.2"
        const val fragment = "androidx.fragment:fragment-ktx:$1.2.5"
        const val activity = "androidx.activity:activity-ktx:1.1.0"
    }

    object LifeCycle {
        private const val lifeCycleVersion = "2.2.0"
        const val runtime =  "androidx.lifecycle:lifecycle-runtime-ktx:$lifeCycleVersion"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$lifeCycleVersion"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifeCycleVersion"
        const val test = "androidx.arch.core:core-testing:$lifeCycleVersion"
    }

    object Room {
        internal const val version = "2.2.6"

        const val core = "androidx.room:room-runtime:$version"
        const val processor = "androidx.room:room-compiler:$version"
        const val ktx = "androidx.room:room-ktx:$version"

    }

    object Navigation {
        internal const val version = "2.3.2"

        const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
        const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
        const val dynamicFeature =
            "androidx.navigation:navigation-dynamic-features-fragment:$version"
    }

    object WorkManager {
        internal const val version = "2.4.0"

        const val coreKtx = "androidx.work:work-runtime-ktx:$version"
    }
}

object DaggerN {
    private const val daggerVersion = "2.30.1"
    const val core = "com.google.dagger:dagger:$daggerVersion"
    const val compiler = "com.google.dagger:dagger-compiler:$daggerVersion"

    object Hilt {
        private const val jetPackVersion = "1.0.0-alpha02"
        private const val version = "2.31-alpha"

        const val android = "com.google.dagger:hilt-android:$version"
        const val core = "com.google.dagger:hilt-core:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:$version"
        const val jetPack = "androidx.hilt:hilt-lifecycle-viewmodel:$jetPackVersion"
        const val jetPackCompiler = "androidx.hilt:hilt-compiler:$jetPackVersion"
    }
}

object Stetho2 {
    private const val stethoVersion = "1.5.1"
    const val stetho = "com.facebook.stetho:stetho:$stethoVersion"
    const val stethoOk = "com.facebook.stetho:stetho-okhttp3:$stethoVersion"
}

object Retrofit2 {
    private const val retrofitVersion = "2.9.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
    const val rxAdapter = "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion"
}

object Moshi2 {
    private const val moshiVersion = "1.9.3"
    const val core = "com.squareup.moshi:moshi:$moshiVersion"
    const val codeGen = "com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion"
}