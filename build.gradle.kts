plugins {
	java
	id("org.springframework.boot") version "3.4.3"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "ochat"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
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
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation ("com.google.api-client:google-api-client:1.33.2")
	implementation("com.google.apis:google-api-services-drive:v3-rev197-1.25.0")
	implementation("com.google.http-client:google-http-client-jackson2:1.43.3")
	implementation("com.google.auth:google-auth-library-oauth2-http:1.22.0")
	implementation("com.google.http-client:google-http-client-gson:1.43.3")


}

tasks.withType<Test> {
	useJUnitPlatform()
}
