#!/bin/bash
docker network inspect mongo-net >/dev/null 2>&1 || docker network create -d bridge mongo-net
docker compose -f mongodb/docker-compose.mongo.yaml up -d
docker compose -f mongo-express/docker-compose.express.yaml up -d
docker compose -f mongo-shell/docker-compose.shell.yaml up -d

