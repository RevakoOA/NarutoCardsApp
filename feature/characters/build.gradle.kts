plugins {
    id("narutocards.android.feature")
    id("narutocards.android.library.compose")
    id("narutocards.android.library.jacoco")
}

android {
    namespace = "com.ostapr.narutocards.feature.characters"
}

dependencies {
    implementation(project(":core:model"))
    implementation(libs.kotlinx.datetime)
    implementation(libs.androidx.activity.compose)
    implementation(libs.accompanist.permissions)
}
