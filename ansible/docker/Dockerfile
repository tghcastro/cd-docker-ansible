FROM ubuntu:trusty
MAINTAINER Thiago de Castro <tghcastro@gmail.com>

ENV TERM=xterm-256color

RUN apt-get -qy update && \
    apt-get install -qy software-properties-common && \
    apt-add-repository -y ppa:ansible/ansible && \
    apt-get update -qy && \
    apt-get install -qy ansible

VOLUME /ansible
WORKDIR /ansible

ENTRYPOINT ["ansible-playbook"]
CMD ["site.yml"]