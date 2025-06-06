plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

java {
    toolchain {
        vendor = JvmVendorSpec.JETBRAINS
        languageVersion = JavaLanguageVersion.of(17)
    }
}

kotlin {
    jvmToolchain {
        vendor = JvmVendorSpec.JETBRAINS
        languageVersion = JavaLanguageVersion.of(17)
    }

    jvm("desktop")

    sourceSets {
        commonMain.dependencies {
            implementation(project(":composetheme"))
            implementation(project(":composetheme-material3"))
            implementation(compose.material3)
            implementation(project(":composetheme-material"))
            implementation(compose.material)

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.ui)
            implementation(compose.components.resources)
        }
        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.common)
                implementation(compose.desktop.currentOs)
            }
        }
    }
}
compose.desktop {
    application {
        mainClass = "MainKt"
    }
}
