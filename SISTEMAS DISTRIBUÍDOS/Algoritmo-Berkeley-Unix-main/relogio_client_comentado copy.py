# Reliazamos os import necessarios
import threading  
import socket  
from tempo import Tempo  # Importamos a classe Tempo 
from time import sleep  # Importamos a função sleep que vai ser utilizada  para pausar a execução
from tempo import timeToSeconds, timeToArray  # E Importamos a função de conversão de tempo

#Começamos com a classe cliente 
class Client:
    #ai temos um init que inicializa as propriedades do cliente
    def __init__(self, port):
        self.tempo = Tempo()  # Criamos uma instância da classe Tempo para gerenciar o tempo do relógio
        self.HOST = '127.0.0.1'  # Definimos o endereço IP 127.0.0.1 do host  (localhost)
        self.PORT = port  # Definimos a porta em que este cliente irá escutar
        self.serverPort = 5000  # Definimos a porta 5000 do servidor

        self.setup_server_socket()  # Inicializamos o socket do servidor para ele aceitar conexões

        print(f"Relógio rodando em {self.HOST}:{self.PORT}")  # ai é imprimido uma mensagem informando o endereço e a porta do cliente
        threading.Thread(target=self.clock).start()  # Iniciamos uma thread para executar o método clock em paralelo
        threading.Thread(target=self.receive_server).start() # e ai  Iniciamos uma thread para executar o  receive_server em paralelo

    def setup_server_socket(self): #definimos medotodo setup_server_socket  para que seja  possivel receber conexões 
        self.tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  # Criamos um socket TCP
        self.tcp.bind((self.HOST, self.PORT))  # ai Associamos o socket ao endereço e porta do cliente
        self.tcp.listen()  # e Iniciamos o servidor para aceitar conexões

    # Definimos o método "clock" que atualiza o tempo do relógio do cliente
    def clock(self):
        while True:  # Iniciamos um loop 
            sleep(1)  # Pausamos a execução por 1 segundo
            self.tempo.add_seconds()  # Simulamos o avanço do relógio aumentando os segundos
 # Imprimimos o tempo atual no formato "HH:MM:SS", definimos que seja exibidos com dois dígitos, coloca 0 à esquerda caso seja necessário.
            print(f"Tempo do relógio -> {self.tempo.hora:02}:{self.tempo.minuto:02}:{self.tempo.segundo:02}")

    def send(self): #ai definimos  uma conexão com o servidor e envia o tempo atual do cliente
        print("Enviando tempo")  # Imprime uma mensagem indicando que o tempo está sendo enviado
        client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  # é Cria um novo socket para comunicação
        try: 
            client.connect(("127.0.0.1", self.serverPort)) #tentamos se Conectar com o servidor utilizando o endereço e porta especificados
            time_seconds = timeToSeconds([self.tempo.hora, self.tempo.minuto, self.tempo.segundo])  #Convertemos o tempo atual em segundos
            client.sendall(str.encode(f"{self.PORT},{time_seconds}"))  # Enviamos os dados do cliente  para o servidor
        except: #temos uma exceção que 
            client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  # Em caso de erro na conexão é  criado um novo socket


    def receive_server(self): #Iniaciamos a função receive_server
        while True:  # Iniciamos um loop 
            connection, address = self.tcp.accept()  # Aceitamos uma conexão de outro cliente ou servidor 
            message = connection.recv(1024).decode()  # ai Recebemos uma mensagem da conexão e a decodifica
            if message == "SEND":  # Se a mensagem recebida for "SEND"
                threading.Thread(target=self.send).start()  # vai ser iniciado uma thread para executar o método send em paralelo
            else:
                # ai Calculamos a diferença de tempo com base nas mensagem recebida
                tempo_att = timeToSeconds([self.tempo.hora, self.tempo.minuto, self.tempo.segundo]) - int(message)  
                print(f"Diferença -> {int(message)}")  # Imprimimos a diferença de tempo e 
                print(f"Atualizado para -> {tempo_att}")  # Imprimimos o tempo atualizado após o ajuste
                # e é Atualizado o tempo do cliente com base na diferença calculada
                self.tempo.hora, self.tempo.minuto, self.tempo.segundo = timeToArray(tempo_att)  
