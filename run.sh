#!/bin/bash
gradle clean test --info
gradle build && java -Xmx32m -Xss256k -jar build/libs/SpringBootJava.jar
