# Docker Volumes

Containers by default have no persistence.

## Mount local storage to container storage

docker run -v /home/mount/data:/var/lib/mysql/data

## Anonnymous volumes : Mounts default local storage folder to container storage

docker run -v /var/lib/mysql/data
default local dir is /var/lib/docker/volumes/random-hash/_data

## Named volumes

docker run -v name:/var/lib/mysql/data
