# Debugging Containers

## Show logs of a container

```zsh
docker logs <container-id or container-name>
```

## Run a docker container with a specific name

docker run -d -p6001:6379 --name redis-container redis

## Connect to a container's terminal

docker exec -it redis-container /bin/bash

## print environment variables

env
