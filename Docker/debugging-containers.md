# show logs of a container
    docker logs <container-id or container-name>

# run a docker container with a specific name
    docker run -d -p6001:6379 --name redis-container redis
    
# connect to a container's terminal
    docker exec -it redis-container /bin/bash
    
# print environment variables
    env