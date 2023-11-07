plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    //Immutable Collections
    implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.6")
}