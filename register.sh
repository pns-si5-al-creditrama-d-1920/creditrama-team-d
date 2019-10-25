#!/bin/bash

if [ "$#" -ne 3 ]; then
  echo "Please provide 3 arguments: sh register.sh #username #password #email"
  exit
fi

username=$1
password=$2
email=$3

curl -X POST \
  http://localhost:8080/register \
  -H "Content-Type: application/json" \
  -d "{
  \"username\": \"$username\",
  \"password\": \"$password\",
  \"email\": \"$email\"
}"
