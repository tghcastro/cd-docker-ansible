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

    `docker build -t tghcastro/cd-docker-ansible .`

    `docker run -p 7000:8070 -e SPRING_PROFILES_ACTIVE=dev tghcastro/cd-docker-ansible:latest`
    `docker run --entrypoint "/usr/local/bin/entrypoint.sh" tghcastro/cd-docker-ansible:latest`

