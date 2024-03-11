import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("plugin.serialization") version "1.9.23"
    kotlin("jvm") version "1.9.22"

    id("com.github.johnrengelman.shadow") version "8.1.1"

    id("maven-publish")
}

group = "net.simpletimer.fanbox_supporter_api"
version = "1.1.1"

repositories {
    mavenCentral()
}

dependencies {
    //HTTPのリクエスト
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.12.0"))
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    //Jsonの解析
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")

    //環境変数ファイルの取得
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")

    //コルーチン
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core", "1.7.3")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveBaseName.set("fanbox_supporter_api_kt")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                from(components["kotlin"])
                artifact(tasks["shadowJar"])
            }
        }
    }
}