#!/bin/bash

if [[ $1 == "--demo" ]]; then
  docker-compose run --rm start_dependencies_kafka_database
  docker-compose run --rm start_dependencies_spring
  docker-compose up demo
else
  docker-compose run --rm start_dependencies_kafka_database
  docker-compose run --rm start_dependencies_spring
  docker-compose up -d frontend
fi
