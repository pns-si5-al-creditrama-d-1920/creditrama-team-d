#!/bin/bash

sh deploy.sh --scenario

cd demo-scenario || true
mvn clean test
cd ..

docker-compose down
