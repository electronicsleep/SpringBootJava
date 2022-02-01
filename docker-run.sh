#!/bin/bash
set -e
gradle build
set +e
docker rm springbootjava
set -e
docker build -t springbootjava .
docker run -t -p 8080:8080 --name springbootjava -it springbootjava
