plugins {
    java
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.5"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-mail:3.1.3")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:3.1.3")
    implementation("org.springframework.modulith:spring-modulith-test:1.0.0")
    implementation("org.springframework.modulith:spring-modulith-api:1.0.0")
    implementation("org.springframework.modulith:spring-modulith-bom:1.0.0")
    implementation("org.springframework.modulith:spring-modulith-docs:1.0.0")
    implementation("org.springframework.security:spring-security-crypto:6.1.3")
    implementation("javax.servlet:javax.servlet-api:4.0.1")
    implementation("com.talanlabs:avatar-generator:1.1.0")
    implementation("com.sun.mail:javax.mail:1.6.2")
    implementation ("com.auth0:java-jwt:4.2.1")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("com.mysql:mysql-connector-j")
    //developmentOnly("org.springframework.boot:spring-boot-docker-compose")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
