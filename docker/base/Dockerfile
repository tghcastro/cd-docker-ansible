FROM openjdk:8-jdk-alpine
MAINTAINER Thiago de Castro <tghcastro@gmail.com>

ENV TERM=xterm-256color

EXPOSE 8082

RUN mkdir scripts

ADD Scripts/entrypoint.sh /scripts/entrypoint.sh
RUN chmod +x /scripts/entrypoint.sh

WORKDIR /scripts

ENTRYPOINT ["entrypoint.sh"]