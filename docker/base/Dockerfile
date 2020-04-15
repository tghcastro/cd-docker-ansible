FROM openjdk:8
MAINTAINER Thiago de Castro <tghcastro@gmail.com>

ENV TERM=xterm-256color

EXPOSE 8080

COPY Scripts/entrypoint.sh /usr/local/bin/entrypoint.sh

RUN chmod +x /usr/local/bin/entrypoint.sh

ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]