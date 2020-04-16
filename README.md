## Pluralsight [Continuous Delivery Using Docker And Ansible](https://app.pluralsight.com/library/courses/docker-ansible-continuous-delivery)

App created based on the following article:

* [Docker : Zero to Hero (with SpringBoot + Postgres)](https://medium.com/@isurunuwanthilaka/docker-zero-to-hero-with-springboot-postgres-e0b8c3a4dccb)

### Requirements

- Java
- Docker

### Some commands

* Maven

    `mvn clean install`

* Docker
    
    Tips
    `docker ps -a -q | % { docker rm $_ }`
    `docker images -a -q | %{ docker rmi $_ }`
    
    Base Image
    `docker build -t tghcastro/cd-docker-ansible -f docker/base/Dockerfile .`
    
    Tests Image
    `docker build -t tghcastro/cd-docker-ansible-tests -f docker/tests/Dockerfile .`
    `docker run -v /tmp/maven:/root/.m2/ --rm --name testsenv --entrypoint true tghcastro/cd-docker-ansible-tests:latest`
    `docker run -v /tmp/maven:/root/.m2/ --rm --name testsenv tghcastro/cd-docker-ansible-tests:latest`


