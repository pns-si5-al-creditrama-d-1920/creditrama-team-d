#!/bin/bash

build() {
  cd "$1" || true
  mvn clean package -Pdeployment
  if [[ "$?" -ne 0 ]]; then
    cd ..
    exit 1
  fi
  cd ..
}

build creditrama-team-d-authorization-service
build creditrama-team-d-bankaccount-service
build creditrama-team-d-client-service
build creditrama-team-d-notification-service
build creditrama-team-d-transaction-service

cd creditrama-team-d-frontend || true
docker build -t creditrama-d-frontend:0.0.2-SNAPSHOT .
cd ..
