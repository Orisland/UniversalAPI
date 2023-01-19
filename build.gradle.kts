plugins {
    val kotlinVersion = "1.7.10"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("net.mamoe.mirai-console") version "2.13.3"
}

group = "top.orisland"
version = "0.1.0"

repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.0")
    implementation("com.fasterxml.jackson.core:jackson-core:2.14.0")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.14.0")
    runtimeOnly("com.lmax:disruptor:3.4.4")

    api("net.mamoe.yamlkt:yamlkt-jvm:0.10.2")
    testImplementation("junit:junit:4.13.2")
    implementation("org.projectlombok:lombok:1.18.24")
    implementation("cn.hutool:hutool-core:5.8.11")

    annotationProcessor("org.projectlombok:lombok:1.18.24")
    // https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp
    implementation("com.squareup.okhttp3:okhttp:4.10.0")

}
