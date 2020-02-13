#!/bin/bash

PORT=null
KILL="kill -9 "

get_port() {
  if [[ $1 == *"authorization"* ]]; then
    PORT="9191:9191"
  elif [[ $1 == *"bankaccount"* ]]; then
    PORT="8083:8080"
  elif [[ $1 == *"client"* ]]; then
    PORT="8080:8080"
  elif [[ $1 == *"notification"* ]]; then
    PORT="8081:8080"
  elif [[ $1 == *"transaction"* ]]; then
    PORT="8084:8080"
  elif [[ $1 == *"card"* ]]; then
    PORT="8085:8080"
  else
    echo "This service doesn't have known port"
    exit 1
  fi
}

oc login
oc project al-team-d

PODS=($(oc get pods | sed -n '/^jx-/p' | sed -e 's/\s.*$//'))

for POD in "${PODS[@]}"; do
  get_port "$POD"
  oc port-forward "$POD" "$PORT" >/dev/null 2>&1 &
  KILL+="$! "
done

echo "Execute this to kill the processes : \`$KILL\`"
echo "Tips: check open ports \`sudo netstat -tulpn | grep LISTEN\`"
