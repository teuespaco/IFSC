import socket
import random

# Função para calcular a exponenciação modular (a^b mod m)
def exp_modular(a, b, m):
    result = 1
    a = a % m
    while b > 0:
        if b % 2 == 1:
            result = (result * a) % m
        b = b // 2
        a = (a * a) % m
    return result

# Parâmetros compartilhados entre as partes (geralmente públicos)
p = 23  # Número primo
g = 5   # Raiz primitiva de p

# Criando um socket do servidor
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.bind(('127.0.0.1', 12345))
server_socket.listen(1)

print("Aguardando conexão do cliente...")
client_socket, addr = server_socket.accept()

# Chave secreta da primeira parte
a = random.randint(1, 10)  # Gerando uma chave privada aleatória

# Enviando a chave pública para o cliente
A = exp_modular(g, a, p)
client_socket.send(str(A).encode())

# Recebendo a chave pública do cliente
B = int(client_socket.recv(1024).decode())

# Cálculo da chave compartilhada
s1 = exp_modular(B, a, p)

print("Chave compartilhada com o cliente:", s1)

# Fechando os sockets
client_socket.close()
server_socket.close()
