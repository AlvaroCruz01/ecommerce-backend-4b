# Especifica a imagem base
# Instala o Ubuntu com Java e Maven

FROM maven:3.9-eclipse-temurin-21-noble

# Habilita a instalacao nao interativa

ENV DEBIAN_FRONTEND=noninteractive

# Instala as ferramentas que nao estao na imagem base
# apt-get update - Atualiza os repositorios de softwares
# apt-get install - instala as ferramentas
# curl - testa APIs
# git-lfs - armazenamentos de arquivos binarios

RUN apt-get update && apt-get install -y \
    mysql-server-8.0 \
    git \
    git-lfs \
    curl \
    unzip \
    zip \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*
