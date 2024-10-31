plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17

}
tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java) {
    kotlinOptions {
        jvmTarget = "17" // JVM hedef versiyonunu ayarla
        freeCompilerArgs += "-Xallow-unstable-dependencies"
    }
}

dependencies {
    implementation(libs.ktlint.core)
}
