
plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.10")

    application
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.kodein.di:kodein-di-generic-jvm:6.0.1")

    testImplementation("org.jetbrains.kotlin:kotlin-test")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

application {
    mainClassName = "chess.AppKt"
}
