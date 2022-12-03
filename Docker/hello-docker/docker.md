# DOCKER
Docker is a platform for consistently building, running and shipping applications.

Container is a runnable instance of an image.

# Docker version
docker version 

# Show container
docker ps
-a for showing all running and stopped container

# run docker container
docker run <container-id>

# Port  binding (Binds laptop's 6000 port to application's 6379 port)
docker run -p6000:6379 redis

# pull an image from docker hub
docker pull codewithmosh/hello-docker

# check image available in local machine
docker image ls

# run docker image
docker run codewithmosh/hello-docker
-d for detached mode

# pull linux image from docker hub and run it locally (-it flag is for interative)
docker run -it ubuntu

# docker-compose version
docker-compose --version

# remove docker images
docker image <image-id>

# remove all docker images (-f for force remove even running containers)
docker container rm -f $(docker container ls -aq)