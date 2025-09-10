import org.asciidoctor.gradle.jvm.AsciidoctorTask

plugins {
    java
    id("org.springframework.boot") version "3.5.4"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.asciidoctor.jvm.convert") version "4.0.4"
}

group = "live.b"
version = "0.0.1-SNAPSHOT"

val snippetsDir by extra { file("build/generated-snippets") }

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
    outputs.dir(snippetsDir)
}

tasks.withType<AsciidoctorTask> {
    dependsOn(tasks.test)
    attributes(mapOf("snippets" to snippetsDir))
    inputs.dir(snippetsDir)
}

tasks.bootJar {
    dependsOn("asciidoctor")
    from("build/docs/asciidoc") {
        into("BOOT-INF/classes/static/docs")
    }
}

tasks.named<Jar>("jar") {
    enabled = false
}
