# Importa a classe Client do módulo relogio_client e o módulo sys
from relogio_client import Client 
import sys  

# Definimos a função principal que será chamada quando o codigo for executado
def main(args):
    # Ai temos uma verifição para ver  se o número de argumentos é igual a 1
    if len(args) == 1:
        # Se for igual a 1, convertemos o argumento para um número inteiro (porta)
        port = int(args[0])
        # ai Criamos uma instância da classe Client, passando a porta do servidor como argumento
        client = Client(port)
    else:
        # Caso tenha algo errado damos a mensgaem informando que a execução não foi feita corretamente  
        print("Usage: python main.py <port>")

# Verificamos se o arquivo que está sendo executado
if __name__ == '__main__':
# Chama a função main, passando os argumentos
    main(sys.argv[1:])
