# Importa as bibliotecas necessárias
import requests  # Para enviar solicitações HTTP POST
import random    # Para gerar valores aleatórios
import time      # Para adicionar atraso
from datetime import datetime  # Para obter a data e hora atuais

# Inicializa o ID dos dados
dado_id = 0  

# Loop para gerar e enviar dados continuamente
while True:
    # Gera valores aleatórios para temperatura, umidade e luminosidade
    temperatura = random.uniform(0, 45)
    umidade = random.uniform(0, 100)
    luminosidade = random.uniform(0, 100)

    # Incrementa o ID a cada envio de dados
    dado_id += 1

    # Obtém a data e hora atual no formato "YYYY-MM-DD HH:MM:SS"
    horario = datetime.now().strftime("%Y-%m-%d %H:%M:%S")

    # Cria um dicionário com os dados a serem enviados
    dados = {
        'id': dado_id,
        'temperatura': temperatura,
        'umidade': umidade,
        'luminosidade': luminosidade,
        'horario': horario
    }

    # Envia os dados para o servidor local usando uma solicitação POST
    response = requests.post('http://localhost:5000/dados', json=dados)

    # Imprime a resposta do servidor
    print(response.json())

    # Aguarda 10 segundos antes de gerar e enviar o próximo conjunto de dados
    time.sleep(10)
