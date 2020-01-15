#!/bin/bash

build() {
  cd "$1" || true
  mvn clean package -Pdeployment
  cd ..
}

build creditrama-team-d-client-service
build creditrama-team-d-authorization-service
build creditrama-team-d-notification-service

cd creditrama-team-d-frontend || true
docker build -t creditrama-d-frontend:0.0.1-SNAPSHOT .
cd ..
