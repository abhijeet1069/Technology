# Docker Commands

## Image and Container

Container is a running environment for image.

## Run Containers

The *docker run* command creates and starts a new container each time you execute it.
Image is found locally else globally.  

## Show images on my machine

docker images

## Show containers

docker ps
-a : all containers status

## Pull redis image from docker hub

docker pull redis
docker run redis
docker run redis:4.0

## Binds local port 6000 to port 6379

docker run -p6000:6379
