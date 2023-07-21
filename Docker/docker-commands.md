# Image and Container:
    Container is a running environment for image.

# show images on my machine
    docker images
    

# show containers
    docker ps
    -a : all containers status

# pull redis image from docker hub
    docker pull redis
    docker run redis
    

# runs redis:4.0 image locally. if not found locally, downloads from internet and runs locally.
    docker run redis:4.0
    
# binds local port 6000 to port 6379
    docker run -p6000:6379
    