#!/bin/bash

if [[ $1 == "--scenario" ]]; then
  docker-compose run --rm start_dependencies_kafka_database
  docker-compose run --rm start_dependencies_spring
elif [[ $1 == "--greenland" ]]; then
  docker-compose -f greenland.yml run --rm start_dependencies_kafka_database
  docker-compose -f greenland.yml up -d bank
elif [[ $1 == "--france" ]]; then
  docker-compose -f france.yml up -d
else
  docker-compose run --rm start_dependencies_kafka_database
  docker-compose run --rm start_dependencies_spring
  docker-compose up -d frontend
fi
