
// gradle plugin versions are in gradle.properties

def year = 21
def major = 3
def minor = 0

// android project properties

ext.androidProjectProperties = [
        minSdk     : 23,
        targetSdk  : 29,
        compileSdk : 29,
        buildTools : '29.0.2',
        versionName: "$year.$major.$minor",
        versionCode: (year * 10000) + (major * 100) + minor
]


// modules dependencies

def deps = [:]
ext.deps = deps

deps.android = [
        desugaring: "com.android.tools:desugar_jdk_libs:1.0.9"
]

deps.jetbrains = [
        kotlinStdlibJdk7: "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVer",
        kotlinReflect   : "org.jetbrains.kotlin:kotlin-reflect:$kotlinVer"
]

deps.androidx = [
        legacySupport   : "androidx.legacy:legacy-support-v13:1.0.0",
        recyclerview    : "androidx.recyclerview:recyclerview:1.1.0",
        cardview        : "androidx.cardview:cardview:1.0.0",
        coreKtx         : "androidx.core:core-ktx:1.3.2",
        material        : "com.google.android.material:material:1.2.1",
        constraintlayout: "androidx.constraintlayout:constraintlayout:2.0.2",
        appcompat       : "androidx.appcompat:appcompat:1.2.0",
        viewpager2      : "androidx.viewpager2:viewpager2:1.0.0",
        testRunner      : "androidx.test:runner:1.3.0",
        testRules       : "androidx.test:rules:1.3.0",
        roomRuntime     : "androidx.room:room-runtime:2.2.5",
        roomCompiler    : "androidx.room:room-compiler:2.2.5"
]

def camerax_version = "1.0.0-rc02"

deps.camerax = [
        core      : "androidx.camera:camera-core:${camerax_version}",
        camera2   : "androidx.camera:camera-camera2:${camerax_version}",
        lifecycle : "androidx.camera:camera-lifecycle:${camerax_version}",
        view      : "androidx.camera:camera-view:1.0.0-alpha21",
        extensions: "androidx.camera:camera-extensions:1.0.0-alpha21"
]

deps.junit = [
        junit: "junit:junit:4.13.1"
]

deps.mockk = [
        mockk: "io.mockk:mockk:1.10.2"
]


deps.dagger = [
        dagger        : "com.google.dagger:dagger:2.29.1",
        daggerCompiler: "com.google.dagger:dagger-compiler:2.29.1"
]

deps.glassfish = [
        javaxAnnotation: "org.glassfish:javax.annotation:10.0-b28"
]

deps.rx = [
        rxkotlin : "io.reactivex.rxjava2:rxkotlin:2.4.0",
        rxandroid: "io.reactivex.rxjava2:rxandroid:2.1.1",
        rxbinding: "com.jakewharton.rxbinding2:rxbinding-appcompat-v7-kotlin:2.2.0"
]

deps.terrakok = [
        cicerone: "com.github.terrakok:cicerone:7.0"
]

deps.glide = [
        glideTransformations    : "jp.wasabeef:glide-transformations:4.3.0",
        glide                   : "com.github.bumptech.glide:glide:4.11.0",
        recyclerviewIintegration: "com.github.bumptech.glide:recyclerview-integration:4.11.0",
        compiler                : "com.github.bumptech.glide:compiler:4.11.0"
]

deps.okhttp3 = [
        okhttp3           : "com.squareup.okhttp3:okhttp:4.10.0-RC1",
        loggingInterceptor: "com.squareup.okhttp3:logging-interceptor:4.10.0-RC1"
]

deps.gson = [
        gson: "com.google.code.gson:gson:2.8.6"
]

deps.retrofit = [
        retrofit      : "com.squareup.retrofit2:retrofit:2.9.0",
        converterGson : "com.squareup.retrofit2:converter-gson:2.9.0",
        adapterRxjava2: "com.squareup.retrofit2:adapter-rxjava2:2.9.0"
]

deps.stetho = [
        stetho       : "com.facebook.stetho:stetho:1.5.1",
        stethoOkhttp3: "com.facebook.stetho:stetho-okhttp3:1.5.1"
]

deps.easyprefs = [
        library: "com.pixplicity.easyprefs:library:1.9.0@aar"
]

deps.barcodescanner = [
        zbar : "me.dm7.barcodescanner:zbar:1.9.13",
        zxing: "me.dm7.barcodescanner:zxing:1.9.13"
]

deps.egslava = [
        maskedEditText: "ru.egslava:MaskedEditText:1.0.5"
]

deps.wdullaer = [
        materialDateTimePicker: "com.wdullaer:materialdatetimepicker:4.2.3"
]

deps.pdfviewpager = [
        library: "es.voghdev.pdfviewpager:library:1.1.3"
]

deps.davemorrissey = [
        subsamplingScaleImageView: "com.davemorrissey.labs:subsampling-scale-image-view:3.10.0"
]

deps.fotoapparat = [
        fotoapparat: "io.fotoapparat:fotoapparat:2.7.0"
]

deps.trafi = [
        anchorBottomSheetBehavior: "com.trafi:anchor-bottom-sheet-behavior:0.13-alpha"
]

deps.googleAndroid = [
        flexbox: "com.google.android:flexbox:2.0.1"
]

deps.jakewharton = [
        timber: "com.jakewharton.timber:timber:4.7.1"
]

deps.chaos = [
        pinview: "com.chaos.view:pinview:1.4.4"
]

deps.redmadrobot = [
        inputMaskAndroid: "com.redmadrobot:input-mask-android:6.0.0"
]

deps.chrisbanes = [
        photoView: "com.github.chrisbanes:PhotoView:2.3.0"
]

deps.squareup = [
        leakcanary: "com.squareup.leakcanary:leakcanary-android:2.0-beta-3"
]

deps.sangcomz = [
        fishBun: "com.sangcomz:FishBun:0.11.5"
]

deps.shimmer = [
        shimmer: "com.facebook.shimmer:shimmer:0.5.0"
]

deps.airbnb = [
        lottie: "com.airbnb.android:lottie:3.4.4"
]

deps.kizitonwose = [
        calendarView: "com.github.kizitonwose:CalendarView:0.4.5"
]

deps.eightbitlab = [
        blurView: "com.eightbitlab:blurview:1.6.4"
]

deps.mreram = [
        showcase: "com.github.mreram:showcaseview:1.2.0"
]

deps.detekt = [
        detektCli: "io.gitlab.arturbosch.detekt:detekt-cli:$detektVer",
        detektApi: "io.gitlab.arturbosch.detekt:detekt-api:$detektVer"
]

deps.ashokvarma = [
        bottomNavigationBar: 'com.ashokvarma.android:bottom-navigation-bar:2.2.0'
]

