// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    extra["composeVersion"] = "1.1.4"
    val composeVersion: String by extra

    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.41")
    }
}

plugins {
    id("com.android.application") version "8.1.3" apply false
    id("org.jetbrains.kotlin.android") version "1.6.21" apply false
    id("com.android.library") version "7.1.3" apply false
}