import socket
import tkinter as tk


class App:
    def __init__(self, master):
        self.master = master
        master.title("Adivinhe o número")

        self.label = tk.Label(
            master, text="Tente adivinhar um número de 1 a 20. Você tem 10 tentativas.")
        self.label.pack()

        self.number_entry = tk.Entry(master)
        self.number_entry.pack()

        self.guess_button = tk.Button(
            master, text="Chutar", command=self.make_guess)
        self.guess_button.pack()

        self.result_label = tk.Label(master, text="")
        self.result_label.pack()

        self.play_again_button = tk.Button(
            master, text="Jogar novamente", command=self.play_again)
        self.play_again_button.pack()

        self.quit_button = tk.Button(master, text="Sair", command=master.quit)
        self.quit_button.pack()

        self.client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.client_socket.connect(('localhost', 8000))

        self.num_guesses = 0

    def make_guess(self):
        palpite = self.number_entry.get()
        self.client_socket.send(palpite.encode('utf-8'))

        resultado = self.client_socket.recv(1024)
        resultado = resultado.decode('utf-8')

        self.num_guesses += 1

        if resultado == 'Maior':
            self.result_label.config(text=" ► Tente um número maior.")
        elif resultado == 'Menor':
            self.result_label.config(text=" ► Tente um número menor.")
        elif resultado == 'Ganhou':
            self.result_label.config(
                text="Parabéns! Você ganhou em {} tentativas.".format(self.num_guesses))
            self.client_socket.close()
            self.guess_button.config(state="disabled")
        elif resultado == 'Perdeu':
            self.result_label.config(
                text="Você perdeu o jogo.")
            self.client_socket.close()
            self.guess_button.config(state="disabled")
        elif resultado == 'Empate':
            self.result_label.config(text="Empate! \n Nenhum jogador venceu.")
            self.client_socket.close()
            self.guess_button.config(state="disabled")

        if self.num_guesses == 10:
            self.result_label.config(
                text="Você atingiu o limite de tentativas.")

    def play_again(self):
        self.number_entry.delete(0, tk.END)
        self.result_label.config(text="")
        self.num_guesses = 0
        self.guess_button.config(state="normal")
        self.client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.client_socket.connect(('localhost', 8000))


root = tk.Tk()
app = App(root)
root.mainloop()
