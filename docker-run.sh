#!/bin/bash
set +e
docker rm springbootjava
set -e
gradle build
docker build -t springbootjava .
docker run -t -p 8080:8080 --name springbootjava -it springbootjava
