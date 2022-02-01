#!/bin/bash
gradle build && java -Xmx32m -Xss256k -jar build/libs/SpringBootJava.jar
