#!/bin/bash

# Se ocorrer erro o script aborta
set -e

# Exibe mensagem no terminal
echo "Iniciando MySQL..."
# Inicia o MYSQL
service mysql start


echo "Aguardando MySQL ficar pronto..."
# Verifica se o MYSQL ja iniciou 
for tentativa in $(seq 1 30); do
    if mysqladmin ping --silent; then
        echo "MySQL pronto."
        break
    fi
    sleep 1
done

# Se passou das 30 tentativas sem resposta, para o script com erro.
if ! mysqladmin ping --silent; then
    echo "Erro: MySQL não respondeu a tempo." >&2
    exit 1
fi

echo "Configurando banco..."

# Envia o MYSQL os comandos a segui
mysql <<EOF
CREATE DATABASE IF NOT EXISTS ecommerce
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

CREATE USER IF NOT EXISTS 'sergio'@'%' IDENTIFIED BY '123@Mudar';

GRANT ALL PRIVILEGES ON ecommerce.* TO 'sergio'@'%';

FLUSH PRIVILEGES;
EOF

echo "MySQL configurado com sucesso!"
