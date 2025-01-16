import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    `maven-publish`
    signing
    id("com.vanniktech.maven.publish") version "0.30.0"
}

android {
    namespace = "io.github.bmendli"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.github.bmendli"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates("io.github.bmendli", "mendli-test", "0.0.1")

    pom {
        packaging = "jar"
        name.set("mendli-test")
        url.set("https://github.com/bmendli/mendli-test")
        description.set("")

        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        scm {
            connection.set("scm:https://github.com/bmendli/mendli-test.git")
            developerConnection.set("scm:git@github.com:bmendli/mendli-test.git")
            url.set("https://github.com/bmendli/mendli-test")
        }

        developers {
            developer {
                id.set("bmendli")
                name.set("Bogdan Mashchenko")
                email.set("mashchenko.bogdan2016@gmail.com")
            }
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}