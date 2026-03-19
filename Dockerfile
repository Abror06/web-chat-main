FROM ubuntu:22.04
LABEL authors="Asqarov Abror"

RUN apt-get update && \
    apt-get install -y --no-install-recommends procps && \
    rm -rf /var/lib/apt/lists

ENTRYPOINT ["top", "-b"]