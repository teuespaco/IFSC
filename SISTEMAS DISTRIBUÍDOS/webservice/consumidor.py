import requests

def exibir_dados(dados):
    if not dados:
        print("Nenhum dado disponível.")
    else:

        for dado in dados:
            if 'mensagem' in dado:
                print(dado['mensagem'])
            else:
                print(f"id: {dado['id']}")
                print(f"Temperatura: {dado['temperatura']}°C")
                print(f"Umidade: {dado['umidade']}%")
                print(f"Luminosidade: {dado['luminosidade']}")
                print(f"Horario: {dado['horario']}")
                if 'horario' in dado:
                    print(f"Horario: {dado['horario']}")
                else:
                    print("Não há horário válido")
def main():
    while True:
        print("\nEscolha uma operação:")
        print("0. Sair")
        print("1. Todos os dados")
        print("2. Obter último dado")
        print("3. Deletar dado por ID")
        print("4. Atualizar dado por ID")
        print("5. Visualizar dado por ID")
        print("6. Visualizar dado por data e hora")

        opcao = input("Opção: ")

        if opcao == '0':
            break
        elif opcao == '1':
            response = requests.get('http://localhost:5000/dados/todos')
            dados = response.json()
            exibir_dados(dados)
        elif opcao == '2':
            response = requests.get('http://localhost:5000/dados')
            dado = response.json()
            exibir_dados([dado])  
        elif opcao == '3':
            dado_id = input("Informe o ID do dado que deseja excluir: ")
            response = requests.delete(f'http://localhost:5000/dados/{dado_id}')
            resultado = response.json()
            print(resultado['mensagem'])
        elif opcao == '4':
            dado_id = input("Informe o ID do dado que deseja atualizar: ")
            novo_temperatura = float(input("Nova temperatura: "))
            novo_umidade = float(input("Nova umidade: "))
            novo_luminosidade = int(input("Nova luminosidade: "))
            novo_horario = input("Novo horário (YYYY-MM-DD HH:MM:SS): ")
            dados = {
                "temperatura": novo_temperatura,
                "umidade": novo_umidade,
                "luminosidade": novo_luminosidade,
                "horario": novo_horario
            }
            response = requests.put(f'http://localhost:5000/dados/{dado_id}', json=dados)
            resultado = response.json()
            print(resultado['mensagem'])
        elif opcao == '5':
            dado_id = input("Informe o ID do dado que deseja visualizar: ")
            response = requests.get(f'http://localhost:5000/dados/{dado_id}')
            dado = response.json()
            exibir_dados([dado]) 
        elif opcao == '6':
            datahora = input("Informe a data e hora (YYYY-MM-DD HH:MM:SS): ")
            response = requests.get(f'http://localhost:5000/dados/datahora?datahora={datahora}')
            dados = response.json()
            exibir_dados(dados)
        else:
            print("Opção inválida. Tente novamente.")

if __name__ == '__main__':
    main()