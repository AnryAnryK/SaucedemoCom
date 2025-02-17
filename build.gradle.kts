plugins {
    id("java")
    id("io.qameta.allure") version "2.12.0" //для Аллюр- отчётов
}

group = "AnryAnryK.com.GitHub"
version = "1.0-SNAPSHOT"

allure {
    report {
        version.set("2.19.0")
    }
    adapter { // отвечает за появление папки build/allure-results
        aspectjWeaver.set(true) //обработка аннотации @Step
        frameworks {
            junit5 { //название фреймворка
                adapterVersion.set("2.19.0") //версия интеграции фреймворка и Allure
            }
        }
    }
}


repositories {
    mavenCentral()
}


dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1") //JUnit5  - !!! это АГРЕГАТОР (он включает в себя 1-ю и 2-ю минимально необходимые зависимости, т.е. можно ТОЛЬКО ЕГО ИСПОЛЬЗОВАТЬ !!!)
    testImplementation("com.codeborne:selenide:7.5.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0") //для Аллюр- отчётов
    testImplementation("io.qameta.allure:allure-selenide:2.19.0") //для Аллюр- отчётов
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0") //для Аллюр- отчётов
    testImplementation("io.rest-assured:rest-assured:5.5.0") //для тестирования Rest Api
    testImplementation("com.github.javafaker:javafaker:1.0.2")  //javaFaker
//    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")  // Jackson (Databind) (для тестов с LoginBodyModel)
    testImplementation("com.google.code.gson:gson:2.12.1")  // gson как альтернатива Jackson (Databind) - для тестов в package MestoPraktikumApiTests.models  именно он исправил ошибку, которая возниками при использовании Jackson (Databind)
    testImplementation("org.assertj:assertj-core:3.27.3")  // assertj (для тестов с LoginResponseModel для AssertThat)
    compileOnly("org.projectlombok:lombok:1.18.36")  //lombok
}

tasks.test {
    useJUnitPlatform()
//    systemProperties(System.getProperties()) //для Аллюр- отчётов
}
