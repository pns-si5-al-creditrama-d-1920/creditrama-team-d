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

cd creditrama-team-d-authorization-service
mvn jib:dockerBuild -Dimage="creditrama-team-d-authorization-service:demo"
cd ..
cd creditrama-team-d-bankaccount-service
mvn jib:dockerBuild -Dimage="creditrama-team-d-bankaccount-service:demo"
cd ..
cd creditrama-team-d-client-service
mvn jib:dockerBuild -Dimage="creditrama-team-d-client-service:demo"
cd ..
cd creditrama-team-d-notification-service
mvn jib:dockerBuild -Dimage="creditrama-team-d-notification-service:demo"
cd ..
cd creditrama-team-d-transaction-service
mvn jib:dockerBuild -Dimage="creditrama-team-d-transaction-service:demo"
cd ..

cd creditrama-team-d-card-service
mvn jib:dockerBuild -Dimage="creditrama-team-d-card-service:demo"
cd ..

#cd creditrama-team-d-frontend || true
#docker build -t creditrama-d-frontend:demo .
#cd ..
