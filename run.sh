#!/bin/bash

function rmContainers() {
  docker-compose rm -fv $SERVICE_NAME || true
}

CONTAINERS=(monitor zeebe db)

for i in "${!CONTAINERS[@]}"
do
   SERVICE_NAME=${CONTAINERS[$i]} rmContainers
done

docker-compose pull
echo "starting containers"
docker-compose up
