# Build own docker image

## Image Layers

    app:1.0
    node:13-alpine
    alpine:3.10

## build docker image

    docker build -t my-app:1.0 .

## run docker container

    docker run my-app:1.0

## connect to container

    docker exec -it 78fe2d2de9a03111c87f9a0d6c8641d7d2cf34607ebb19be520454216ba69752 /bin/sh

## rename docker image

    docker tag
