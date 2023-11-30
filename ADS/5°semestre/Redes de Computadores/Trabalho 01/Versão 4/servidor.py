
import socket
import random


def play_game(player1, player2):
    number = random.randint(1, 20)
    print("O número a ser adivinhado é: ", number)

    for i in range(10):
        guess1 = player1.recv(1024)
        guess1 = int(guess1.decode('utf-8'))

        guess2 = player2.recv(1024)
        guess2 = int(guess2.decode('utf-8'))

        print(f"Jogador 1: {guess1} | Jogador 2: {guess2}")

        if guess1 == number and guess2 == number:
            player1.send(b'Empate')
            player2.send(b'Empate')
            return
        elif guess1 == number:
            player1.send(b'Ganhou')
            player2.send(b'Perdeu')
            return
        elif guess2 == number:
            player1.send(b'Perdeu')
            player2.send(b'Ganhou')
            return
        else:
            if guess1 < number and guess2 < number:
                player1.send(b'Maior')
                player2.send(b'Maior')
               
            elif guess1 > number and guess2 > number:
                player1.send(b'Menor')
                player2.send(b'Menor')
            if guess1 > number and guess2 < number:
                player1.send(b'Menor')
                player2.send(b'Maior')
            elif guess1 < number and guess2 > number:
                player1.send(b'Maior')
                player2.send(b'Menor')

                return

    player1.send(b'Perdeu')
    player2.send(b'Perdeu')


def main():
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind(('10.0.0.119', 8000))
    server_socket.listen(2)

    print("Aguardando conexão de dois jogadores...")

    while True:
        (player1, address1) = server_socket.accept()
        print("Jogador 1 conectado de ", address1)

        (player2, address2) = server_socket.accept()
        print("Jogador 2 conectado de ", address2)

        play_game(player1, player2)

if __name__ == '__main__':
    main()



