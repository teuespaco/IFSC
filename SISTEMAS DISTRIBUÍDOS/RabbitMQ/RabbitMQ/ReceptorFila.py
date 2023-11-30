# Importa as bibliotecas necessárias
import pika
from threading import Thread
from tkinter import *

# Define as credenciais do RabbitMQ
rabbitmq_username = "ads"
rabbitmq_password = "ads"

# Função para receber mensagens do RabbitMQ
def receber():
    # Callback para processar mensagens recebidas
    def chamada(ch, method, propreties, body):
        msg_list.insert(END, "Receptor -- " + body.decode())

    try:
        # Tenta estabelecer uma conexão com o servidor RabbitMQ
        connection = pika.BlockingConnection(pika.ConnectionParameters(
            host='localhost',
            port=5672,
            virtual_host='/',
            credentials=pika.PlainCredentials(rabbitmq_username, rabbitmq_password)))

        # Cria um canal de comunicação
        canal = connection.channel()
        # Declara uma fila chamada 'chat2'
        canal.queue_declare(queue='chat2')

        if (canal.basic_consume(queue='chat2', on_message_callback=chamada, auto_ack=True)):
            msg_list.insert(END)

        canal.start_consuming()
        connection.close()
    except Exception as e:
        print("Erro ao se conectar ao RabbitMQ:", e)

# Função para enviar mensagens para o RabbitMQ
def enviar():
    try:
        # Tenta estabelecer uma conexão com o servidor RabbitMQ
        connection = pika.BlockingConnection(pika.ConnectionParameters(
            host='localhost',
            port=5672,
            virtual_host='/',
            credentials=pika.PlainCredentials(rabbitmq_username, rabbitmq_password)))

        # Cria um canal de comunicação
        canal = connection.channel()
        # Declara uma fila chamada 'chat1'
        canal.queue_declare(queue='chat1')

        # Obtém a mensagem do campo de entrada
        mensagem = campo_entrada.get()
        # Insere a mensagem na lista de mensagens
        msg_list.insert(END, "Emissor -- " + mensagem)

        # Publica a mensagem na fila 'chat1'
        canal.basic_publish(exchange='', routing_key='chat1', body=mensagem)
        # Fecha a conexão com o RabbitMQ
        connection.close()

  # Limpar o campo de entrada após o envio
        campo_entrada.delete(0, END)
    except Exception as e:
        print("Erro ao se conectar ao RabbitMQ:", e)

# Cria uma janela tkinter para a interface gráfica do chat
janela = Tk()
janela.title("Chat 2")

# Cria uma lista de mensagens na janela
msg_list = Listbox(janela, height=10, width=50)
msg_list.pack()

# Cria um campo de entrada para digitar mensagens
campo_entrada = Entry(janela, textvariable='') # type: ignore
campo_entrada.pack()

# Cria um botão "Enviar" que chama a função 'enviar' quando clicado
Botao_enviar = Button(janela, text="Enviar", command=enviar)
Botao_enviar.pack()

# Cria threads para receber e enviar mensagens simultaneamente
receive_thread = Thread(target=receber)
sender_thread = Thread(target=enviar)
receive_thread.start()
sender_thread.start()

# Inicia o loop principal da interface gráfica
janela.mainloop()
