#!/bin/sh

backup_arquivos="/home/aluno/"
destino="/home/aluno/backup/"

hora=30 13 * * 0 backup1.sh
hostname=$(hostname -s)

arquivo="$hostname.tar.gz"

sleep 1s

echo "Realizando backup"

sleep 1s

tar -zcvf $destino/$arquivo $backup_arquivos

sleep 1s

echo "backup realizado com sucesso"
ls -lh $destino


