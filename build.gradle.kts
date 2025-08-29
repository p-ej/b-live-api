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

    // 기존에 존재하는 Docs 삭제(문서 최신화를 위해)
    doFirst {
        delete(file("src/main/resources/static/docs"))
    }

    // snippet Directory 설정
    attributes(mapOf("snippets" to snippetsDir))

    // Ascii Doc 파일 생성
    doLast {
        copy {
            from("build/docs/asciidoc")
            into("src/main/resources/static/docs")
        }
    }
}
tasks.build {
    dependsOn(tasks.asciidoctor)
}

tasks.named<Jar>("jar") {
    enabled = false
}
