#!/bin/bash

echo "Env:$ENV"

mvn clean install

exec java -jar -Dspring.profiles.active=CI target/cd-docker-ansible-1.0.0.jar



