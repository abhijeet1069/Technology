Image and Container:
    Container is a running environment for image.

docker images
    show images on my machine

docker ps
    show containers
    -a : all containers status

docker pull redis
docker run redis
    pull redis image from docker hub

docker run redis:4.0
    runs redis:4.0 image locally. if not found locally, downloads from internet and runs locally.

docker run -p6000:6379
    binds local port 6000 to port 6379