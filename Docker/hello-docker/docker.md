Docker is platform which packages an application and all its dependencies together in form of containers.

Hardware
    Host OS
        Docker Engine
            Container 1
                Project 1
                Java 8
            Container 2
                Project 2
                Java 11

DockerFile
    Text document which contains all the commands that a user can call on the command line to assemble an image.

Docker Image
    Template to create docker container.

Docker Container
    Running instance of the docker image. Containers hold entire package to run application.

Commands:
    Check Docker version
        docker -v

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
            -d : detach mode (Run in background mode)
    
    Run command in docker container
        docker exec -it <container-id> python3

    Check properties of docker container
        docker inspect <container-id>

    Run mysql container:
        docker run --name dbContainer -e MYSQL_ROOT_PASSWORD=root -d mysql 
    
    Stop a container:
        docker stop <container-name>

    Restart a container:
        docker restart <container-name>

    Build a docker container:
        docker build -t ubuntu-container .