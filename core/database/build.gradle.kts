plugins {
    id("narutocards.android.library")
    id("narutocards.android.library.jacoco")
    id("narutocards.android.hilt")
    id("narutocards.android.room")
}

android {
    defaultConfig {
//        testInstrumentationRunner =
//            "com.ostapr.narutocards.core.testing.TestRunner"
    }
    namespace = "com.ostapr.narutocards.core.database"
}

dependencies {
    implementation(project(":core:model"))

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)

//    androidTestImplementation(project(":core:testing"))
}
