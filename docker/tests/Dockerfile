FROM tghcastro/cd-docker-ansible:latest

ENV ENV=CI
ENV SPRING_PROFILES_ACTIVE=CI

RUN apt-get -y update && \
    apt-get -y install maven && \
    mvn --version

VOLUME /root/.m2/

RUN mkdir /app
COPY . /app
WORKDIR /app

COPY docker/tests/scripts/entrypoint.sh /usr/local/bin/entrypoint.sh
RUN chmod +x /usr/local/bin/entrypoint.sh
ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]

