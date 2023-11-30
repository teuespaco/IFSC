import socket

RED   = "\033[1;31m"
GREEN = "\033[1;32m"
YELLOW = "\033[1;33m"
RESET = "\033[0;0m"

def main():
    while True:

        print("\n")
        print("Tente adivinhar um número de 1 a 20. Você tem 10 tentativas. \n")
        print("╔══════════ ❖ ══════════╗ ")

        # Conecta com o servidor
        client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        client_socket.connect(('10.0.0.119', 8000))

        for i in range(10):
            guess = input(" Digite um número: ")
            client_socket.send(guess.encode('utf-8'))

            result = client_socket.recv(1024)
            result = result.decode('utf-8')

            if result == 'Maior':
                print(" ► Tente um número maior.")
            elif result == 'Menor':
                print(" ► Tente um número menor.")
            elif result == 'Ganhou':
                print(GREEN + " Parabéns! Você ganhou." + RESET) 
                print("╚══════════ ❖ ══════════╝")
                client_socket.close()
                break
            elif result == 'Perdeu':
                print(RED + " Você perdeu o jogo." + RESET)
                print("╚══════════ ❖ ══════════╝")
                client_socket.close()
                break
            elif result == 'Empate':
                print(YELLOW + " Empate! \n Nenhum jogador venceu." + RESET)
                print("╚══════════ ❖ ══════════╝ \n")
                client_socket.close()
                break

        play_again = input("◈ Deseja jogar novamente? (s/n) ").lower()
        while play_again not in ['s', 'n']:
            play_again = input(
                "◈ Opção inválida. Deseja jogar novamente? (s/n) ").lower()

        if play_again == 'n':
            break


if __name__ == '__main__':
    main()


