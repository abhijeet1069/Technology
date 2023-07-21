# configure DB
    docker pull mongo
    docker pull mongo-express

# Docker network:
    show docker network
        docker network ls

    create new network
        docker network create mongo-network

# Run MongoDB container:
    docker run -p 27017:27017 -d -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=password --name mongodb --net mongo-network  mongo

# Run MongoDB express container:
    docker run -d \
    > -p 8081:8081 \
    > -e ME_CONFIG_MONGODB_ADMINUSERNAME=admin \
    > -e ME_CONFIG_MONGODB_ADMINPASSWORD=password \
    > --net mongo-network \
    > --name mongo-express \
    > -e ME_CONFIG_MONGODB_SERVER=mongodb \
    > mongo-express

# Run web-app locally:
    cd techworld-js-docker-demo-app/app
    pwd
    npm install
    npm run
    node server.js
