Docker in Action:

build busybox: minimal linux container
    docker build -t my-busybox-img .
    docker run my-busybox-img
#######################################################################################################

Docker is platform which packages an application and all its dependencies together in form of containers.

Docker Images vs Docker Container:
    Docker image is an executable application artifact. 
    Single image, multiple containers.

    Docker container is a running instance of an image.

Docker Registry:
    A storage and distribution system for Docker images. For ex: Docker Hub, Amazon ECR, Google Container Registry

Docker Repository:
    Collection of related images with same name but different versions.

Commands:
    Check docker version
        docker -v

    Show docker images:
        docker images

    Pull image from docker hub
        docker pull <image-name>
    
    Check local docker images
        docker images 
    
    Show docker containers
        docker ps
            -a : all
    
    Run docker containers
        docker run --name pythonContainer -d python
            -it : interactive mode
            -evn : environment variables
            -d : detach mode (Detached means that the container will run in background, without being attached to any input or output stream.)
    
    Run command in docker container
        docker exec -it <container-id> python3

    Check properties of docker container
        docker inspect <container-id>
    
    Stop a container:
        docker stop <container-name>

    Restart a container:
        docker restart <container-name>

    Build a docker container:
        docker build -t ubuntu-container .
    
    Docker logs:
        docker logs web-app

Port Binding:
    Port binding is binding the container's port to the host's port to make the service available to
    the outside world.
         docker run -d -p 9000:80  nginx
         docker run --name web-app  -d -p 80:80 nginx
            Run a docker container with nginx image, with name web-app in detached mode, with localhost port 80 binded to docker container port 80